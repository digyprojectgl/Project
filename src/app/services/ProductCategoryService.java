package app.services;

import app.model.ProductCategoryList;
import app.model.dao.ProductCategoryListJDBC;

/**
 * Created on 27/03/2016.
 *
 * @author Arthur
 */
public class ProductCategoryService {
    public ProductCategoryList obtainCategoryList() throws Exception {
        return new ProductCategoryListJDBC();
    }
}
