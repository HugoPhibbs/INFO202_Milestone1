/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Collections DAO for customers
 * 
 * @author Hugo
 */
public class CustomerCollectionsDAO implements CustomerDAO {
    
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    public Collection<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer searchByID(Integer id) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), id)) {
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void removeAll() {
        customers.clear();
    }
}
