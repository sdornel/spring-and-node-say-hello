package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class HelloController {
	private final WebClient webClient;
	private String nodeApiUrl = "http://localhost:3000/receiveAndSendHello";

	HelloController(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(nodeApiUrl).build();
	}
    @GetMapping("/hello")
    public String sayHello() {
		String nodeApiData =  webClient.get().retrieve().bodyToMono(String.class).block();
        return "Receiving back spring plus node data! " + nodeApiData;
    }

	@GetMapping("/sendHelloToNode")
	public String sayHi() {
		return "Hello, World from Spring Boot!";
	}
}