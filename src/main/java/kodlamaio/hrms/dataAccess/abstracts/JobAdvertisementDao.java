package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	
	List<JobAdvertisement> findByIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto(ja.id,e.companyName,jp.position,ja.openPositions,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Join ja.employer e Join ja.jobPosition jp")
	List<JobAdvertisementGeneralDetailDto> findByIsActiveTrueAndEmployer_Id(int employerId);
	
	//@Query("select jobAd From JobAdvertisements jobAd where jobAd.employer >= :employerId")
	//List<JobAdvertisement> getY
	//isActive=true ,

	//List<JobAdvertisement> getByEmployerAndIsActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto(ja.id,jp.position,ja.description,c.name,e.companyName,e.website,ja.applicationDeadline) From JobAdvertisement ja  Join ja.employer e  Join ja.city c Join ja.jobPosition jp")
	List<JobAdvertisementDetailDto> getDetail();
	
	//@Query("Select new  kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	//category ve onun productları arasında biir join kur
	//sList<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select p.productId,p.productName from Category c inner join Product p
	//on c.categoryId=p.categoryId
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto(ja.id,e.companyName,jp.position,ja.openPositions,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Join ja.employer e Join ja.jobPosition jp")
	List<JobAdvertisementGeneralDetailDto> getIsActiveTrueWithDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementGeneralDetailDto(ja.id,e.companyName,jp.position,ja.openPositions,ja.releaseDate,ja.applicationDeadline) From JobAdvertisement ja Join ja.employer e Join ja.jobPosition jp")
	List<JobAdvertisementGeneralDetailDto> getIsActiveTrueWithDetailsSorted(Sort sort);
}
