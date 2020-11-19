package hu.W8YSQV.springbootweb.W8YSQVSpringBootWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("/welcome")
	public String index() {
		return "Hello Spring Boot web world!";
	}
	@GetMapping("/hello/{nev}")
	public String NeptunkodHello(@PathVariable String nev) {
		return "Hello, "+nev;
	}
	@GetMapping("/add")
	public String add() {
		return "10+20="+(10+20);
	}
}
