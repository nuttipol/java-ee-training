package my.example.service.impl;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import my.example.model.Person;
import my.example.service.NameServiceable;

public class ConcatServiceTest {
    @Inject
    private NameServiceable service;

	@Test
	public void test() {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
        	ConcatServiceTest main = container.select(ConcatServiceTest.class).get();
    		Assert.assertEquals("A B",main.service.display(Person.builder().firstName("A").lastName("B").build()));
        }
	}

}
