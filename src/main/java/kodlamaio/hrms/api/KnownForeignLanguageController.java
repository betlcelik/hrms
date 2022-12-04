package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.KnownForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.KnownForeignLanguage;

@RestController
@RequestMapping("/api/knownForeignLanguages")
@CrossOrigin
public class KnownForeignLanguageController {
	
	private KnownForeignLanguageService knownForeignLanguageService;

		@Autowired
	public KnownForeignLanguageController(KnownForeignLanguageService knownForeignLanguageService) {
		super();
		this.knownForeignLanguageService = knownForeignLanguageService;
	}
		
		@PostMapping("/add")
		public Result add(@RequestBody KnownForeignLanguage knownForeignLanguage) {
			return this.knownForeignLanguageService.add(knownForeignLanguage);
		}
		
		@GetMapping("/getAll")
		public DataResult<List<KnownForeignLanguage>> getAll(){
			return  this.knownForeignLanguageService.getAll();
		}
	

}
