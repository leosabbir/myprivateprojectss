package com.hogwart.dbtest.server.repositories;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hogwart.dbtest.server.entity.User;
import com.hogwart.dbtest.server.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/WEB-INF/test-context.xml"})
public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserRepository userRepository;
	
	public UserRepositoryTest() {
		System.setProperty("db.username", "sa");
		System.setProperty("db.password", "");
		System.setProperty("db.driver", "org.hsqldb.jdbcDriver");
		System.setProperty("db.dialect", "org.hibernate.dialect.HSQLDialect");
		System.setProperty("db.url", "jdbc:hsqldb:mem:test");
		System.setProperty("db.persistenceXml", "classpath:/META-INF/persistence.xml");
		System.setProperty("db.persistenceUnit", "test");
		
	}
	
	private User createUser(){
		User user = new User();
		user.setUsername("sabbir");
		user.setPassword("sabbir");
		
		return user;
	}
	
	@Before
	public void setUp() {
		userRepository.save(createUser());
	}
	
	@Test
	public void testInsert(){
		User user = userRepository.findByUsername("sabbir");
		
		Assert.assertNotNull(user);
	}
}
