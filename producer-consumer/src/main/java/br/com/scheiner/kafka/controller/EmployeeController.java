package br.com.scheiner.kafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.scheiner.kafka.dto.EmployeeDTO;
import br.com.scheiner.kafka.producer.ProducerService;
import br.com.scheiner.kafka.utils.UrlUtils;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private ProducerService producerService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<String> producerAvroMessage(@RequestBody EmployeeDTO employeeDTO) {

		this.producerService.send(employeeDTO);
		return ResponseEntity.created(UrlUtils.createUrl("1")).build();
	}

}
