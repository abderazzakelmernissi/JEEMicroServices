package org.sid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	//a chaque fois tu recoit un microservice, regard dans l uri tu trouve le nom de microservice
	  @Bean 
	  DiscoveryClientRouteDefinitionLocator
	  definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) { 
		  
		  return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	  
	  }
	 
	 
//	  @Bean RouteLocator routeLocator(RouteLocatorBuilder builder) { return
//	  builder.routes()
//	  .route((r)->r.path("/enseignants/**").uri("http://localhost:4001/"))
//	  .route((r)->r.path("/annonces/**").uri("http://localhost:4002")) .build(); }
//	 
//	
	
	


}
