package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.MissionServiceImpl;

import java.util.List;

@RestController
public class MissionRestController {
	
	@Autowired
	MissionServiceImpl MS ;
	

	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterMission
		@PostMapping("/ajouterMission")
		@ResponseBody
		public Mission ajouterMission(@RequestBody Mission mission)
		{
			MS.ajouterMission(mission);
			return mission ;
		}
	
		
		
		

		@DeleteMapping(value = "/deleteMission/{id}")
		public void deleteMission(@PathVariable("id") int id) {
			MS.deleteMission(id);	}
	    
		
		
		
		@GetMapping("/count-Missions")
		@ResponseBody
		public long getMissionsnumber() {
		return MS.getMissionNumber();
		}
		
		@PutMapping("/update-Mission")
		@ResponseBody
		public Mission updateMission(@RequestBody Mission mis) {
		return MS.MissionUpadate(mis);
				
		}
		
		
		
		@GetMapping(value = "/getAllMissions")
	    @ResponseBody
		public List<Mission> getAllEmployes() {
			
			return MS.getMissions();
		}
		
		
}
