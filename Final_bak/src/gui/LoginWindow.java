package gui;

import dao.DAORequest;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginWindow extends JFrame {

    private JTextField userField;
    private JPasswordField passField;
    private DAORequest dao;

    public LoginWindow() {
        dao = new DAORequest();
        setTitle("Login - MiniPostman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(userLabel, gbc);

        userField = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(userField, gbc);

        JLabel passLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(passLabel, gbc);

        passField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passField, gbc);

        JPanel buttonPanel = new JPanel();
        JButton loginBtn = new JButton("Iniciar sesión");
        JButton registerBtn = new JButton("Registrarse");

        loginBtn.addActionListener(this::login);
        registerBtn.addActionListener(this::registrar);
        buttonPanel.add(loginBtn);
        buttonPanel.add(registerBtn);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
    }

    private void login(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        Usuario u = dao.login(user, pass);
        if (u != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + u.getUsername());
            MainWindow mw = new MainWindow(u.getId(), u.getUsername());
            mw.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    private void registrar(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario y/o la contraseña no pueden estar vacíos");
            return;
        }

        if (dao.registrar(user, pass)) {
            JOptionPane.showMessageDialog(this, "Registrado correctamente, ahora podés iniciar sesión");
        } else {
            JOptionPane.showMessageDialog(this, "El usuario ya existe");
        }
    }
}
