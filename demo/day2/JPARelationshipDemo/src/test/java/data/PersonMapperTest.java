/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.PersonNotFoundException;
import entity.Person;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk
 */
public class PersonMapperTest {
    EntityManagerFactory emf;
    PersonMapper instance;
    public PersonMapperTest() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
        instance = new PersonMapper(emf);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class PersonMapper.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManager result = instance.getEntityManager();
        assertNotNull(result);
    }

    /**
     * Test of createPerson method, of class PersonMapper.
     */
    @Test
    public void testCreatePerson() {
        System.out.println("createPerson");
        Person person = new Person("Henriksen", "Pelle");
        Person p = instance.createPerson(person);
        assertTrue(p.getPersonID()>0);
    }

    /**
     * Test of editPerson method, of class PersonMapper.
     */
    @Test
    public void testEditPerson() throws Exception {
        System.out.println("editPerson");
        Person person = instance.createPerson(new Person("Uno", "Albert"));
        int id = person.getPersonID();
        person.setLastName("Duo");
        instance.editPerson(person);
        Person changedPerson = instance.findPerson(id);
        assertEquals(changedPerson.getLastName(), "Duo");
    }

//    /**
//     * Test of deletePerson method, of class PersonMapper.
//     */
    @Test
    public void testDeletePerson() throws Exception {
        System.out.println("deletePerson");
        Person p = instance.createPerson(new Person("Uno", "Prime"));
        int countBeforeDel = instance.getPersonCount();
        instance.deletePerson(p.getPersonID());
        int countAfterDel = instance.getPersonCount();
        assertTrue(countBeforeDel == countAfterDel + 1);
    }
//
//    /**
//     * Test of findPersonEntities method, of class PersonMapper.
//     */
    @Test
    public void testFindPersons() {
        System.out.println("findPersons");
        List<Person> result = instance.findPersons();
        assertTrue(result.size() > 0);
    }


//    /**
//     * Test of findPerson method, of class PersonMapper.
//     */
    @Test
    public void testFindPerson() {
        Person p = instance.createPerson(new Person("Uno", "Primo"));
        int id = p.getPersonID();
        Person foundPerson = null;
        try {
            foundPerson = instance.findPerson(id);
        } catch (PersonNotFoundException ex) {
            assertTrue(false);
        }
        assertNotNull(foundPerson);
        
    }
//
//    /**
//     * Test of getPersonCount method, of class PersonMapper.
//     */
    @Test
    public void testGetPersonCount() {
        System.out.println("getPersonCount");
        int result = instance.getPersonCount();
        assertTrue(result > 0);
    }
}
