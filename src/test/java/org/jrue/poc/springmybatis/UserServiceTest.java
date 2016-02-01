package org.jrue.poc.springmybatis;

import org.jrue.poc.springconfig.ApplicationContext;
import org.jrue.poc.springmybatis.domain.User;
import org.jrue.poc.springmybatis.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContext.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private User user;
	
	@After
	public void destroy() {
		userService = null;
		user = null;
	}
	
	@Test
	public void testSingleCRUD() {
		
		//test insert single record		
		user.setName("JOEL RUELOxxS");
		int currentUsers = userService.count();
				
		user.setPassword("password123");
		user.setEmployeeId("123312");
		user.setDepartmentName("SDD1");

		userService.save(user);
		
		User insertedUser = userService.findByName(user.getName());
		//test single read
		Assert.assertEquals(user.getEmployeeId(), insertedUser.getEmployeeId());


		Assert.assertTrue(++currentUsers == userService.count());
		
		//test single update
		insertedUser.setPassword("password12345");
		insertedUser.setEmployeeId("XXXXX");
		insertedUser.setDepartmentName("SDD2");
		userService.update(insertedUser);
	
		//test single read
		User updatedUser = userService.findByName(user.getName());
		Assert.assertEquals(insertedUser.getPassword(), updatedUser.getPassword());
		Assert.assertEquals(insertedUser.getEmployeeId(), updatedUser.getEmployeeId());
		Assert.assertEquals(insertedUser.getDepartmentName(), updatedUser.getDepartmentName());				
	
		//test logical delete
		userService.delete(updatedUser);
		Assert.assertNull(userService.findByName(user.getName()));	
	}
	
}