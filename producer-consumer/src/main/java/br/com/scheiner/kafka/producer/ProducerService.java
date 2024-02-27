package br.com.scheiner.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;
import br.com.scheiner.EmployeeKey;
import br.com.scheiner.kafka.dto.EmployeeDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProducerService {
	
    private KafkaTemplate<EmployeeKey, Employee> kafkaTemplate;
	
	public void send (EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLastname());
        employee.setDocument(employeeDTO.getDocument());

        EmployeeKey employeeKey = new EmployeeKey();
        employeeKey.setDocument(employeeDTO.getDocument());

        Message<Employee> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, "topico-dest")
                .setHeader(KafkaHeaders.KEY, employeeKey)
                .build();
        
        this.kafkaTemplate.send(message);
	}
}
