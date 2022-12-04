package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.utilities.results.Result;

public interface CheckRealPersonService {
	
	public Result checkIfRealPerson(String idendityNumber,String firstName,String lastName,String yearOfBirth) ;

}
