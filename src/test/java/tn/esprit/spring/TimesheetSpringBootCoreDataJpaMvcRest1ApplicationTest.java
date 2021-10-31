package tn.esprit.spring;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
@RunWith(SpringRunner.class)
@SpringBootTest

public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTest {
	@Autowired
	private IContratService service;
	@Autowired
	private IEmployeService serviceemp;
	
	@Autowired
	private ContratRepository repository;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	@Test
	@Order(5)
	public void testGetAllContrat()  {		
	List<Contrat>contrats=service.getAllContrat();
	assertThat(contrats).size().isGreaterThan(0);
	for(Contrat c:contrats) {
	l.info("Le contrat est: "+ c);}
	l.info("La taille de contrats  ,"+contrats.size());
	}
	@Test
	@Rollback(false)
	@Order(1)
	public void testAjouterContrat() throws ParseException{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2021-10-19");
		Contrat contrat =new Contrat(date, "CDD",2700);

		Employe e = new Employe ("manel","mattoussi","manel@esprit.tn",true,date,Role.INGENIEUR);
		Contrat c=	service.ajouterContrat(contrat);
		Employe emp=serviceemp.ajouterEmployee(e);
		service.affecterContratAEmploye(c.getReference(),emp.getId());
		//when(repository.save(contrat)).thenReturn(contrat);

		//assertNotEquals(contrat.getSalaire(),c.getSalaire());
		if(e.getRole()==Role.ADMINISTRATEUR) {
			assertThat(c.getSalaire()).isGreaterThan(7000);
			l.info("le salaire d'administrateur est:"+c.getSalaire());
		}
		if(e.getRole()==Role.CHEF_DEPARTEMENT) {
			assertThat(c.getSalaire()).isGreaterThan(3000);
			l.info("le salaire de chef departement est:"+c.getSalaire());
		}
		if(e.getRole()==Role.INGENIEUR) {
			assertThat(c.getSalaire()).isGreaterThan(2000);
			l.info("le salaire d'ingenieur est:"+c.getSalaire());
		}
		else if(e.getRole()==Role.TECHNICIEN) {
			assertThat(c.getSalaire()).isGreaterThan(1000);
			l.info("le salaire de technicien est:"+c.getSalaire());
		}
		else {
			l.error("vos données ne sont pas valables");}

		assertThat(c.getReference()).isGreaterThan(0);

		service.deleteContrat(c);
	}
//	@Test
//	@Rollback(false)
//	@Order(4)
//	public void testUpdateContrat() throws ParseException{
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = dateFormat.parse("2021-10-19");
//		String typeContrat ="CDi";
//		Contrat contrat =new Contrat(2,date, "CDi",200);
//		service.updateContrat(contrat);
//		//when(repository.save(contrat)).thenReturn(contrat);
//		Contrat c=	repository.findByTypeContrat(typeContrat);
//		assertThat(c.getTypeContrat()).isEqualTo(typeContrat);
//
//	}
	

//	@Test
//	@Rollback(false)
//	@Order(6)
//	public void deleteContratbyid() {
//	Integer id=110;
//	boolean isExistBeforeDelete =repository.findById(id).isPresent();
//	repository.deleteById(id);
//	boolean notExistAfterDelete =repository.findById(id).isPresent();
//	assertTrue(isExistBeforeDelete);
//	assertFalse(notExistAfterDelete);
//	l.info("le contrat est supprimé ");
//	}
	@Test
	@Order(5)
	public void testgetContrat() {
		Contrat c = service.getContrat(2);


		if(c.getReference()== 2) {
			assertNotNull( service.getContrat(2));

			l.info("le contart est:"+c.toString());
		}

		else 
		{assertNull(c);
		l.error("contart introuvable ");
		}

	}
	@Test
	@Order(2)
	public void testFindByTypeContratExist(){
		String typeContrat ="CDDk";
		Contrat c =service.findByTypeContrat(typeContrat);
		
		assertThat(c.getTypeContrat()).isEqualTo(typeContrat);
		
		
		l.info("liste des contrats:"+c);
	}
	
	@Test
	@Order(3)
	public void testFindByTypeContratNotExist(){
		String typeContrat ="CDDkl";
		Contrat c =service.findByTypeContrat(typeContrat);
		
		assertNull(c);
		
		
		l.info("liste des contrats:"+c);
	}
}
