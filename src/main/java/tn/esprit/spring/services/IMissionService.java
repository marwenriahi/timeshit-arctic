package tn.esprit.spring.services;

import tn.esprit.spring.entity.Mission;

import java.util.List;

public interface IMissionService {

	long ajouterMission(Mission mission);

	void deleteMission(int id);

	List<Mission> getMissions();

	long getMissionNumber();

	Mission MissionUpadate(Mission Miss);
	
}
