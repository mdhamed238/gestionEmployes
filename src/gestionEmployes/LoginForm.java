package gestionEmployes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestionEmployes.MainForm;

public class LoginForm extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField ;
    JButton loginButton;
    JButton resetButton;
    JCheckBox showPassword;

    public LoginForm() {
        super("Login Form");
        container = getContentPane();
        userLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        showPassword = new JCheckBox("Show Password");

        container.setLayout(null);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);

        setVisible(true);
        setBounds(400, 100, 400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username;
            String password;
            username = userTextField.getText();
            password = passwordField.getText();
            if (username.equalsIgnoreCase("mdhamed") && password.equalsIgnoreCase("0423")) {
                dispose();
                MainForm mainForm = new MainForm();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error!", JOptionPane.WARNING_MESSAGE);
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
}

