package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownForeignLanguage;

public interface KnownForeignLanguageService {
	
	public Result add(KnownForeignLanguage knownForeignLanguage);
	
	public DataResult<List<KnownForeignLanguage>> getAll();

}
