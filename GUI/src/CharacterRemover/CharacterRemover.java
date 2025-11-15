package CharacterRemover;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterRemover extends JFrame{

    private JPanel contentPane;
    private JCheckBox vowelCheckBox;
    private JCheckBox consonantCheckBox;
    private JCheckBox numberCheckBox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;

    private final String DEFAULT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public CharacterRemover() {
        setTitle("Character Remover");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        vowelCheckBox.setName("vowelCheckBox");
        consonantCheckBox.setName("consonantCheckBox");
        numberCheckBox.setName("numberCheckBox");

        removeButton.setName("removeButton");
        restoreButton.setName("restoreButton");
        textLabel.setName("textLabel");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textLabel.getText();

                boolean removeVowel = vowelCheckBox.isSelected();
                boolean removeConsonant = consonantCheckBox.isSelected();
                boolean removeNumber = numberCheckBox.isSelected();

                StringBuilder newLabel = new StringBuilder();

                for (char c : currentText.toCharArray()) {
                    boolean keepCharacter = true;

                    if (Character.isLetter(c)) {
                        boolean isVowel = "AEIOU".indexOf(c) != -1;

                        if (isVowel && removeVowel) {
                            keepCharacter = false;
                        } else if (!isVowel && removeConsonant) {
                            keepCharacter = false;
                        }
                    } else if (Character.isDigit(c)) {
                        if (removeNumber) {
                            keepCharacter = false;
                        }
                    }

                    if (keepCharacter) {
                        newLabel.append(c);
                    }
                    textLabel.setText(newLabel.toString());
                }
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText(DEFAULT);
            }
        });
    }
}