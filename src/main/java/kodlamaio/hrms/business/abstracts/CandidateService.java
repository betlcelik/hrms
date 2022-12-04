package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.stereotype.Repository;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateService {
	
	public Result signUp(Candidate candidate) ;
	public DataResult<List<Candidate>> getAll();

}
