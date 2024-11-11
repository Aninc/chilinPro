package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PerfilForm extends JFrame {

    public PerfilForm() {
        // Configuración del marco
        setTitle("VHS Palace - Perfil");
        setSize(1280, 720); // Tamaño ajustado a 1280x720
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(PerfilForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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
            
            // Agregar ActionListener para cada botón (personaliza según lo que necesites)
            menuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(PerfilForm.this, "Botón '" + item + "' presionado.");
                }
            });

            menuPanel.add(menuButton);
        }

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(300, 10, 300, 40); // Mover el título a la izquierda
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(titleLabel);

        // Título de la sección
        JLabel sectionTitle = new JLabel("Perfil de Usuario");
        sectionTitle.setBounds(50, 80, 400, 40);
        sectionTitle.setForeground(new Color(59, 215, 245)); // Color cian/neón
        sectionTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(sectionTitle);

        // Panel de información del usuario
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setBounds(50, 150, 1180, 450); // Ajustar tamaño del panel
        userInfoPanel.setBackground(new Color(24, 32, 46));
        userInfoPanel.setLayout(new GridLayout(5, 1, 10, 10)); // Grid para mostrar la información
        add(userInfoPanel);

        // Etiquetas de información
        String[] userDetails = {
            "Nombre: Juan Pérez",
            "Correo: juan.perez@example.com",
            "Membresía: Premium",
            "Fecha de Registro: 01/01/2024",
            "Último Acceso: 09/11/2024"
        };

        JLabel nameLabel = new JLabel(userDetails[0]);
        nameLabel.setForeground(Color.LIGHT_GRAY);
        nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 16));
        userInfoPanel.add(nameLabel);

        for (int i = 1; i < userDetails.length; i++) {
            JLabel detailLabel = new JLabel(userDetails[i]);
            detailLabel.setForeground(Color.LIGHT_GRAY);
            detailLabel.setFont(new Font("Monospaced", Font.PLAIN, 16));
            userInfoPanel.add(detailLabel);
        }

        // Botón de editar perfil
        JButton editProfileButton = new JButton("Editar Perfil");
        editProfileButton.setBounds(50, 620, 150, 30);
        editProfileButton.setBackground(new Color(222, 54, 206));
        editProfileButton.setForeground(Color.WHITE);
        editProfileButton.setBorder(BorderFactory.createEmptyBorder());
        editProfileButton.setFocusPainted(false);
        editProfileButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        add(editProfileButton);

        // Funcionalidad para editar el nombre
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = JOptionPane.showInputDialog(PerfilForm.this, "Ingrese su nuevo nombre:", "Editar Nombre", JOptionPane.PLAIN_MESSAGE);
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhs_palace_db", "root", "password");
                        String query = "UPDATE usuarios SET nombre = ? WHERE user_id = ?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, nuevoNombre);
                        stmt.setInt(2, 1); // Aquí deberías usar el ID del usuario logueado
                        stmt.executeUpdate();
                        conn.close();
                        nameLabel.setText("Nombre: " + nuevoNombre);
                        JOptionPane.showMessageDialog(PerfilForm.this, "Nombre actualizado correctamente.");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(PerfilForm.this, "Error al actualizar el nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Mostrar el marco
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new PerfilForm();
    }
}
