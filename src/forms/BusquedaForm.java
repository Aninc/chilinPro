package forms;

import javax.swing.*;
import java.awt.*;

public class BusquedaForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(BusquedaForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        logoLabel.setBounds(30, 10, 120, 60);
        frame.add(logoLabel);

        // Panel para la barra de menú en la parte superior derecha
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(730, 10, 500, 40); // Posición ajustada para incluir todos los botones
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

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(390, 20, 300, 30); // Ajustar posición debajo de la barra de menú
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        frame.add(titleLabel);

        // Panel de búsqueda
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(50, 150, 1180, 550); // Ajustar tamaño del panel
        searchPanel.setBackground(new Color(24, 32, 46));
        searchPanel.setLayout(null);
        frame.add(searchPanel);

        JLabel searchTitleLabel = new JLabel("Encuentra tu contenido favorito");
        searchTitleLabel.setBounds(20, 10, 600, 30);
        searchTitleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        searchTitleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        searchPanel.add(searchTitleLabel);

        // Campo de búsqueda
        JTextField searchField = new JTextField("Busca peliculas, series, caricaturas, anime...");
        searchField.setBounds(20, 50, 900, 30); // Ampliar el ancho a 900
        searchField.setBackground(new Color(15, 17, 26));
        searchField.setForeground(Color.LIGHT_GRAY);
        searchField.setCaretColor(Color.WHITE);
        searchField.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206), 2));
        searchPanel.add(searchField);

        // Botón de búsqueda
        JButton searchButton = new JButton(new ImageIcon(BusquedaForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        searchButton.setBounds(940, 50, 120, 30);
        searchButton.setBackground(new Color(24, 32, 46));
        searchButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        searchButton.setFocusPainted(false);
        searchPanel.add(searchButton);

        // Resultados principales
        JLabel mainResultsLabel = new JLabel("RESULTADOS PRINCIPALES");
        mainResultsLabel.setBounds(20, 100, 300, 20);
        mainResultsLabel.setForeground(Color.LIGHT_GRAY);
        mainResultsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        searchPanel.add(mainResultsLabel);

        JPanel mainResultsPanel = new JPanel();
        mainResultsPanel.setBounds(20, 130, 1140, 150); // Ampliar el ancho a 1140
        mainResultsPanel.setBackground(new Color(24, 32, 46));
        mainResultsPanel.setLayout(new GridLayout(1, 3, 10, 0));
        searchPanel.add(mainResultsPanel);

        // Imágenes para los resultados principales
        String[] imagePathsMain = {"sopranos.jpg", "bob_esponja.jpg", "breaking bad.jpg"};
        for (String imagePath : imagePathsMain) {
            JButton contentButton = new JButton(new ImageIcon(BusquedaForm.class.getResource("/media/" + imagePath))); // Ruta actualizada
            contentButton.setBackground(new Color(15, 17, 26));
            contentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            mainResultsPanel.add(contentButton);
        }

        // Contenido relacionado
        JLabel relatedContentLabel = new JLabel("CONTENIDO RELACIONADO");
        relatedContentLabel.setBounds(20, 300, 300, 20);
        relatedContentLabel.setForeground(Color.LIGHT_GRAY);
        relatedContentLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        searchPanel.add(relatedContentLabel);

        JPanel relatedContentPanel = new JPanel();
        relatedContentPanel.setBounds(20, 330, 1140, 150); // Ampliar el ancho a 1140
        relatedContentPanel.setBackground(new Color(24, 32, 46));
        relatedContentPanel.setLayout(new GridLayout(1, 3, 10, 0));
        searchPanel.add(relatedContentPanel);

        // Imágenes para el contenido relacionado
        String[] imagePathsRelated = {"sopranos.jpg", "bob_esponja.jpg", "btc.jpg"};
        for (String imagePath : imagePathsRelated) {
            JButton contentButton = new JButton(new ImageIcon(BusquedaForm.class.getResource("/media/" + imagePath))); // Ruta actualizada
            contentButton.setBackground(new Color(15, 17, 26));
            contentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            relatedContentPanel.add(contentButton);
        }

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}