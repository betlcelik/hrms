package kodlamaio.hrms.business.abstracts;

import java.io.IOException;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;


public interface ImageUploadService {
	
	public DataResult<?> uploadImage(String imageUrl) throws IOException;
	public Result add(Image image) throws IOException;

}
