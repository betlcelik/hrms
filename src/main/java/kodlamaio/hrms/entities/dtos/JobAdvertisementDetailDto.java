package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDetailDto {
	
	
	
	private int id;
	private String positionName;
	private String description;
	private String cityName;
	private String companyName;
	private String website;
	private LocalDate applicationDeadline;
	
public JobAdvertisementDetailDto(String description,String companyName,String cityName) {
	this.description=description;
	this.companyName=companyName;
	this.cityName=cityName;
		
	}

}
