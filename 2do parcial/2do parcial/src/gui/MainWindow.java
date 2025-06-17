package gui;

import modelo.Request;
import service.HttpExecutor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

public class MainWindow extends JFrame {

    private JComboBox<String> methodBox;
    private JTextField urlField;
    private JTextArea headersArea;
    private JTextArea bodyArea;
    private JTextArea responseArea;
    private JButton sendButton;
    private JButton guardarFavoritoButton;
    private JButton eliminarFavoritoButton;
    private JComboBox<String> favoritosBox;
    private java.util.List<Request> favoritos;

    public MainWindow() {
        setTitle("Mini Postman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
        cargarFavoritosDesdeDB();
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));

        methodBox = new JComboBox<>(new String[]{"GET", "POST", "PUT", "DELETE"});
        urlField = new JTextField("https://httpbin.org/get");

        JPanel methodPanel = new JPanel();
        methodPanel.add(new JLabel("Método:"));
        methodPanel.add(methodBox);


        favoritosBox = new JComboBox<>();
        favoritosBox.addItem("Seleccionar favorito...");
        favoritosBox.addActionListener(e -> cargarFavorito());

        JPanel centerTop = new JPanel(new BorderLayout());
        centerTop.add(urlField, BorderLayout.CENTER);
        centerTop.add(favoritosBox, BorderLayout.SOUTH);

        topPanel.add(methodPanel, BorderLayout.WEST);
        topPanel.add(centerTop, BorderLayout.CENTER);

        return topPanel;
    }



    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        headersArea = new JTextArea(10, 30);
        headersArea.setText("User-Agent: MiniPostman\nAccept: */*");
        headersArea.setBorder(new TitledBorder("Encabezados"));

        bodyArea = new JTextArea(10, 30);
        bodyArea.setBorder(new TitledBorder("Cuerpo de la Request"));

        responseArea = new JTextArea(20, 50);
        responseArea.setEditable(false);
        responseArea.setBorder(new TitledBorder("Respuesta del servidor"));

        centerPanel.add(new JScrollPane(headersArea));
        centerPanel.add(new JScrollPane(bodyArea));
        centerPanel.add(new JScrollPane(responseArea));

        return centerPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottom = new JPanel();

        sendButton = new JButton("Enviar");
        sendButton.setPreferredSize(new Dimension(120, 40));
        sendButton.addActionListener(this::enviarRequest);
        bottom.add(sendButton);

        guardarFavoritoButton = new JButton("Guardar como favorito");
        guardarFavoritoButton.setPreferredSize(new Dimension(200, 40));
        guardarFavoritoButton.addActionListener(this::guardarFavorito);
        bottom.add(guardarFavoritoButton);

        eliminarFavoritoButton = new JButton("Eliminar favorito");
        eliminarFavoritoButton.setPreferredSize(new Dimension(180, 40));
        eliminarFavoritoButton.addActionListener(this::eliminarFavorito);
        bottom.add(eliminarFavoritoButton);

        return bottom;
    }


    private void enviarRequest(ActionEvent e) {
        try {
            Request r = new Request();
            r.setMethod((String) methodBox.getSelectedItem());
            r.setUrl(urlField.getText());
            r.setHeaders(headersArea.getText());
            r.setBody(bodyArea.getText());
            r.setTimestamp(LocalDateTime.now());

            String res = HttpExecutor.ejecutar(r);
            r.setResponse(res);
            responseArea.setText(res);
        } catch (Exception ex) {
            responseArea.setText("Error: " + ex.getMessage());
        }
    }

    private void cargarFavoritosDesdeDB() {
        try {
            dao.DAORequest dao = new dao.DAORequest();
            favoritos = dao.obtenerFavoritos();
            for (Request r : favoritos) {
                favoritosBox.addItem(r.getFavoriteName());
            }
        } catch (Exception ex) {
            System.err.println("Error al cargar favoritos: " + ex.getMessage());
        }
    }

    private void cargarFavorito() {
        int index = favoritosBox.getSelectedIndex() - 1;
        if (index >= 0 && index < favoritos.size()) {
            Request r = favoritos.get(index);
            methodBox.setSelectedItem(r.getMethod());
            urlField.setText(r.getUrl());
            headersArea.setText(r.getHeaders());
            bodyArea.setText(r.getBody());
            responseArea.setText("");
        }
    }

    private void guardarFavorito(ActionEvent e) {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del favorito:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre inválido.");
            return;
        }

        try {
            Request r = new Request();
            r.setMethod((String) methodBox.getSelectedItem());
            r.setUrl(urlField.getText());
            r.setHeaders(headersArea.getText());
            r.setBody(bodyArea.getText());
            r.setTimestamp(LocalDateTime.now());
            r.setFavoriteName(nombre);

            r.setResponse("");

            dao.DAORequest dao = new dao.DAORequest();
            dao.insertar(r);

            favoritosBox.addItem(nombre);
            favoritos = dao.obtenerFavoritos();

            JOptionPane.showMessageDialog(this, "Favorito guardado correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar favorito: " + ex.getMessage());
        }
    }

    private void eliminarFavorito(ActionEvent e) {
        int index = favoritosBox.getSelectedIndex() - 1;
        if (index < 0 || index >= favoritos.size()) {
            JOptionPane.showMessageDialog(this, "Seleccioná un favorito válido para eliminar.");
            return;
        }

        Request r = favoritos.get(index);
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro que querés eliminar el favorito \"" + r.getFavoriteName() + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            dao.DAORequest dao = new dao.DAORequest();
            dao.eliminarFavoritoPorNombre(r.getFavoriteName());

            favoritos.remove(index);
            favoritosBox.removeItemAt(index + 1);
            favoritosBox.setSelectedIndex(0);

            methodBox.setSelectedIndex(0);
            urlField.setText("");
            headersArea.setText("");
            bodyArea.setText("");
            responseArea.setText("");

            JOptionPane.showMessageDialog(this, "Favorito eliminado correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar favorito: " + ex.getMessage());
        }
    }

}
