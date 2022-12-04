package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Candidate extends User{

	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotNull
	@NotBlank
	@Column(name="year_of_birth")
	private String yearOfBirth;
	
	@Email
	@NotNull
	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name="password")
	private String password;
	
	@NotNull
	@NotBlank
	private  String passwordRepeat;
	
	@OneToOne(mappedBy = "candidate")
	private Resume resume;
	
	
	

}
