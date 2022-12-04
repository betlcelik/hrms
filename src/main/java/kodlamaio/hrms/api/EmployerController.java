package kodlamaio.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
	
	@Qualifier("employerManager")
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(@Qualifier("employerManager")EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		
		return this.employerService.getAll();
	}
	
	@PostMapping("/signUp")
	public Result signUp(@Valid @RequestBody Employer  employer) {
		return this.employerService.signUp(employer);
	}
	
	/*
	@PutMapping("/pasifyJobAdvertisement")
	public Result pasifyJobAdvertisement(Employer employer,@RequestBody int jobAdvertisementId) {
		return this.employerService.pasifyJobAdvertisement(employer, jobAdvertisementId);
	}*/
	

}
