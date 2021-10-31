package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.IMissionRepository;

import java.util.List;

@Service
public class MissionServiceImpl implements IMissionService {
	

	
	@Autowired
	IMissionRepository mr ;
	
	
	
	
	
	@Override
	public List<Mission> getMissions() {
		return (List<Mission>) mr.findAll();
	}
	
	@Override
	public long ajouterMission(Mission mission) {
		mr.save(mission);
		return (mission).getIdMission();
	}
	
	
	@Override
	public long getMissionNumber() {
		return mr.count();
	}
	
	
	
	@Override
	public Mission MissionUpadate(Mission Miss) {
		
		Mission existingMiss=mr.findById(Miss.getId()).orElse(null);
		
		mr.findById(Miss.getId());
		existingMiss.setName(Miss.getName());
		existingMiss.setDescriptionMission(Miss.getDescriptionMission());
		
		return mr.save(existingMiss);
	}
	

	@Override
	public void deleteMission(int id) {
		mr.deleteById((long)id);

	}
	
	
	
	

}
