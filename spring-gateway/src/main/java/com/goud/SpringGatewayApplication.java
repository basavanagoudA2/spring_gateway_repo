package com.goud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringGatewayApplication {

		@Bean
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			return builder.routes()
					.route("path_route", r -> r.path("/bm/dept/**")
							.uri("http://httpbin.org"))
					.build();
		}


	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

}
