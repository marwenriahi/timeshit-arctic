package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Transactional
@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;

	@Override
	public Contrat ajouterContrat(Contrat contrat) {
	
		contratRepository.save(contrat);
		
		return contrat;
	}

	@Override
	public void deleteContratById(int ContratId) {

		Contrat contratManagedentity = contratRepository.findById(ContratId).get();
		contratRepository.delete(contratManagedentity);
	}

}
