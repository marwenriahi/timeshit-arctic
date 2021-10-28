package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	public Entreprise addEntreprise(Entreprise entreprise);
	public List<Entreprise> getAllEntreprise();
	public void deletteAll ();
	
	
	 /*public Entreprise ajouterEntreprise(Entreprise entreprise);
	    public int getNombreEntreprise();
	    public List<String> getAllEntrepriseNames();
	    public List<Entreprise> getAllEntrepriseByRaisonSocial(String raisonSocial);
	    public Entreprise getEntrepriseById(int entrepriseId);
	    public Entreprise editEntrepriseById(Entreprise entreprise,int id);
	    public Entreprise editEntrepriseNameById(String name,int id);
	    public void deleteEntrepriseById(int entrepriseId);
	    public void deleteAllEntreprise();*/

}
