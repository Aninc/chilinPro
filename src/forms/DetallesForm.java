package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetallesForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(DetallesForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        logoLabel.setBounds(30, 10, 80, 45); // Tamaño reducido del logo
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

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(300, 10, 300, 40); // Mover el título a la izquierda
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        frame.add(titleLabel);

        // Panel de detalles
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBounds(50, 70, 1180, 600); // Ajustar tamaño del panel
        detailsPanel.setBackground(new Color(24, 32, 46));
        detailsPanel.setLayout(null);
        frame.add(detailsPanel);

        // Imagen de la serie
        JLabel seriesImage = new JLabel(new ImageIcon(DetallesForm.class.getResource("/media/regular_show.jpg"))); // Ruta actualizada
        seriesImage.setBounds(20, 20, 500, 300); // Ampliar el tamaño de la imagen
        seriesImage.setBackground(new Color(15, 17, 26));
        seriesImage.setOpaque(true);
        detailsPanel.add(seriesImage);

        // Título de la serie
        JLabel seriesTitle = new JLabel("Un Show Más");
        seriesTitle.setBounds(550, 20, 400, 30);
        seriesTitle.setForeground(Color.LIGHT_GRAY);
        seriesTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
        detailsPanel.add(seriesTitle);

        // Sinopsis
        JTextArea synopsisArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        synopsisArea.setBounds(550, 60, 600, 100);
        synopsisArea.setLineWrap(true);
        synopsisArea.setWrapStyleWord(true);
        synopsisArea.setEditable(false);
        synopsisArea.setBackground(new Color(24, 32, 46));
        synopsisArea.setForeground(Color.LIGHT_GRAY);
        synopsisArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        detailsPanel.add(synopsisArea);

        // Información adicional
        String[] infoLabels = {"Temporadas: 4", "Clasificación: TV-PG", "Envío: Sí", "Recoger en tienda: Sí"};
        int xPosition = 550;
        int yPosition = 170;
        for (String info : infoLabels) {
            JLabel infoLabel = new JLabel(info);
            infoLabel.setBounds(xPosition, yPosition, 200, 20);
            infoLabel.setForeground(Color.LIGHT_GRAY);
            infoLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
            detailsPanel.add(infoLabel);
            yPosition += 30;
        }

        // Elenco principal
        JLabel castLabel = new JLabel("Elenco principal");
        castLabel.setBounds(550, 290, 200, 20);
        castLabel.setForeground(Color.LIGHT_GRAY);
        castLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        detailsPanel.add(castLabel);

        JLabel castDetails = new JLabel("J.G. Quintel        William Salyers<br>Sam Marin          Mark Hamill");
        castDetails.setBounds(550, 320, 600, 40);
        castDetails.setForeground(Color.LIGHT_GRAY);
        castDetails.setFont(new Font("Monospaced", Font.PLAIN, 14));
        detailsPanel.add(castDetails);

        // Botones de "Ver Ahora" y "Comprar ahora"
        JButton watchButton = new JButton("VER AHORA");
        watchButton.setBounds(550, 380, 150, 30);
        watchButton.setBackground(new Color(222, 54, 206));
        watchButton.setForeground(Color.WHITE);
        watchButton.setBorder(BorderFactory.createEmptyBorder());
        watchButton.setFocusPainted(false);
        watchButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        detailsPanel.add(watchButton);

        JButton buyButton = new JButton("Comprar ahora");
        buyButton.setBounds(720, 380, 150, 30);
        buyButton.setBackground(Color.BLACK);
        buyButton.setForeground(Color.WHITE);
        buyButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        buyButton.setFocusPainted(false);
        buyButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        detailsPanel.add(buyButton);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
