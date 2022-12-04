package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.KnownForeignLanguage;

public interface KnownForeignLanguageDao extends JpaRepository<KnownForeignLanguage	, Integer>{

}
