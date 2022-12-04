package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownForeignLanguage;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	public Result add(ProgrammingLanguage programmingLanguage);
	public DataResult<List<ProgrammingLanguage>> getAll();

}
