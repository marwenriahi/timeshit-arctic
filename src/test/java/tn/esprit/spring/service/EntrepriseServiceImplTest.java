package tn.esprit.spring.service;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService underTest;
	   
	
	@Test
	public void addEntrepriseTest() throws ParseException {
		Entreprise entreprise= new Entreprise ("tiktakthrem" ,"informatique");
		
		Entreprise entrepriseTest= underTest.addEntreprise(entreprise);
		Assert.assertEquals(entreprise.getName(), entrepriseTest.getName());
		
		
	}
	
	@Test
	public void getAllEntrepriseTest() throws ParseException{
		Entreprise entreprise1=  new Entreprise ("tiktakthrem" ,"informatique");
		Entreprise entreprise2= new Entreprise ("tiktakthrem" ,"informatique");
		Entreprise entreprise3= new Entreprise ("tiktakthrem" ,"informatique");
		
		underTest.addEntreprise(entreprise1);
		underTest.addEntreprise(entreprise2);
		underTest.addEntreprise(entreprise3);
		Assert.assertEquals(true,underTest.getAllEntreprise().size()==4);
	}
	
	

}
