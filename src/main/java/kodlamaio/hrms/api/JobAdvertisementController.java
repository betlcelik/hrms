package kodlamaio.hrms.api;

import java.util.ArrayList;


import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto;
import springfox.documentation.service.AllowableListValues;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {
	
	
	
	JobAdvertisementService jobAdvertisementService;
	
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
		
		
	   // StringJoiner stringJoiner= new StringJoiner(",");
	   
		///stringJoiner.add(list.get(0).toString());
		//this.allowableValue=stringJoiner.toString();
		
	}
	
	
	
	
	
	//@ApiParam(required = true,allowableValues = "1,2,3",name = "city")
	@ApiModelProperty( )
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/findByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue(){
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/findByIsActiveTrueAndEmployer_Id")
	public DataResult<List<JobAdvertisementGeneralDetailDto>> findByIsActiveTrueAndEmployer_Id(@RequestBody int employerId){
		return this.jobAdvertisementService.findByIsActiveTrueAndEmployer_Id( employerId);
	}
	
	@GetMapping("findAllIsActiveTrueSortedByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> findAllIsActiveTrueSortedByApplicationDeadline(){
		return this.jobAdvertisementService.findAllIsActiveTrueSortedByApplicationDeadline();
	}
	
	@GetMapping("/getDetail")
	public DataResult<List<JobAdvertisementDetailDto>> getDetail(){
		return this.jobAdvertisementService.getDetail();
	}
	
	@GetMapping("/getIsActiveTrueWithDetails")
public DataResult<List<JobAdvertisementGeneralDetailDto>>getIsActiveTrueWithDetails(){
		return this.jobAdvertisementService.getIsActiveTrueWithDetails();
	}
	
	
	

}
