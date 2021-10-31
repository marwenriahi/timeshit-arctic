package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import java.util.List;

@Repository
public interface IEmployeRepository extends CrudRepository<Employe,Long>{
	
	@Query("SELECT e.nomEmploye FROM Employe e")
	List<String> getAllEmployeNamesJPQL();

	@Query("SELECT count(e) FROM Employe e")
	Long getNombreEmployeJPQL();

	@Query("Select "
			+ "DISTINCT e from Employe e "
			+ "join e.departement dep "
			+ "join dep.entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Employe> getAllEmployeByEntreprise(@Param("entreprise") Entreprise entreprise);
	

	@Query("SELECT e FROM Employe e WHERE e.emailEmploye=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(
	@Param("email")String login,
	@Param("password")String password);
}
