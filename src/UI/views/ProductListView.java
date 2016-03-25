package UI.views;

import UI.controllers.ProductListController;
import UI.core.ViewInterface;
import app.model.Product;
import app.model.ProductList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created on 20/03/2016.
 *
 * @author Arthur
 */
public class ProductListView implements ViewInterface {
    private ProductListController productListController;

    JButton search;
    JTextField nameOrDescription;
    JTextField category;
    JPanel answer;

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

    public JTextField getCategory() {
        return category;
    }

    public void setCategory(JTextField category) {
        this.category = category;
    }

    public ProductListView(ProductListController productListController) {
        this.productListController = productListController;
    }
    
    public void render(Container contentPane) {
    	
 
        /*
        Set the JPanel containing all the elements
         */
        JPanel globalPanel = new JPanel();

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
        this.setNameOrDescription(new JTextField("Word in name or description..."));
        this.setCategory(new JTextField("Category..."));
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
        this.setAnswer(new JPanel());

        /*
        Fill the global panel
         */
        globalPanel.add(searchPanel, BorderLayout.NORTH);
        globalPanel.add(this.getAnswer(), BorderLayout.CENTER);

        /*
        Add the global panel to the contentPane
         */

        contentPane.add(globalPanel, BorderLayout.CENTER);
    }

    public void displayProductList() {
        HashMap<String,String> options = new HashMap<>();
        if (!getNameOrDescription().getText().isEmpty()) {
            options.put("name", getNameOrDescription().getText().trim());
        }
        if (!getCategory().getText().isEmpty()) {
            options.put("category", getCategory().getText().trim());
        }
        Object item = this.productListController.obtainProductList(options);
        if (item instanceof Exception) {
            JOptionPane.showMessageDialog(this.getAnswer(), item, "Java ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            ProductList products = (ProductList) item;
            this.getAnswer().add(new JList<Product>(products.productList));
        }
    }

	@Override
	public String getLayout() {
		return "main";
	}


}
