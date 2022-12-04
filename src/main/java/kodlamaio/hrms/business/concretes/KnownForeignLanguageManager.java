package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.KnownForeignLanguage;

@Service
public class KnownForeignLanguageManager implements KnownForeignLanguageService {

	private KnownForeignLanguageDao knownForeignLanguageDao;
	
	@Autowired
	public KnownForeignLanguageManager(KnownForeignLanguageDao knownForeignLanguageDao) {
		super();
		this.knownForeignLanguageDao = knownForeignLanguageDao;
	}

	@Override
	public Result add(KnownForeignLanguage knownForeignLanguage) {
		this.knownForeignLanguageDao.save(knownForeignLanguage);
		return new SuccessResult("Bilinen dillere eklendi");
	}

	@Override
	public DataResult<List<KnownForeignLanguage>> getAll() {
		
		return new SuccessDataResult<List<KnownForeignLanguage>>(this.knownForeignLanguageDao.findAll(),"Bilinen diller listelendi");
	}

}
