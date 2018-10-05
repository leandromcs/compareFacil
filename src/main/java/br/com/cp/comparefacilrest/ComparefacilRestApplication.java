package br.com.cp.comparefacilrest;

import br.com.cp.comparefacilrest.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackageClasses = { UserController.class })
@SpringBootApplication


public class ComparefacilRestApplication {

	public static void main(String[] args) {
				SpringApplication.run(ComparefacilRestApplication.class, args);
	}
}
