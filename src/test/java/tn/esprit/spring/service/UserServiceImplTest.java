
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

		@Autowired
		IUserService us; 
	
		@Test
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 7 users in DB : 
			Assert.assertEquals(15, listUsers.size());
		}
		
		
		@Test
		public void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			Assert.assertEquals(u.getLastName(), userAdded.getLastName());
		}
	 
		@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(5L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		@Test
		public void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("1"); 
			Assert.assertEquals(1L, userRetrieved.getId().longValue());
		}
		
		@Test
		public void testDeleteUser() {
			us.deleteUser("3");
			Assert.assertNull(us.retrieveUser("3"));
		}
		
		// 5 tests unitaires  
 
}





