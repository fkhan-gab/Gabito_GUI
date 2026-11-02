import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterRemover extends JFrame {

    private JCheckBox vowelCheckbox;
    private JCheckBox consonantCheckbox;
    private JCheckBox numberCheckbox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;
    private JPanel RemoverPanel;

    public CharacterRemover() {
        setContentPane(RemoverPanel);
        setTitle("Character Remover");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,280);
        setLocationRelativeTo(null);
        setVisible(true);

        vowelCheckbox.setName("vowelCheckbox");
        vowelCheckbox.setText("Vowels");
        consonantCheckbox.setName("consonantCheckbox");
        consonantCheckbox.setText("Consonants");
        numberCheckbox.setName("numberCheckbox");
        numberCheckbox.setText("Numbers");
        removeButton.setName("removeButton");
        removeButton.setText("Remove");
        restoreButton.setName("restoreButton");
        restoreButton.setText("Restore");
        textLabel.setName("textLabel");
        textLabel.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");


        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = textLabel.getText();

                if(vowelCheckbox.isSelected()){
                    text = text.replaceAll("[AEIOU]", "");
                }
                if(consonantCheckbox.isSelected()){
                    text = text.replaceAll("[B-DF-HJ-NP-TV-Z]", "");
                }
                if(numberCheckbox.isSelected()){
                    text = text.replaceAll("[0-9]", "");
                }
                textLabel.setText(text);
            }
        });
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            }
        });
    }

    static void main() {
        new  CharacterRemover();
    }
}
