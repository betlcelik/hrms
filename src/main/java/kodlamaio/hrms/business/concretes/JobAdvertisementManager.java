package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setReleaseDate(LocalDate.now());
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisementGeneralDetailDto>> findByIsActiveTrueAndEmployer_Id(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementGeneralDetailDto>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id( employerId));
	}

	

	@Override
	public DataResult<List<JobAdvertisement>> findAllIsActiveTrueSortedByApplicationDeadline() {
		Sort sort=Sort.by(Sort.Direction.ASC,"applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getDetail() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this.jobAdvertisementDao.getDetail());
	}

	@Override
	public DataResult<List<JobAdvertisementGeneralDetailDto>> getIsActiveTrueWithDetails() {
		
		return new SuccessDataResult<List<JobAdvertisementGeneralDetailDto>>(this.jobAdvertisementDao.getIsActiveTrueWithDetails());
	}

	@Override
	public DataResult<List<JobAdvertisementGeneralDetailDto>> getIsActiveTrueWithDetailsSorted() {
	 Sort sort=Sort.by(Sort.Direction.DESC,"applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisementGeneralDetailDto>>(this.jobAdvertisementDao.getIsActiveTrueWithDetailsSorted(sort));
	}
	
	


	
	
}
