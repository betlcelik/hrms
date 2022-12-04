package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="experiences")
public class Experience {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="workplace_name")
	private String workplaceName;
	
	@NotNull
	@NotBlank
	@Column(name="position_name")
	private String positionName;
	
	//@NotNull
//@NotBlank
	@Column(name="beginning_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate beginnigDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="end_date")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	

}
