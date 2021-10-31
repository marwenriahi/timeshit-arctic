package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Mission;

public interface IMissionRepository extends CrudRepository<Mission, Long>{
	
	
	
	@Query("SELECT count(*) FROM Mission")
    public int countMiss();
	


	
}
