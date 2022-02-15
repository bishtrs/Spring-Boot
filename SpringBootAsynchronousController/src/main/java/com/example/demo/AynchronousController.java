package com.example.demo;

import java.util.concurrent.Callable;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AynchronousController {
	
	private final TaskExecutor taskExecutor; 
	
	public AynchronousController(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

    @GetMapping()
    public Callable<String> hello() {
        return () -> {
            Thread.sleep(2000); // simulate time consuming call
            return "Hello Aynchronous Controller";
        };
    }
	
	/*@GetMapping()
    public CompletableFuture<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
            delay(2000); // simulate time consuming call
            return "Hello Aynchronous Controller";
        }, taskExecutor );
    }*/
	
	private void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}        
    
