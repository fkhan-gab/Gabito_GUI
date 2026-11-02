import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JPanel FormPanel;

    private final JDialog statusDialog;
    private final JLabel messageLabel;

    public LoginForm() {

        setContentPane(FormPanel);
        setTitle("Login Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        userNameTextField.setName("userNameTextField");
        passwordTextField.setName("passwordTextField");
        loginButton.setName("loginButton");
        loginButton.setText("Login");
        passwordTextField.setEchoChar('*');

        statusDialog = new JDialog();
        messageLabel = new JLabel();
        statusDialog.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userNameTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                if(user.equals("admin") && password.equals("admin")) {
                    messageLabel.setText("Login Successful");
                }else  {
                    messageLabel.setText("Login Failed");
                }

                statusDialog.pack();
                statusDialog.setVisible(true);
                statusDialog.setLocationRelativeTo(LoginForm.this);
                statusDialog.setSize(250, 120);
                statusDialog.setTitle("Status");


            }
        });
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
