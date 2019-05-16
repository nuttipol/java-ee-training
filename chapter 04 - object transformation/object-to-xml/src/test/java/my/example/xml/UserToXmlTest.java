package my.example.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonListener;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DOMDifferenceEngine;
import org.xmlunit.diff.DifferenceEngine;

import my.example.xml.Department;
import my.example.xml.Role;
import my.example.xml.User;

/**
 * https://github.com/xmlunit/xmlunit
 * @author Nuttipol
 *
 */
public class UserToXmlTest {

	private User user;
	 
	@Before
	public void setUp() {
	    user = new User(1,"Nuttipol",new Department(1, "SDD"),new ArrayList<>(Arrays.asList(new Role(1, "Admin"),new Role(2, "User"))));
	}
	
	@After
	public void tearDown() {
		user = null; 
	}
	
	@Test
	public void testObjectToXml() throws JAXBException, FileNotFoundException {
		ByteArrayOutputStream userBaos = new ByteArrayOutputStream();
		
	    JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
	    Marshaller marshaller = jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
   	    marshaller.marshal(user, userBaos);
   	    marshaller.marshal(user, System.out);
	    
	    Source control = Input.fromFile("src/test/user.xml").build();
	    Source test = Input.fromByteArray(userBaos.toByteArray()).build();
	    
	    DifferenceEngine diff = new DOMDifferenceEngine();
	    diff.addDifferenceListener(new ComparisonListener() {
            public void comparisonPerformed(Comparison comparison, ComparisonResult outcome) {
                Assert.fail("found a difference: " + comparison);
            }
        });
	    diff.compare(control, test);
	}
	
	@Test
	public void testXmlToObject() throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(User.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/test/user.xml");
        User userTest = (User) unmarshaller.unmarshal(xml);

        Assert.assertEquals(user,userTest);
	}
}
