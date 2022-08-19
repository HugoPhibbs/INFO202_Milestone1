/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Hugo
 */
public class CustomerCollectionsDAOTest {
    
    CustomerCollectionsDAO dao = new CustomerCollectionsDAO();
    Customer customer1;
    Customer customer2;
    Customer customer3;
    
    @BeforeEach
    public void setUp() {
        customer1 = new Customer(1, "", "", "", "", "");
        customer2 = new Customer(2, "", "", "", "", "");
        customer3 = new Customer(3, "", "", "", "", "");
        
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
    }
    
    @Test
    public void testRemoveAll() {
        
    }
    
    @Test
    public void testGetCustomers() {
        
    }

    @Test
    public void testSaveCustomer() {
    }

    @Test
    public void testSearchByID() {
    }
    
}
