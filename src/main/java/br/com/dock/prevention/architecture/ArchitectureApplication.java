package br.com.dock.prevention.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({
//		"br.com.dock.prevention.architecture.domain.usecase",
//		"br.com.dock.prevention.architecture.infrastructure.transport.rest"
//})
@SpringBootApplication
public class ArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchitectureApplication.class, args);
	}

}
