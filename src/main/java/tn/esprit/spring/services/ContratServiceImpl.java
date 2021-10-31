package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService{
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	EmployeRepository employeRepository;
	@Override
	public Contrat ajouterContrat(Contrat contrat) {
		
		return contratRepoistory.save(contrat);
		//return contrat.getReference();
	}
	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
		Employe employeManagedEntity = employeRepository.findById(employeId).get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepoistory.save(contratManagedEntity);
		
	}
	@Override
	public void deleteContrat(Contrat contrat) {
		//Contrat contratManagedEntity = contratRepoistory.findById(contracontratId).get();
		contratRepoistory.delete(contrat);

	}
	@Override
	public void deleteContratbyid(int idc) {
		Contrat c = contratRepoistory.findById(idc).get();
		contratRepoistory.delete(c);

	}
	@Override
	public void deleteAllContratJPQL() {
        employeRepository.deleteAllContratJPQL();
	}
	@Override
	public List<Contrat> getAllContrat() {
		List<Contrat>contrats =  (List<Contrat>) contratRepoistory.findAll();
		for(Contrat c :contrats) {
			System.out.println("date debut"+c.getDateDebut());
			System.out.println("salaire"+c.getSalaire());
			System.out.println("type contrat"+c.getTypeContrat());
		}
		
		return (List<Contrat>) contratRepoistory.findAll();
		
}
	@Override
	public Contrat updateContrat(Contrat contrat) {
		return contratRepoistory.save(contrat);
		
	}
	@Override
	public Contrat getContrat(int id) {
		
		return contratRepoistory.findById(id).get();
	}
	@Override
	public Contrat findByTypeContrat(String typeContrat) {
		
		return contratRepoistory.findByTypeContrat(typeContrat);
	}
}
