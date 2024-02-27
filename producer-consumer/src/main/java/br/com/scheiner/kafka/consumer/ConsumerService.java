package br.com.scheiner.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;

@Service
public class ConsumerService {

	@KafkaListener(topics = "topico-dest")
    public void consume(Employee message) {
        System.out.println("Received message: " + message);
    }

}
