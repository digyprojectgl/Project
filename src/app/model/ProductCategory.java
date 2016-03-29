package app.model;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductCategory {
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProductCategory(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
