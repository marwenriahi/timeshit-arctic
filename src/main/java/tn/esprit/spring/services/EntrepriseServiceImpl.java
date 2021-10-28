package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService{
    @Autowired
	EntrepriseRepository entrepriseRepository;
	//private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

    
    
    
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}
	@Override
	public List<Entreprise> getAllEntreprise() {
		return (List<Entreprise>) entrepriseRepository.findAll();
	}
	@Override
	public void deletteAll() {
		
		entrepriseRepository.deleteAll();
	}
	
	
	
	
	
}
