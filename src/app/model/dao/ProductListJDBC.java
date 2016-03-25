package app.model.dao;

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
                    query = query.concat("\nAND ");
                }
            }

            if (options.containsKey("name")) {
                String[] nameSearch = options.get("name").split(" ");
                if (nameSearch.length >= 0) {
                    query = query.concat("Product.labelProduct REGEXP '" + nameSearch[0]);

                    for (int i=1; i<nameSearch.length; i++) {
                        query = query.concat("|" + nameSearch[i]);
                    }
                    query = query.concat("'");
                }
            }
        }

        try { //TODO finish this part of the method, in order to get the results in the array of ProductList
            connection.executeRequest(query);
            res = connection.fetchArray();
            int rowCount = 0;
            boolean last = res.last();
            if (last) {
                rowCount=res.getRow();
                res.beforeFirst();
            }
            if (rowCount == 0) {
                throw new Exception("Pas de résultat !");
            }
        } catch (Exception e){
            throw e;
        }

        connection.close();
    }

}
