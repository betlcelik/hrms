package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	
	public Result add(Image image) throws IOException;
	public DataResult<List<Image>> getAll();

}
