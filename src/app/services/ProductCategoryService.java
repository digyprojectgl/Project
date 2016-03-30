package app.services;

import app.model.ProductCategoryList;
import app.model.dao.ProductCategoryListJDBC;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductCategoryService {

    /**
     * Get all the categories
     * @return the ProductCategoryList containing all the categories
     * @throws Exception
     */
    public ProductCategoryList obtainCategoryList() throws Exception {
        return new ProductCategoryListJDBC();
    }
}
