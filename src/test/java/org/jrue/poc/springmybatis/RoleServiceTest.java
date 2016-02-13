package org.jrue.poc.springmybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.jrue.poc.springconfig.ApplicationContext;
import org.jrue.poc.springmybatis.domain.Role;
import org.jrue.poc.springmybatis.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContext.class})
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;

	@Test
	public void whenFetchingAllRolesThenRolesShouldBeDisplayed() {
		List<Role> role = roleService.findAllRoles();
		assertNotNull(role);
		assertEquals(2, role.size());
	}

}
