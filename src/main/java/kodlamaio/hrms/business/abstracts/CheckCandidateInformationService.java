package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@Component
public interface CheckCandidateInformationService {
	
	public Result checkAreInformationsFull(Candidate candidate);
	public Result checkIsEmailUniqe(Candidate candidate);
	public Result checkIsIdentityNumberUniqe(Candidate candidate);
	public Result checkIsRealPerson(Candidate candidate) ;
	public Result checkIsPasswordRepeatMatches(Candidate candidate);

}
