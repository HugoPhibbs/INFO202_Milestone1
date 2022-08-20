/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;
import java.util.HashMap;

/**
 * Collections DAO for customers
 * 
 * @author Hugo
 */
public class CustomerCollectionsDAO implements CustomerDAO {
    
    private static final HashMap<String, Customer> customers = new HashMap<>();

    @Override
    public Collection<Customer> getCustomers() {
        return customers.values();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getUsername(), customer);
    }

    @Override
    public Customer searchByUsername(String username) {
        return customers.get(username);
    }
    
    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer.getUsername());
    }

    @Override
    public void removeAll() {
        customers.clear();
    }

    @Override
    public boolean matchesCustomer(String username, String password) {
        for (Customer customer : customers.values()) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    
}
