package app.model.dao;

import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductList;
import java.sql.*;
import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListJDBC extends ProductList {
    /**
     * Get the list of products according to the parameters given in the hashMap.
     * Returns a list of Product in the attribute productList.
     * @param options HashMap containing the options for the selection of the list
     * @throws Exception if there is no product to display or the database returns a problem.
     */
    public ProductListJDBC(HashMap<String,String> options) throws Exception {
        JdbcConnection connection = JdbcConnection.getInstance();
        connection.openConnection();
        ResultSet res;
        String query = "SELECT * FROM Product";

        if (options.containsKey("name") || options.containsKey("category")) {
            query = query.concat(" WHERE ");

            if (options.containsKey("category")) {
                query = query + "Product.labelPC = '" + options.get("category") + "'";
                if (options.containsKey("name")) {
                    query = query.concat(" \nAND ");
                }
            }

            if (options.containsKey("name")) {
                String[] nameSearch = options.get("name").split(" ");
                if (nameSearch.length >= 0) {
                    query = query.concat("Product.labelProduct LIKE '%" + nameSearch[0] + "%'");

                    for (int i=1; i<nameSearch.length; i++) {
                        query = query.concat(" OR Product.labelProduct LIKE '%" + nameSearch[i] + "%'");
                    }

                }
            }
        }

        try {
            connection.executeRequest(query);
            res = connection.fetchArray();
            res.beforeFirst();
            while (res.next()) {
                this.productList.add(new Product(res.getString("labelProduct"), res.getString("description"), new ProductCategory(res.getString("labelPC")), res.getString("status")));
            }
        } catch (Exception e){
            throw e;
        }

        connection.close();
    }

}
