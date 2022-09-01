/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;

/**
 * DAO interface for storing customers. 
 * 
 * Abstract to allow it to be implemented by a Collections DAO, a DB etc
 * 
 * @author Hugo
 */
public interface CustomerDAO {
    
    /**
     * Removes all Customers from this DAO
     */
    void removeAll();
    
    /**
     * Returns the customers of this DAO
     * 
     * @return Collection of Customers
     */
    Collection<Customer> getCustomers();
    
    /**
     * Removes a Customer from this DAO
     * 
     * @param customer Customer to be removed
     */
    void removeCustomer(Customer customer);
    
    /**
     * Saves a Customer to this DAO
     * 
     * @param customer Customer to be saved
     */
    void saveCustomer(Customer customer);
    
    /**
     * Searches and returns a Customer by the given username
     * 
     * @param username string for username be searched
     * @return Customer found by ID
     */
    Customer searchByUsername(String username);
   
    
    /**
     * Checks if a given username and password matches an existing Customer
     * 
     * @param username String
     * @param password String
     * @return Customer found, otherwise null
     */
    boolean matchCustomer(String username, String password);
}
