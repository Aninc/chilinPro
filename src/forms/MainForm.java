package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(MainForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        logoLabel.setBounds(30, 10, 80, 40); // Tamaño reducido del logo
        frame.add(logoLabel);

           // Panel para la barra de menú en la parte superior derecha
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(650, 10, 580, 40); // Posición ajustada para incluir todos los botones
        menuPanel.setBackground(new Color(24, 32, 46));
        menuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10)); // Espaciado entre botones
        frame.add(menuPanel);

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

        // Sección principal con imagen y botones de "Ver Ahora" e "Información"
        JPanel mainSection = new JPanel();
        mainSection.setSize(900, 200); // Ajustar tamaño
        mainSection.setBackground(new Color(24, 32, 46));
        mainSection.setLayout(null);

        // Calcular posición para centrar mainSection
        int mainSectionX = (frame.getWidth() - mainSection.getWidth()) / 2;
        int mainSectionY = 100; // Ajuste vertical
        mainSection.setBounds(mainSectionX, mainSectionY, mainSection.getWidth(), mainSection.getHeight());
        frame.add(mainSection);

        JLabel mainImage = new JLabel(new ImageIcon(MainForm.class.getResource("/media/spiderman.jpg"))); // Imagen de fondo grande
        mainImage.setBounds(0, 0, 900, 200);
        mainSection.add(mainImage);

        // Colocar botones sobre la imagen
        JButton watchButton = new JButton("VER AHORA");
        watchButton.setBounds(620, 130, 120, 30); // Ajustado para estar sobre la imagen
        watchButton.setBackground(new Color(222, 54, 206));
        watchButton.setForeground(Color.WHITE);
        watchButton.setBorder(BorderFactory.createEmptyBorder());
        watchButton.setFocusPainted(false);
        watchButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        mainImage.add(watchButton);

        JButton infoButton = new JButton("Información");
        infoButton.setBounds(750, 130, 120, 30); // Ajustado para estar sobre la imagen
        infoButton.setBackground(Color.LIGHT_GRAY);
        infoButton.setForeground(Color.BLACK);
        infoButton.setBorder(BorderFactory.createEmptyBorder());
        infoButton.setFocusPainted(false);
        infoButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        mainImage.add(infoButton);

        // Sección de "Nuestra selección de hoy para ti"
        JLabel selectionLabel = new JLabel("Nuestra selección de hoy para ti");
        selectionLabel.setBounds(mainSectionX, mainSectionY + 220, 300, 30); // Alineado con la sección principal
        selectionLabel.setForeground(Color.LIGHT_GRAY);
        selectionLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.add(selectionLabel);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setSize(900, 150); // Ajustar tamaño
        selectionPanel.setBackground(new Color(24, 32, 46));
        selectionPanel.setLayout(new GridLayout(1, 3, 10, 10));
        selectionPanel.setBounds(mainSectionX, mainSectionY + 260, selectionPanel.getWidth(), selectionPanel.getHeight());
        frame.add(selectionPanel);

        // Rutas de imágenes
        String[] imagePaths = {"regular_show.jpg", "sopranos.jpg", "bob_esponja.jpg"};

        for (int i = 0; i < 3; i++) {
            JButton contentButton = new JButton();
            contentButton.setBackground(new Color(15, 17, 26));
            contentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Agregar imagen al botón
            ImageIcon imageIcon = new ImageIcon(MainForm.class.getResource("/media/" + imagePaths[i]));
            contentButton.setIcon(imageIcon);

            contentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción al hacer clic: consulta a la BD
                    String url = "jdbc:mysql://localhost:3306/vhs_palace_db";
                    String user = "root"; // Ajusta según tu configuración
                    String password = "password"; // Ajusta según tu configuración

                    try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        String query = "SELECT title, description FROM content WHERE id = ?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setInt(1, 1); // Puedes cambiar el ID dinámicamente si lo deseas
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            String title = rs.getString("title");
                            String description = rs.getString("description");
                            JOptionPane.showMessageDialog(frame, "Título: " + title + "\nDescripción: " + description);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error al conectar con la base de datos.");
                    }
                }
            });
            selectionPanel.add(contentButton);
        }

        // Mostrar el marco
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Añadir esta línea para hacer visible el marco
    }
}
