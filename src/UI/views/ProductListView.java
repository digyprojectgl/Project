package UI.views;

import UI.controllers.ProductListController;
import UI.core.ViewInterface;
import app.model.Product;
import app.model.ProductCategory;
import app.model.ProductCategoryList;
import app.model.ProductList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListView implements ViewInterface {
    private ProductListController productListController;

    private JButton search;
    private JTextField nameOrDescription;
    private JComboBox category;
    private JPanel answer;
    private String defaultText = "Word in name or description...";

    public JPanel getAnswer() {
        return answer;
    }

    public void setAnswer(JPanel answer) {
        this.answer = answer;
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public JTextField getNameOrDescription() {
        return nameOrDescription;
    }

    public void setNameOrDescription(JTextField nameOrDescription) {
        this.nameOrDescription = nameOrDescription;
    }

    public JComboBox<ProductCategory> getCategory() {
        return category;
    }

    public void setCategory(JComboBox category) {
        this.category = category;
    }

    public ProductListView(ProductListController productListController) {
        this.productListController = productListController;
    }

    @Override
    public void render(Container contentPane) {
    	
 
        /*
        Set the JPanel containing all the elements
         */
        JPanel globalPanel = new JPanel(new GridLayout(0,1));

        /*
        Set the JPanel containing the search bar
         */
        JPanel searchPanel = new JPanel(new BorderLayout());

        /*
        Set the JPanel containing the text fields
        Initialize the text fields
        Fill the panel with the fields
         */
        JPanel fields = new JPanel(new GridLayout(2,0));
        this.setNameOrDescription(new JTextField(defaultText));
        this.setCategory(new JComboBox());
        this.getCategory().addItem(new ProductCategory("Any category"));
        ArrayList<ProductCategory> categories = this.productListController.obtainCategoryList().productCategories;
        for (int i = 0; i < categories.size(); i++) {
            this.getCategory().addItem(categories.get(i));
        }
        fields.add(this.getNameOrDescription());
        fields.add(this.getCategory());

        /*
        Initialize the button
         */
        this.setSearch(new JButton("Search"));
        this.getSearch().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                displayProductList();
            }
        });

        /*
        Fill the search bar
         */
        searchPanel.add(fields, BorderLayout.CENTER);
        searchPanel.add(getSearch(), BorderLayout.EAST);

        /*
        Initialize the answer panel
         */
        this.setAnswer(new JPanel(new GridLayout(0,1)));
        this.getAnswer().add(new JLabel("Products"));

        /*
        Fill the global panel
         */
        globalPanel.add(searchPanel);
        globalPanel.add(this.getAnswer());

        /*
        Add the global panel to the contentPane
         */

        contentPane.add(globalPanel, BorderLayout.CENTER);
    }

    public void displayProductList() {
        this.getAnswer().removeAll();
        this.getAnswer().add(new JLabel("Products"));

        HashMap<String,String> options = new HashMap<>();
        if (!getNameOrDescription().getText().isEmpty() && !getNameOrDescription().getText().equalsIgnoreCase(defaultText)) {
            options.put("name", getNameOrDescription().getText().trim());
        }
        if (getCategory().getSelectedIndex() != 0) {
            options.put("category", (getCategory().getSelectedItem()).toString());
        }
        ProductList products = this.productListController.obtainProductList(options);
        int size = products.productList.size();
        for (int i=0; i< size; i++) {
            final JButton product = new JButton(products.productList.get(i).toString());
            product.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayProduct(product.getText());
                }
            });
            this.getAnswer().add(product);
        }
        this.getAnswer().updateUI();
    }

    private void displayProduct(String text) {
        String[] param;
        param = text.split(" ");
        param[0] = param[0].substring(1,param[0].length()-1);
        this.productListController.goTo("product", param);
    }

    public void displayError(String e) {
        JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
    }

	@Override
	public String getLayout() {
		return "main";
	}


}
