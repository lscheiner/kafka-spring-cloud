package br.com.scheiner.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;

@Service
public class ConsumerService {

	// ack precisa ser manual , quando der erro em todas as tentativas ele commita a mensagem
	// ocorre um delay para consumir a primeira mensangem de não fizer um shutdown graceful, porque o spring tenta
	// dar rejoin no grupo porque não foi feito um consumer.close()
	
	@KafkaListener(topics = "topico-dest" , groupId="consumer-group-1")
    public void consume(Employee message , Acknowledgment acknowledgment) {
		 System.out.println("Received message: " + message);
		
		 throw new RuntimeException("erro");
		
       // System.out.println("Received message: " + message);
		 
		// acknowledgment.acknowledge();
    }

}
