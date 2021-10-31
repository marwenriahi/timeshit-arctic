package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.IEmployeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	IEmployeRepository empR;
	
	@Autowired
	IEmployeService emps;

	@Override
	public Employe ajouterEmploye(Employe employe) {
		return empR.save(employe);
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Optional<Employe> employe = empR.findById((long) employeId);
		if (employe.isPresent()){
			return employe.get().getNom();
		}
		return  "Employe dose not exist";
	}

	@Override
	public long getNombreEmploye() {
		return empR.count();
	}
	
	@Override
	public Employe authenticate(String login, String password) {
	return empR.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public List<Employe> getEmployes() {
		return (List<Employe>) empR.findAll();
	}

	@Override
	public void deleteEmployeById(int employeId) {
		empR.deleteById((long) employeId);
	}

	
}
