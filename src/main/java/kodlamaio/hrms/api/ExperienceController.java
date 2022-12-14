package kodlamaio.hrms.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experinces")
@CrossOrigin
public class ExperienceController {
	
	private ExperienceService experienceService;
	
	@Autowired
   public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}


	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody  Experience experience){
	   return ResponseEntity.ok(this.experienceService.add(experience));
   }
	
    @GetMapping("/getAll")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors= new HashMap<String ,String>();
		
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??");
		return errors;
		
	}

}
