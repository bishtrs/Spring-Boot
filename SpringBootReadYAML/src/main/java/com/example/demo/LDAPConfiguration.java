package com.example.demo;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("ldap")
public class LDAPConfiguration {

	private String url;
	private String protocol;
	private String bindDN;
	private List<String> baseFilters;
	private List<Server> servers;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getBindDN() {
		return bindDN;
	}

	public void setBindDN(String bindDN) {
		this.bindDN = bindDN;
	}

	public List<String> getBaseFilters() {
		return baseFilters;
	}

	public void setBaseFilters(List<String> baseFilters) {
		this.baseFilters = baseFilters;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	@Override
	public String toString() {
		return "LDAPConfiguration [url=" + url + ", protocol=" + protocol
				+ ", bindDN=" + bindDN + ", baseFilters=" + baseFilters
				+ ", servers=" + servers + "]";
	}

}
