/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Hugo
 */
public class ProductCollectionsDAOTest {

    ProductDAO dao = new ProductCollectionsDAO();
    Product product1;
    Product product2;
    Product product3;
    
    
    @BeforeEach
    public void setUp() {
        product1 = new Product("1", "product1", "", "category1", new BigDecimal(0), new BigDecimal(0));
        product2 = new Product("2", "product2", "", "category2", new BigDecimal(0), new BigDecimal(0));
        product3 = new Product("3", "product3", "", "category3", new BigDecimal(0), new BigDecimal(0));
        
        dao.saveProduct(product1);
        dao.saveProduct(product2);
    }
    
    @AfterEach
    public void tearDown() {
        dao.removeAll();
    }

    @Test
    public void testSaveProduct() {
        assertThat("Checking original size", dao.getProducts(), hasSize(2));
        assertThat("Dao contains product 1", dao.searchById("1"), is(product1));
        dao.saveProduct(product1);
        assertThat("dao didn't add duplicate entry", dao.getProducts(), hasSize(2));
        
        dao.saveProduct(product3);
       
        assertThat("Size was updated", dao.getProducts(), hasSize(3));
        assertThat("product 3 was added", dao.getProducts(), hasItem(product3));
        assertThat("Product 3 cat was added", dao.getCategories(), hasItem("category3"));
        
    }

    @Test
    public void testRemoveProduct() {
        assertThat("Dao contains product 1", dao.getProducts(), hasItem(product1));
        dao.removeProduct(product1);
        assertThat("Dao removed product 1 from products", dao.getProducts(), not(hasItem(product1)));
        assertThat("Dao removed product 1 from categories", dao.getCategories(), not(hasItem("category1")));
    }

    @Test
    public void testGetProducts() {
        assertThat("Normal get", dao.getProducts(), containsInAnyOrder(product1, product2));
    }

    @Test
    public void testGetCategories() {
        assertThat("Normal get", dao.getCategories(), containsInAnyOrder("category1", "category2"));
    }

    @Test
    public void testSearchById() {
        assertThat("Searching with product that is actually contained", dao.searchById("1"), is(product1));
        
        assertThat("Search with product that is not contained", dao.searchById("3"), is(nullValue()));
    }

    @Test
    public void testFilterByCategory() {
        assertThat("Checking for a category with just one product", dao.filterByCategory("category2"), hasItem(product2));
        assertThat("Checking for a category with just one product ahs correct size", dao.filterByCategory("category2"), hasSize(1));
        
        Product product11 = new Product("11", "product11", "", "category1", new BigDecimal(0), new BigDecimal(0));
        dao.saveProduct(product11);
        assertThat("Checking with multiple products for a category", dao.filterByCategory("category1"), containsInAnyOrder(product1, product11));
        assertThat("Checking with multiple products for a category has correct size", dao.filterByCategory("category1"), hasSize(2));
    }
    
    @Test
    public void testRemoveAl() {
        assertThat("Check that products are non empty", dao.getProducts(), not(empty()));
        assertThat("Check that products are non empty", dao.getCategories(), not(empty()));
        dao.removeAll();
        assertThat("Check that products are empty", dao.getProducts(), empty());
        assertThat("Check that products are empty", dao.getCategories(), empty());
    }
}
