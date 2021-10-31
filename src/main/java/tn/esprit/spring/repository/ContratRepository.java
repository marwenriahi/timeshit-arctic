package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;
@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{
public Contrat findByTypeContrat(String typeContrat);

} 
