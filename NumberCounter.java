import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame{
    private JPanel CounterPanel;
    private JButton decreaseButton;
    private JButton increaseButton;
    private JLabel countLabel;

    public NumberCounter(){
        setContentPane(CounterPanel);
        setTitle("Number Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);

        countLabel.setName("countLabel");
        countLabel.setText("0");
        decreaseButton.setText("Decrease");
        decreaseButton.setName("decreaseButton");
        increaseButton.setText("Increase");
        increaseButton.setName("increaseButton");

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(countLabel.getText());
                countLabel.setText(String.valueOf(count - 1));
            }
        });
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(countLabel.getText());
                countLabel.setText(String.valueOf(count + 1));
            }
        });
    }

    public static void main(String[] args) {
        new NumberCounter();
    }
}
