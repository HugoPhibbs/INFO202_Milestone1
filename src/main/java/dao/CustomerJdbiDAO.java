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
    @SqlUpdate
    public void removeAll();

    @Override
    @SqlQuery("SELECT * FROM CUSTOMER ORDER BY USERNAME")
    @RegisterBeanMapper(Customer.class)
    public Collection<Customer> getCustomers();
    
    @Override
    @SqlUpdate("DELETE FROM CUSTOMER WHERE USERNAME = :userName")
    public void removeCustomer(@BindBean Customer customer);

    @Override
    @SqlUpdate("MERGE INTO CUSTOMER(ID, USERNAME, FIRSTNAME, SURNAME, SHIPPING_ADDRESS, EMAIL_ADDRESS) VALUES (:id, :userName, :firstName, :shippingAddress, id:emailAddress)")
    public void saveCustomer(@BindBean Customer customer);

    @Override
    @SqlQuery("SELECT FROM CUSTOMER WHERE USERNAME = :userName")
    @RegisterBeanMapper(Customer.class)
    public Customer searchByUsername(@Bind("userName") String username);
    
    @Override
    @SqlQuery
    public boolean matchesCustomer(String username, String password);
    
}
