package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeriesForm extends JFrame {

    public SeriesForm() {
        // Configuración del marco
        setTitle("VHS Palace - Series");
        setSize(1280, 720); // Tamaño ajustado a 1280x720
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(SeriesForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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
        JLabel sectionTitle = new JLabel("Catálogo de Series");
        sectionTitle.setBounds(50, 80, 400, 40);
        sectionTitle.setForeground(new Color(59, 215, 245)); // Color cian/neón
        sectionTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(sectionTitle);

        // Panel de contenido de series
        JPanel seriesPanel = new JPanel();
        seriesPanel.setBounds(50, 150, 1180, 450); // Ajustar tamaño del panel para más espacio
        seriesPanel.setBackground(new Color(24, 32, 46));
        seriesPanel.setLayout(new GridLayout(2, 4, 20, 20)); // Grid de 2 filas y 4 columnas con más espacio
        add(seriesPanel);

        // Agregar botones de series con las imágenes
        String[] imagePaths = {"ben.jpg", "breaking bad.jpg", "btc.jpg", "mr_robot.jpg", "sopranos.jpg", "south_park.jpg"};
        String[] seriesTitles = {"Ben 10", "Breaking Bad", "Better Call Saul", "Mr Robot", "The Sopranos", "South Park"};

        for (int i = 0; i < imagePaths.length; i++) {
            final int index = i; // Declarar una variable final o efectivamente final para usar dentro del ActionListener
            JButton seriesButton = new JButton(new ImageIcon(SeriesForm.class.getResource("/media/" + imagePaths[i]))); // Añadir imagen desde el paquete "media"
            seriesButton.setText(seriesTitles[i]);
            seriesButton.setHorizontalTextPosition(SwingConstants.CENTER);
            seriesButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            seriesButton.setBackground(new Color(15, 17, 26));
            seriesButton.setForeground(Color.WHITE);
            seriesButton.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Tamaño de fuente reducido
            seriesButton.setPreferredSize(new Dimension(250, 140)); // Tamaño más pequeño
            seriesButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            seriesButton.setFocusPainted(false);
            seriesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(SeriesForm.this, "Información de " + seriesTitles[index]);
                }
            });
            seriesPanel.add(seriesButton);
        }

        // Mostrar el marco
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new SeriesForm();
    }
}
