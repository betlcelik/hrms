package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotNull
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name="department")
	private String department;
	
	@NotNull
	@NotBlank
	@Column(name="school_beginning_date")
	private LocalDate schoolBeginningDate;
	
	@Column(name="graduation_date")
	private LocalDate  graduationDate;
	

}
