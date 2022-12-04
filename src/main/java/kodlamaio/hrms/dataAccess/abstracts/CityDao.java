package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	 
	//@Query("Slect kodlamaio.hrms.entities.concretes.City(c.name) From City c")
	//List<City> getCityName();
	 
	

}
