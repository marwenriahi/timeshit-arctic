package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.services.IEmployeService;

import java.util.List;


@RestController
public class EmployeRestController {
	
	@Autowired
	IEmployeService es;
	
	@Autowired
	IEmployeRepository empR;
	
	//http://localhost:9090/SpringMVC/servlet/ajouter-employe
	@PostMapping("/ajouter-employe")
	@ResponseBody
	public Employe ajouterEmploye(@RequestBody Employe employe){
		return es.ajouterEmploye(employe);
	}
	
	@GetMapping("/count-employe")
	@ResponseBody
	public long getNombreEmploye() {
	return es.getNombreEmploye();
	}
	
	@GetMapping("/count-employe-jpql")
	@ResponseBody
	public long getNombreEmployeJPQL() {
	return empR.getNombreEmployeJPQL();
	}
	
	@GetMapping("/get-employeprenom-by-id/{idemploye}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("idemploye") int employeId){
		return es.getEmployePrenomById(employeId);
		
	}
	
	@GetMapping("/get-all-nameemploye")
	@ResponseBody
	public List<String> getAllEmployeNamesJPQL(){
		return empR.getAllEmployeNamesJPQL();
	}
	
	@GetMapping("/get-all-employe-by-entreprise")
	@ResponseBody
	public List<Employe> getAllEmployeByEntreprise(@RequestBody Entreprise entreprise){
		return empR.getAllEmployeByEntreprise(entreprise);
	}
	
	
	@GetMapping("/get-employe-by-email-password/{email}/{password}")
	@ResponseBody
	public Employe getAllEmployeByEntreprise(
			@PathVariable ("email") String login,
			@PathVariable("password")String password){
		return empR.getEmployeByEmailAndPassword(login, password);
	}
	

}
