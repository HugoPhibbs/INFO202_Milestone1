package dao;

import domain.Customer;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Hugo
 */
public interface CustomerJdbiDAO extends CustomerDAO {

    @Override
    @SqlUpdate("DELETE FROM CUSTOMER")
    public void removeAll();

    @Override
    @SqlQuery("SELECT * FROM CUSTOMER ORDER BY USERNAME")
    @RegisterBeanMapper(Customer.class)
    public Collection<Customer> getCustomers();
    
    @Override
    @SqlUpdate("DELETE FROM CUSTOMER WHERE USERNAME = :username")
    public void removeCustomer(@BindBean Customer customer);

    @Override
    @SqlUpdate("INSERT INTO CUSTOMER(USERNAME, FIRSTNAME, SURNAME, PASSWORD, SHIPPING_ADDRESS, EMAIL_ADDRESS) VALUES (:username, :firstName, :surname, :password, :shippingAddress, :emailAddress)")
    public void saveCustomer(@BindBean Customer customer);

    @Override
    @SqlQuery("SELECT * FROM CUSTOMER WHERE USERNAME = :username")
    @RegisterBeanMapper(Customer.class)
    public Customer searchByUsername(@Bind("username") String username);
    
    @Override
    @SqlQuery("SELECT EXISTS (SELECT * FROM CUSTOMER WHERE USERNAME = :username AND PASSWORD = :password)")
    public boolean matchCustomer(@Bind("username") String username, @Bind("password") String password);
    
}
