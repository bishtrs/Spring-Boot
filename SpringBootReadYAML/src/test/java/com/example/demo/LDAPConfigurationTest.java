package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LDAPConfiguration.class)
public class LDAPConfigurationTest {
	
	@Autowired
    private LDAPConfiguration ldapConfiguration;
	
	@Test
	public void testLDAPConfiguration() {
		assertEquals("ssl", ldapConfiguration.getProtocol());
	}

}
