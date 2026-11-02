import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleCalculator extends JFrame {
    private JTextField tfNUmber1;
    private JComboBox<String> cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JLabel lblResult;
    private JPanel CalculatorPanel;

    public SimpleCalculator() {
        setContentPane(CalculatorPanel);
        setTitle("Number Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550,300);
        setLocationRelativeTo(null);
        setVisible(true);

        tfNUmber1.setName("tfNUmber1");
        tfNumber2.setName("tfNumber2");
        cbOperations.setName("cbOperations");
        btnCompute.setName("btnCompute");
        lblResult.setName("lblResult");
        btnCompute.setText("Compute Result");
        lblResult.setText("0");

        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");

        createFile();

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a, b;
                try{
                    a = Double.parseDouble(tfNUmber1.getText());
                    b = Double.parseDouble(tfNumber2.getText());
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                    return;
                }

                String operation = cbOperations.getSelectedItem().toString();
                double res = 0;

                switch (operation) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        if(b == 0){
                            JOptionPane.showMessageDialog(CalculatorPanel, "Cannot divide by zero");
                            return;
                        }
                        res = a / b;
                        break;
                }

                if(res % 1 == 0){
                    lblResult.setText(String.valueOf((long)res));

                }else{
                    lblResult.setText(String.valueOf(res));
                }

                String num1 = (a % 1 == 0) ? String.valueOf((long)a) : String.valueOf(a);
                String num2 = (b % 1 == 0) ? String.valueOf((long)b) : String.valueOf(b);

                System.out.println("Computation: " + num1 + " " + operation + " " + num2 + " = " + lblResult.getText());

                CalculatorCVS(a, b, operation);
            }
        });
    }

    private void createFile(){
        File file = new File("Computation.csv");
        try{
            if(file.createNewFile()){
                System.out.println("File created");
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            System.out.println("Error in creating file");
        }
    }

    private void CalculatorCVS(double a, double b, String operation) {

        String num1 = (a % 1 == 0) ? String.valueOf((long)a) : String.valueOf(a);
        String num2 = (b % 1 == 0) ? String.valueOf((long)b) : String.valueOf(b);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Computation.csv", true))){
            String data = "Computation: " + num1 + " " + operation + " " + num2 + " = " + lblResult.getText();
            bw.write(data);
            bw.newLine();
        }catch (IOException e){
            System.out.println("Error writing computations" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}



