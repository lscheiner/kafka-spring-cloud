package br.com.scheiner.kafka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "EmployeeDTO", description = "employee")
@Data
public class EmployeeDTO {
	
	@Schema(
			  description = "Nome",
			  name = "name",
			  example = "teste")
	private String name;
	
	@Schema(
			  description = "Last Name",
			  name = "lastname",
			  example = "last")
	private String lastname;
	
	@Schema(
			  description = "Document",
			  name = "document",
			  example = "32112312304")
	private String document;


}
