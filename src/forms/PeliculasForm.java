package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeliculasForm extends JFrame {

    public PeliculasForm() {
        // Configuración del marco
        setTitle("VHS Palace - Películas");
        setSize(1280, 720); // Tamaño ajustado a 1280x720
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(PeliculasForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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
        JLabel sectionTitle = new JLabel("Catálogo de Películas");
        sectionTitle.setBounds(50, 80, 400, 40);
        sectionTitle.setForeground(new Color(59, 215, 245)); // Color cian/neón
        sectionTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(sectionTitle);

        // Panel de contenido de películas
        JPanel moviesPanel = new JPanel();
        moviesPanel.setBounds(50, 150, 1180, 450); // Ajustar tamaño del panel para más espacio
        moviesPanel.setBackground(new Color(24, 32, 46));
        moviesPanel.setLayout(new GridLayout(2, 4, 20, 20)); // Grid de 2 filas y 4 columnas con más espacio
        add(moviesPanel);

        // Agregar botones de películas con las imágenes
        String[] imagePaths = {"batman.jpg", "increibles.jpg", "padrino.jpg", "pulp.jpg", "star_wars.jpg", "taxi.jpg"};
        String[] movieTitles = {"Batman", "Los Increíbles", "El Padrino", "Pulp Fiction", "Star Wars", "Taxi Driver"};

        for (int i = 0; i < imagePaths.length; i++) {
            final int index = i; // Declarar una variable final o efectivamente final para usar dentro del ActionListener
            JButton movieButton = new JButton(new ImageIcon(PeliculasForm.class.getResource("/media/" + imagePaths[i]))); // Añadir imagen desde el paquete "media"
            movieButton.setText(movieTitles[i]);
            movieButton.setHorizontalTextPosition(SwingConstants.CENTER);
            movieButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            movieButton.setBackground(new Color(15, 17, 26));
            movieButton.setForeground(Color.WHITE);
            movieButton.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Tamaño de fuente reducido
            movieButton.setPreferredSize(new Dimension(250, 140)); // Tamaño más pequeño
            movieButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            movieButton.setFocusPainted(false);
            movieButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(PeliculasForm.this, "Información de " + movieTitles[index]);
                }
            });
            moviesPanel.add(movieButton);
        }

        // Mostrar el marco
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new PeliculasForm();
    }
}
