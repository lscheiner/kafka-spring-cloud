package br.com.scheiner.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.scheiner.Employee;
import br.com.scheiner.EmployeeKey;
import br.com.scheiner.kafka.dto.EmployeeDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProducerService {
	
	@Autowired
    private StreamBridge streamBridge;
	
	public void send (EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLastname());
        employee.setDocument(employeeDTO.getDocument());

        EmployeeKey employeeKey = new EmployeeKey();
        employeeKey.setDocument(employeeDTO.getDocument());

        this.streamBridge.send("producerSender-out-0", 
        		MessageBuilder.withPayload(employee)
    			.setHeader(KafkaHeaders.MESSAGE_KEY, employeeKey)
    			.build());
	}

}
