package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Contrat;

@Repository
public interface IContratService {

	public Contrat ajouterContrat(Contrat contrat);
	public void deleteContratById(int ContratId );
}
