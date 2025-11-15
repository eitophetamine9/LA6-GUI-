package PasswordValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordValidator extends JFrame {
    private JPasswordField passwordTextField;
    private JPanel panel1;
    private JLabel statusLabel;

    public PasswordValidator() {
        setTitle("Password Validation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1, 10, 10));
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel1.setPreferredSize(new Dimension(300, 120));
        setContentPane(panel1);

        passwordTextField = new JPasswordField();
        passwordTextField.setEchoChar('*');
        passwordTextField.setName("passwordTextField");

        statusLabel = new JLabel(" ");
        statusLabel.setName("statusLabel");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));

        panel1.add(passwordTextField);
        panel1.add(statusLabel);

        passwordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validatePassword(new String(passwordTextField.getPassword()));
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void validatePassword(String password) {
        if (password.length() < 8) {
            statusLabel.setText("Password must be 8 characters long");
            statusLabel.setForeground(Color.RED);
        } else if (!password.matches(".*\\d.*")) {
            statusLabel.setText("Password must contain at least one digit");
            statusLabel.setForeground(Color.RED);
        } else if (!password.matches(".*[^a-zA-Z0-9].*")) {
            statusLabel.setText("Password must contain at least one special character");
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setText("Password is valid");
            statusLabel.setForeground(Color.GREEN);
        }
    }
}
