package gui;

import modelo.Request;
import service.HttpExecutor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import org.json.JSONObject;

public class MainWindow extends JFrame {

    private JComboBox<String> methodBox;
    private JTextField urlField;
    private JTextArea bodyArea;
    private JTable headersTable;
    private JTextArea rawResponseArea;
    private JTextArea prettyResponseArea;
    private JButton sendButton;
    private JButton guardarFavoritoButton;
    private JButton eliminarFavoritoButton;
    private JComboBox<String> favoritosBox;
    private java.util.List<Request> favoritos;
    private int userId;
    private String username;

    public MainWindow(int userId, String username) {
        this.userId = userId;
        this.username = username;

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

        JLabel userLabel = new JLabel("👤 " + username);
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        userLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userPanel.add(userLabel);

        topPanel.add(methodPanel, BorderLayout.WEST);
        topPanel.add(centerTop, BorderLayout.CENTER);
        topPanel.add(userPanel, BorderLayout.EAST);

        return topPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        String[] columnas = {"Clave", "Valor"};
        Object[][] datosIniciales = {
                {"User-Agent", "MiniPostman"},
                {"Accept", "*/*"}
        };
        DefaultTableModel model = new DefaultTableModel(datosIniciales, columnas);
        headersTable = new JTable(model);

        JScrollPane headersScroll = new JScrollPane(headersTable);
        headersScroll.setBorder(new TitledBorder("Encabezados"));

        JPanel headersPanel = new JPanel(new BorderLayout());
        headersPanel.add(headersScroll, BorderLayout.CENTER);

        JButton agregarHeaderBtn = new JButton("Agregar Header");
        agregarHeaderBtn.addActionListener(e -> model.addRow(new Object[]{"", ""}));
        headersPanel.add(agregarHeaderBtn, BorderLayout.SOUTH);


        bodyArea = new JTextArea(10, 30);
        bodyArea.setBorder(new TitledBorder("Cuerpo de la Request"));

        rawResponseArea = new JTextArea();
        rawResponseArea.setEditable(false);

        prettyResponseArea = new JTextArea();
        prettyResponseArea.setEditable(false);

        JTabbedPane responseTabs = new JTabbedPane();
        responseTabs.addTab("Raw", new JScrollPane(rawResponseArea));
        responseTabs.addTab("Formateada", new JScrollPane(prettyResponseArea));

        centerPanel.add(headersPanel);
        centerPanel.add(new JScrollPane(bodyArea));
        centerPanel.add(responseTabs);

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

        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setPreferredSize(new Dimension(160, 40));
        logoutButton.addActionListener(this::cerrarSesion);
        bottom.add(logoutButton);


        return bottom;
    }


    private void enviarRequest(ActionEvent e) {
        try {
            Request r = new Request();
            r.setMethod((String) methodBox.getSelectedItem());
            r.setUrl(urlField.getText());
            r.setHeaders(obtenerHeadersComoTexto());
            r.setBody(bodyArea.getText());
            r.setTimestamp(LocalDateTime.now());

            String res = HttpExecutor.ejecutar(r);
            r.setResponse(res);

            rawResponseArea.setText(res);

            try {
                org.json.JSONObject json = new org.json.JSONObject(res);
                prettyResponseArea.setText(json.toString(4));
            } catch (Exception ex2) {
                prettyResponseArea.setText("Respuesta no es JSON válido.");
            }

        } catch (Exception ex) {
            rawResponseArea.setText("Error: " + ex.getMessage());
            prettyResponseArea.setText("");
        }
    }


    private String obtenerHeadersComoTexto() {
        StringBuilder sb = new StringBuilder();
        DefaultTableModel model = (DefaultTableModel) headersTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object key = model.getValueAt(i, 0);
            Object value = model.getValueAt(i, 1);
            if (key != null && value != null && !key.toString().isEmpty()) {
                sb.append(key.toString()).append(": ").append(value.toString()).append("\n");
            }
        }
        return sb.toString();
    }


    private void cargarFavoritosDesdeDB() {
        try {
            dao.DAORequest dao = new dao.DAORequest();
            favoritos = dao.obtenerFavoritos(userId);
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

            DefaultTableModel model = (DefaultTableModel) headersTable.getModel();
            model.setRowCount(0);
            for (String line : r.getHeaders().split("\n")) {
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    model.addRow(new Object[]{parts[0].trim(), parts[1].trim()});
                }
            }

            bodyArea.setText(r.getBody());
            rawResponseArea.setText("");
            prettyResponseArea.setText("");
        }
    }


    private void guardarFavorito(ActionEvent e) {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del favorito:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre inválido.");
            return;
        }

        for (Request fav : favoritos) {
            if (fav.getFavoriteName().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(this, "Ya existe un favorito con ese nombre.");
                return;
            }
        }

        try {
            Request r = new Request();
            r.setMethod((String) methodBox.getSelectedItem());
            r.setUrl(urlField.getText());
            r.setHeaders(obtenerHeadersComoTexto());
            r.setBody(bodyArea.getText());
            r.setTimestamp(LocalDateTime.now());
            r.setFavoriteName(nombre);
            r.setUserId(userId);
            r.setResponse("");

            dao.DAORequest dao = new dao.DAORequest();
            dao.insertar(r);

            favoritosBox.addItem(nombre);
            favoritos = dao.obtenerFavoritos(userId);

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
            bodyArea.setText("");
            DefaultTableModel model = (DefaultTableModel) headersTable.getModel();
            model.setRowCount(0);
            rawResponseArea.setText("");
            prettyResponseArea.setText("");

            JOptionPane.showMessageDialog(this, "Favorito eliminado correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar favorito: " + ex.getMessage());
        }
    }

    private void cerrarSesion(ActionEvent e) {
        dispose();
        new LoginWindow().setVisible(true);
    }

}
