package br.com.cp.comparefacilrest;

import br.com.cp.comparefacilrest.controller.PessoaController;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import br.com.cp.comparefacilrest.service.PessoaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {PessoaController.class, PessoaService.class, PessoaRepository.class})
@SpringBootApplication

public class ComparefacilRestApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(ComparefacilRestApplication.class, args);
	}
}
