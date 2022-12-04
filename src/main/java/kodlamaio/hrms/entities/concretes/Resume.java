package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "schools","experiences","knownForeignLanguages","programmingLanguages"})
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="github_adress")
	private String githubAdress;
	
	@Column(name="linkedin_adress")
	private String linkedinAdress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "resume")
	private List<School> schools; 
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy =  "resume")
	private List<KnownForeignLanguage> knownForeignLanguages;
	
	@OneToMany(mappedBy = "resume")
	private List<ProgrammingLanguage> programmingLanguages;
	
	
	

}
