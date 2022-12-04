package kodlamaio.hrms.business.adapters;
import java.io.File;
import java.io.IOException;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class CloudinaryServiceAdapter implements ImageUploadService {
	
	
	private ImageDao imageDao;
	
	@Autowired
	public CloudinaryServiceAdapter(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
		
	}



	private Cloudinary cloudinary
		= new Cloudinary(ObjectUtils.asMap(
	    		"cloud_name", "hrmsbet",
	    		"api_key", "465348665876115",
	    		"api_secret", "Z5TZAWsb1F4lQlsilCaiNJSAbVE",
	    		"secure", true));
	


	@Override
	public DataResult<?> uploadImage(String imageUrl) throws IOException {
		/*
		Map<?,?> uploadResult = this.cloudinary.uploader().upload(imageUrl, ObjectUtils.emptyMap());
		uploadResult.get("url");
		//image.setUrl(uploadResult.get("url").toString());
		
		return new SuccessDataResult<Map<?,?>>(null);*/
		
		
            Map<?, ?> result = this.cloudinary.uploader().upload(imageUrl, ObjectUtils.emptyMap());
            result.get("url");
            return new SuccessDataResult<Map<?, ?>>(null);
       
	}

	

	@Override
	public Result add(Image image) throws IOException {
		
		File file = new File("resim.jpg");
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		System.out.println(uploadResult.get("url"));
		image.setUrl(uploadResult.get("url").toString());
		imageDao.save(image);
		
		/*
		Map<?, ?> result=this.cloudinary.uploader().upload(image.getUrl(), ObjectUtils.emptyMap());
		image.setUrl(result.get("url").toString());*/
		//imageDao.save(image);

		return null;
	}

	
	
	
	 
	
}
