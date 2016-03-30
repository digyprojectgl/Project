package app.model.dao;

import app.model.ProductCategory;
import app.model.ProductCategoryList;

import java.sql.ResultSet;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductCategoryListJDBC extends ProductCategoryList {

    /**
     * Get all the categories for the database
     * @throws Exception
     */
    public ProductCategoryListJDBC() throws Exception {
        JdbcConnection connection = JdbcConnection.getInstance();
        connection.openConnection();
        ResultSet res;
        try {
            connection.executeRequest("SELECT t.* FROM digyproject.ProductCategory t");
            res = connection.fetchArray();
            res.beforeFirst();
            while (res.next()) {
                this.productCategories.add(new ProductCategory(res.getString("labelPC")));
            }
        } catch (Exception e) {
            throw e;
        }

        connection.close();
    }
}
