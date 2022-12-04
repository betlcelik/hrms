package kodlamaio.hrms.business.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CheckRealPersonService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements CheckRealPersonService {

	@Override
	public Result checkIfRealPerson(String idendityNumber, String firstName, String lastName, String yearOfBirth)  {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		boolean result=false;
		try {
		 result= kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(idendityNumber),firstName, lastName, Integer.parseInt(yearOfBirth));
		 if(result) {
			 return new SuccessResult();
		 }
		} catch (NumberFormatException | RemoteException e) {
			System.out.println("Kimlik Bilgileri Geçersiz");
			e.printStackTrace();
		}
		
		return new Result(result, "Kimlik Bilgileri Geçersiz");
	}

}
