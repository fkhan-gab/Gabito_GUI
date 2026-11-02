import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderSystem extends JFrame {
    private JComboBox<Product> pizzaSizeChoice;
    private JComboBox<Product> pizzaToppingsChoice;
    private JComboBox<Product> extraCheeseChoice;
    private JButton calculateButton;
    private JPanel OrderPanel;
    private JLabel totalLabel;


    public PizzaOrderSystem() {
        setContentPane(OrderPanel);
        setTitle("Pizza Order System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);

        totalLabel.setName("totalLabel");
        totalLabel.setText("0");
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingsChoice.setName("pizzaToppingChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        calculateButton.setName("calculateButton");


        pizzaSizeChoice.addItem(new Product("Small", 10));
        pizzaSizeChoice.addItem(new Product("Medium", 15));
        pizzaSizeChoice.addItem(new Product("Large", 20));

        pizzaToppingsChoice.addItem(new Product("Mushroom", 2));
        pizzaToppingsChoice.addItem(new Product("Pepperoni", 2));
        pizzaToppingsChoice.addItem(new Product("Onion", 2));

        extraCheeseChoice.addItem(new Product("Yes", 3));
        extraCheeseChoice.addItem(new Product("No", 0));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total;
                Product size = (Product) pizzaSizeChoice.getSelectedItem();
                Product topping = (Product) pizzaToppingsChoice.getSelectedItem();
                Product cheese = (Product) extraCheeseChoice.getSelectedItem();

                total = size.price + topping.price + cheese.price;
                totalLabel.setText(String.valueOf(total));
            }
        });
    }

    static class Product {
        String choice;
        int price;

        Product(String choice, int price){
            this.choice = choice;
            this.price = price;
        }
        public String toString(){
            return choice;
        }
    }


    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}
