package forms;

import javax.swing.*;
import java.awt.*;

public class DireccionForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Address");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(DireccionForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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

        // Panel de dirección
        JPanel addressPanel = new JPanel();
        addressPanel.setBounds(50, 70, 900, 500); // Ajustar tamaño del panel
        addressPanel.setBackground(new Color(24, 32, 46));
        addressPanel.setLayout(null);
        frame.add(addressPanel);

        JLabel addressLabel = new JLabel("Domicilio");
        addressLabel.setBounds(20, 10, 200, 30);
        addressLabel.setForeground(Color.LIGHT_GRAY);
        addressLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        addressPanel.add(addressLabel);

        // Campos de dirección
        JLabel receiverLabel = new JLabel("¿Quién recibe?");
        receiverLabel.setBounds(20, 50, 150, 20);
        receiverLabel.setForeground(Color.LIGHT_GRAY);
        receiverLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        addressPanel.add(receiverLabel);

        JTextField receiverField = new JTextField();
        receiverField.setBounds(20, 70, 300, 30); // Ajustado a 300 de ancho
        receiverField.setBackground(new Color(15, 17, 26));
        receiverField.setForeground(Color.WHITE);
        receiverField.setCaretColor(Color.WHITE);
        receiverField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addressPanel.add(receiverField);

        // Botones de "Agregar dirección" y "Nueva dirección"
        JButton addAddressButton = new JButton("Agregar dirección");
        addAddressButton.setBounds(20, 120, 220, 30); // Ajustado a 220 de ancho
        addAddressButton.setBackground(Color.BLACK);
        addAddressButton.setForeground(Color.WHITE);
        addAddressButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        addAddressButton.setFocusPainted(false);
        addAddressButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        addressPanel.add(addAddressButton);

        JButton newAddressButton = new JButton("Nueva dirección");
        newAddressButton.setBounds(260, 120, 220, 30); // Ajustado a 220 de ancho
        newAddressButton.setBackground(new Color(24, 32, 46));
        newAddressButton.setForeground(Color.WHITE);
        newAddressButton.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206)));
        newAddressButton.setFocusPainted(false);
        newAddressButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        addressPanel.add(newAddressButton);

        // Otros campos de dirección
        String[] labels = {"Estado", "Ciudad", "Calle", "Código Postal", "Referencias", "Teléfono", "Pedido"};
        int yPosition = 170;
        for (String label : labels) {
            JLabel fieldLabel = new JLabel(label);
            fieldLabel.setBounds(20, yPosition, 150, 20);
            fieldLabel.setForeground(Color.LIGHT_GRAY);
            fieldLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
            addressPanel.add(fieldLabel);

            JTextField textField = new JTextField();
            textField.setBounds(20, yPosition + 20, 300, 30); // Ajustado a 300 de ancho
            textField.setBackground(new Color(15, 17, 26));
            textField.setForeground(Color.WHITE);
            textField.setCaretColor(Color.WHITE);
            textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            addressPanel.add(textField);

            yPosition += 60;
        }

        // Imagen del producto (placeholder)
        JLabel productImage = new JLabel(new ImageIcon(DireccionForm.class.getResource("/media/product_image.jpg"))); // Reemplaza con la ruta de tu imagen
        productImage.setBounds(650, 50, 200, 300); // Ajustado para el tamaño adecuado
        productImage.setBackground(new Color(15, 17, 26));
        productImage.setOpaque(true);
        addressPanel.add(productImage);

        // Botón de "Ingresar Domicilio" reposicionado fuera del formulario
        JButton submitButton = new JButton("INGRESAR DOMICILIO");
        submitButton.setBounds(1000, 300, 250, 40); // Ajustado y movido a la derecha del formulario
        submitButton.setBackground(new Color(222, 54, 206));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createEmptyBorder());
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        frame.add(submitButton);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
