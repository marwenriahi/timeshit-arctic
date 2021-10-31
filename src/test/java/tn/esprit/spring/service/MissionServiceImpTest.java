package tn.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.IMissionRepository;
import tn.esprit.spring.services.IMissionService;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImpTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(MissionServiceImpTest.class);

	
	
	
	@Autowired
	IMissionRepository Mr ;
	
	@Autowired
	IMissionService Ms ;
	
	
	
	//Add Mission Test 
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddMission() {
			Mission mission = new Mission("missionTest","missionTest");
		Ms.ajouterMission(mission);
		assertNotNull(mission.getId());
		l.info("Mission added successfuly ");
		Mr.deleteById(mission.getId());
		}
		
		
		
		//Count missions a make sure the return is  not null
		@Test
		public void testcountMission() {
		long nbrms = Mr.count();
		assertNotNull(nbrms);
		l.info("Le Nombre des Employes est :" + nbrms );
		}
		
		
		
		// Make sure the Database is not Nulls
		@Test
		public void testListMission() {
		List<Mission> e = (List<Mission>) Mr.findAll();
		assertThat(e).size().isPositive();
		l.info(e.size() + "> 0" );
		}
		
		
		
		
		//delete a mission (id=2).
		
				@Test
				public void deleteMission() {
					Mission mission = new Mission();
					int id = 2;
					Ms.deleteMission(id);
				}
				

	
}
