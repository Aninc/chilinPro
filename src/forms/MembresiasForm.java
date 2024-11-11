package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MembresiasForm extends JFrame {

    public MembresiasForm() {
        // Configuración del marco
        setTitle("VHS Palace - Membresías");
        setSize(1280, 720); // Tamaño ajustado a 1280x720
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(MembresiasForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        logoLabel.setBounds(30, 10, 80, 45); // Tamaño reducido del logo
        add(logoLabel);

        // Panel para la barra de menú en la parte superior derecha
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(650, 10, 580, 40); // Posición ajustada para incluir todos los botones
        menuPanel.setBackground(new Color(24, 32, 46));
        menuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10)); // Espaciado entre botones
        add(menuPanel);

        String[] menuItems = {"Principal", "Películas", "Series", "Preguntas", "Compras", "Membresías", "Perfil"};
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setForeground(Color.LIGHT_GRAY);
            menuButton.setBackground(new Color(24, 32, 46));
            menuButton.setBorder(BorderFactory.createEmptyBorder());
            menuButton.setFocusPainted(false);
            menuButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
            menuPanel.add(menuButton);
        }

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(300, 10, 300, 40); // Mover el título a la izquierda
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(titleLabel);

        // Título de la sección
        JLabel sectionTitle = new JLabel("Planes de Membresía");
        sectionTitle.setBounds(50, 80, 400, 40);
        sectionTitle.setForeground(new Color(59, 215, 245)); // Color cian/neón
        sectionTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(sectionTitle);

        // Panel para las opciones de membresía
        JPanel membershipPanel = new JPanel();
        membershipPanel.setBounds(50, 150, 1180, 450);
        membershipPanel.setBackground(new Color(24, 32, 46));
        membershipPanel.setLayout(new GridLayout(1, 2, 20, 0));
        add(membershipPanel);

        // Membresía FREE
        JPanel freePanel = crearPanelMembresia("FREE", "Acceso limitado al contenido.", "FREE");
        membershipPanel.add(freePanel);

        // Membresía Económica
        JPanel ecoPanel = crearPanelMembresia("Económica", "Acceso completo a todo el catálogo.", "ECONOMICA");
        membershipPanel.add(ecoPanel);

        // Mostrar el marco
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    private JPanel crearPanelMembresia(String tipo, String descripcion, String planType) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(15, 17, 26));
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(tipo, SwingConstants.CENTER);
        titleLabel.setForeground(new Color(59, 215, 245));
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea descriptionArea = new JTextArea(descripcion);
        descriptionArea.setEditable(false);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setBackground(new Color(15, 17, 26));
        descriptionArea.setForeground(Color.LIGHT_GRAY);
        descriptionArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panel.add(descriptionArea, BorderLayout.CENTER);

        JButton selectButton = new JButton("Seleccionar " + tipo);
        selectButton.setBackground(new Color(222, 54, 206));
        selectButton.setForeground(Color.WHITE);
        selectButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        selectButton.setFocusPainted(false);
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhs_palace_db", "root", "password"); // Ajusta según tu configuración
                    String query = "UPDATE users SET membership = ? WHERE user_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, planType);
                    stmt.setInt(2, 1); // Suponiendo que el ID del usuario actual es 1 (ajusta esto según la lógica del proyecto)

                    int updatedRows = stmt.executeUpdate();
                    if (updatedRows > 0) {
                        JOptionPane.showMessageDialog(MembresiasForm.this, "Membresía actualizada a " + tipo);
                        new MainForm(); // Redirigir a la página principal
                        dispose(); // Cerrar la ventana actual
                    } else {
                        JOptionPane.showMessageDialog(MembresiasForm.this, "Error al actualizar la membresía.");
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(MembresiasForm.this, "Error al conectar con la base de datos.");
                }
            }
        });
        panel.add(selectButton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        new MembresiasForm();
    }
}
