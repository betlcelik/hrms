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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="description")
	private String description;
	
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="city_id",referencedColumnName = "id")
	private City city;
	
	
	@Column(name="salary_min")
	private String salaryMin;
	
	@Column(name="salary_max")
	private String salaryMax;
	
	@NotNull
	@NotBlank
	@Column(name="open_positions")
	private int openPositions;
	
	//@JsonFormat(pattern = "yyyy")
	@ApiModelProperty(example = ("yyyy-MM-dd"))
	@Column(name="application_deadline")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDeadline;
	
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@ManyToOne
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;
	
	@ManyToOne
	@JoinColumn(name="working_type_id")
	private WorkingType workingType;
	
	
	
}
