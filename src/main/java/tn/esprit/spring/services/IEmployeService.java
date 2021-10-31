package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employe;

import java.util.List;

public interface IEmployeService {

	public Employe ajouterEmploye(Employe employe);
	
	public String getEmployePrenomById(int employeId);
	
	public long getNombreEmploye();
	
	public Employe authenticate(String login, String password) ;

	public List<Employe> getEmployes();

	public void deleteEmployeById(int long1);

}
