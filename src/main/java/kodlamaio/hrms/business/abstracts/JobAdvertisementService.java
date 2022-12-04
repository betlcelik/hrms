package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto;

public interface JobAdvertisementService {
	
	public Result add(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisement>> getAll();
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	public DataResult<List<JobAdvertisementGeneralDetailDto>> findByIsActiveTrueAndEmployer_Id(int employerId);
	public DataResult<List<JobAdvertisement>> findAllIsActiveTrueSortedByApplicationDeadline();
	public DataResult<List<JobAdvertisementDetailDto>> getDetail();
	public DataResult<List<JobAdvertisementGeneralDetailDto>> getIsActiveTrueWithDetails();
	public DataResult<List<JobAdvertisementGeneralDetailDto>> getIsActiveTrueWithDetailsSorted();
 }
