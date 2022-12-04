package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="employers")
//@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Employer extends User {
	
	
	@Column(name="company_name")
	private String companyName;
	
	//@NotNull
	//@NotBlank
	@Column(name="website")
	private String website;
	
	
	@Email
	@Column(name="email")
	private String email;
	
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@Column(name="password")
	private String password;
	
	@Transient
	private String passwordRepeat;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	

}
