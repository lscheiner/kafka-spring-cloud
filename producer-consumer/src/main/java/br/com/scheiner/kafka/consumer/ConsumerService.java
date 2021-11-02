package br.com.scheiner.kafka.consumer;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@Bean
	public Consumer<Employee> receive() {
		return employee -> log.info("Recebido do consumer: " + employee);
	}

	@Bean
	public Function<Employee, String> uppercase() {
		return employee -> {
			log.info("Reebido do Function:" + employee);
			return "mensagem-saida";
		};
	}

}
