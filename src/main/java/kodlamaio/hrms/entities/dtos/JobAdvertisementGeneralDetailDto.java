package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGeneralDetailDto {
	
	private int id;
	private String companyName;
	private String positionName;
	private int openPositions;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	

}
