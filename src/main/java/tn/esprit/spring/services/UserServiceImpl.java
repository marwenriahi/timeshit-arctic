package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);



	
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.debug("user +++ : " + user);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		return userRepository.save(u); 
	}

	@Override 
	public User updateUser(User u) { 
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public User retrieveUser(String id) {
		l.info("in  retrieveUser id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("user returned : " + u);
		return u; 
	}

}
