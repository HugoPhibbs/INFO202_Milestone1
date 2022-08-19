<%-- 
    Document   : view-products
    Created on : 16/08/2022, 5:07:42 pm
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@page import ="dao.ProductCollectionsDAO"%>
<%@page import ="domain.Product"%>
<%@page import ="java.util.Collection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>View Products</title>
    </head>
    <body>
        <header><h1>View Products</h1></header>

    <div>
        <form>
            <label for ="select-category">Category:</label>
            <select name ="chosenCategory" id = "select-category"></select>
            <option value = "all">
                All
            </option>
            <%
                ProductCollectionsDAO dao = new ProductCollectionsDAO();
                
                for (String cat: dao.getCategories()){
            %>
          
            
            <option value = "<%=cat%>">
                <%=cat%>
            </option>
            
            <%
                }
              %>
        </form>
        
        <table>
            <thead>
                <tr>
                    <th>
                        Name
                    </th>
                    <th>
                        Category
                    </th>
                    <th>
                        Price
                    </th>
                    <th>
                        Stock
                    </th>
                </tr>
            </thead>
            <tbody>
                <%  
                    String chosenCategory = request.getParameter("chosenCategory");
                    Collection<Product> chosenProducts;
                    if (chosenCategory.equals("all")) {
                       chosenProducts = dao.getProducts();
                    } else{
                        chosenProducts = dao.filterByCategory(chosenCategory);
                    }
                
                    for (Product product : chosenProducts) {
                %>

                <tr>
                    <td><%=product.getName()%></td>
                    <td><%=product.getCategory()%></td>
                    <td><%=product.getListPrice()%></td>
                    <td><%=product.getQuantityInStock()%></td>
                    <td><button>Buy</button></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
