/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

/**
 * CustomerDAO test
 * 
 * intended to be refactored later to test with DB
 * 
 * @author Hugo
 */
public class CustomerDAOTest {
    
    CustomerCollectionsDAO dao = new CustomerCollectionsDAO();
    Customer customer1;
    Customer customer2;
    Customer customer3;
    
    @BeforeEach
    public void setUp() {
        customer1 = new Customer(1, "username1", "", "", "", "");
        customer2 = new Customer(2, "username2", "", "", "", "");
        customer3 = new Customer(3, "username3", "", "", "", "");
        
        dao.saveCustomer(customer1);
        dao.saveCustomer(customer2);
    }
    
    @AfterEach
    public void tearDown() {
        dao.removeAll();
    }
    
    @Test
    public void testRemoveCustomer() {
        dao.removeCustomer(customer1);
        assertThat("Ensure customer was removed", dao.size(), is(1));
        assertThat("Ensure customer cannot be found", dao.searchByUsername("username1"), is(nullValue()));
    }
    
    @Test
    public void testRemoveAll() {
        assertThat("Checking that dao is non empty", dao.size(), is(2));
        dao.removeAll();
        assertThat("Checking dao was cleared", dao.getCustomers(), empty());
    } 
    
    @Test
    public void testMatchesCustomer() {
        customer1.setPassword("password1");
        assertThat("Matches with contained customer", dao.matchesCustomer("username1", "password1"), is(true));
        assertThat("Matches with contained customer, incorrect username", dao.matchesCustomer("usernam1", "password1"), is(false));
        assertThat("Matches with contained customer, incorrect password", dao.matchesCustomer("username1", "passwod1"), is(false));
       
        
        assertThat("Doesn't match with a non contained customer at all", dao.matchesCustomer("username3", "pass"), is(false));
    }
    
    @Test
    public void testSize() {
        assertThat("Size is correct before removing a customer", dao.size(), is(2));
        dao.removeCustomer(customer1);
        assertThat("Size has changed", dao.size(), is(1));
        
        dao.saveCustomer(customer3);
        assertThat("Size has increased", dao.size(), is(2));
    }
    
    @Test
    public void testGetCustomers() {
        Collection<Customer> customers = dao.getCustomers();
        assertThat("Size of customers is correct", customers.size(), is(2));
    }

    @Test
    public void testSaveCustomer() {
        assertThat("Checking original size", dao.size(), is(2));
        assertThat("Checking customer 1 is contained", dao.searchByUsername("username1"), is(customer1));
        dao.saveCustomer(customer1);
        assertThat("Save ignores duplicate entries", dao.size(), is(2));
    
        dao.saveCustomer(customer3);
        assertThat("Dao size is correct", dao.size(), is(3));
        assertThat("Customer was added", dao.searchByUsername("username3"), is(customer3));
    }

    @Test
    public void testSearchByID() {
        assertThat("Simple search by id", dao.searchByUsername("username1"), is(customer1));
        assertThat("Simple search, customer not contained", dao.searchByUsername("username3"), is(nullValue()));
        assertThat("Simple search, customer doesn't exist", dao.searchByUsername("username4"), is(nullValue()));
    }
    
}
