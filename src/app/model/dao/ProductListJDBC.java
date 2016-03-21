package app.model.dao;

import app.model.ProductList;

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
    public ProductListJDBC(HashMap<String,String> options){
        JdbcConnection connection = new JdbcConnection();
        connection.openConnection();
        /**
         * TODO complete the end of this method, after working on the database
         */

        connection.close();
    }

}
