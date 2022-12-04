package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
	
	@Qualifier("candidateManager")
	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(@Qualifier("candidateManager")CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/signUp")
	public Result signUp(Candidate candidate) {
		return this.candidateService.signUp(candidate);
	}
	
	
	

	

}
