<%-- 
    Document   : view-products
    Created on : 16/08/2022, 5:07:42 pm
    Author     : Hugo
--%>

<%@page import="dao.DaoFactory"%>
<%@page import="dao.JdbiDaoFactory"%>
<%@page import="dao.ProductDAO"%>
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
        <jsp:include page = "nav.jsp"></jsp:include>
        <div>
            <%
                ProductDAO dao = DaoFactory.getProductDAO();

                String category = request.getParameter("cat");

                Collection<Product> products;

                if (category == null || category.equals("All")) {
                    products = dao.getProducts();
                } else {
                    products = dao.filterByCategory(category);
                }

                System.out.print(dao.getCategories());
            %>

            <a href = "view-products.jsp?cat=All"><button>All</button></a>

            <%
                for (String cat : dao.getCategories()) {
            %>

            <a href = "view-products.jsp?cat=<%=cat%>"><button><%= cat%></button></a>
            <%
                }
            %>
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
                        for (Product product : products) {
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
