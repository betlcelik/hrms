package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="system_employees")
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
public class SystemEmployee extends User{
	
	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	
	
	
}
