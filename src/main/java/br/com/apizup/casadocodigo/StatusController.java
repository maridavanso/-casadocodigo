package br.com.apizup.casadocodigo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	@GetMapping(value = "/api/test")
	public String test() {
		return "tudo show";
	}

}
