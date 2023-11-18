package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductClientController {

	private final WebClient webClient;

	@Autowired
	public ProductClientController(WebClient webClient) {
		this.webClient = webClient;
	}

	@GetMapping("/{id}")
	public Mono<Product> getProduct(@PathVariable("id") String id) {
        Mono<Product> product = webClient
            .get()
            .uri("/products/{id}", id)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, response -> Mono.just(new RuntimeException("data not found")))
            .bodyToMono(Product.class);
        return product;
    }

	
	@PostMapping("/")
	public Mono<Product> addProduct(@RequestBody Product product) {
		Mono<Product> newProduct = webClient.post().uri("/products/").bodyValue(product).retrieve().bodyToMono(Product.class);
		newProduct.subscribe(System.out::println);
		return newProduct;
	}
	
	@DeleteMapping("/{id}")
	public Mono<Product> deleteProduct(@PathVariable("id") String id) {
		Mono<Product> deletedProduct = webClient.delete().uri("/products/{id}", id).retrieve().bodyToMono(Product.class);
		deletedProduct.subscribe(System.out::println);
		return deletedProduct;
	}

}
