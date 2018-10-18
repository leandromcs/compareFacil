package br.com.cp.comparefacilrest;

import br.com.cp.comparefacilrest.controller.UserController;
import br.com.cp.comparefacilrest.repository.UserRepository;
import br.com.cp.comparefacilrest.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackageClasses = {UserController.class, UserService.class, UserRepository.class})
@SpringBootApplication


public class ComparefacilRestApplication {

	public static void main(String[] args) {
				SpringApplication.run(ComparefacilRestApplication.class, args);
	}
}
