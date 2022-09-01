/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 * Factory for creating DAO objects
 * 
 * @author Hugo
 */
public class DaoFactory {
    
    /**
     * Creates and returns a new ProductDAO
     * 
     * @return ProductDAO as described
     */
    public static ProductDAO getProductDAO() {
        return JdbiDaoFactory.getProductDAO();
        // return new ProductCollectionsDAO();
    }
    
    /**
     * Creates and returns a new CustomerDAO
     * 
     * @return CustomerDAO as described
     */
    public static CustomerDAO getCustomerDAO() {
        return JdbiDaoFactory.getCustomerDAO();
        // return new CustomerCollectionsDAO();
    }
}
