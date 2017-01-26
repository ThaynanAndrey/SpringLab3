package br.com.listadetarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.com.listadetarefas.model")
@EnableJpaRepositories(basePackages = "br.com.listadetarefas.repository")
@SpringBootApplication(scanBasePackages = "br.com.listadetarefas")
public class ListaDeTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaDeTarefasApplication.class, args);
	}
}
