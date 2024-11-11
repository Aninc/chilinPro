package forms;

import javax.swing.*;
import java.awt.*;

public class PagoForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Payment Method");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(PagoForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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

        // Panel de método de facturación
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBounds(50, 70, 1180, 550); // Ajustar tamaño del panel
        paymentPanel.setBackground(new Color(24, 32, 46));
        paymentPanel.setLayout(null);
        frame.add(paymentPanel);

        JLabel paymentLabel = new JLabel("Método de facturación");
        paymentLabel.setBounds(20, 10, 300, 30);
        paymentLabel.setForeground(Color.LIGHT_GRAY);
        paymentLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        paymentPanel.add(paymentLabel);

        // Sección de "Mis tarjetas"
        JLabel myCardsLabel = new JLabel("Mis tarjetas");
        myCardsLabel.setBounds(20, 50, 200, 20);
        myCardsLabel.setForeground(Color.LIGHT_GRAY);
        myCardsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        paymentPanel.add(myCardsLabel);

        JCheckBox cardCheckBox = new JCheckBox("Visa que termina en 1134");
        cardCheckBox.setBounds(20, 80, 300, 20);
        cardCheckBox.setBackground(new Color(24, 32, 46));
        cardCheckBox.setForeground(Color.LIGHT_GRAY);
        cardCheckBox.setFont(new Font("Monospaced", Font.PLAIN, 14));
        paymentPanel.add(cardCheckBox);

        JLabel cardDetailsLabel = new JLabel("Nombre completo del dueño        Vencimiento: 01/2030");
        cardDetailsLabel.setBounds(20, 110, 600, 20);
        cardDetailsLabel.setForeground(Color.LIGHT_GRAY);
        cardDetailsLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        paymentPanel.add(cardDetailsLabel);

        JButton useCardButton = new JButton("USAR TARJETA");
        useCardButton.setBounds(20, 140, 150, 30);
        useCardButton.setBackground(Color.BLACK);
        useCardButton.setForeground(Color.WHITE);
        useCardButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        useCardButton.setFocusPainted(false);
        useCardButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        paymentPanel.add(useCardButton);

        // Sección de "Añadir una tarjeta de crédito/débito"
        JLabel addCardLabel = new JLabel("Añade una tarjeta de crédito/débito");
        addCardLabel.setBounds(20, 190, 400, 20);
        addCardLabel.setForeground(Color.LIGHT_GRAY);
        addCardLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        paymentPanel.add(addCardLabel);

        JTextField addCardField = new JTextField("Añade una nueva tarjeta");
        addCardField.setBounds(20, 220, 400, 30);
        addCardField.setBackground(new Color(15, 17, 26));
        addCardField.setForeground(Color.LIGHT_GRAY);
        addCardField.setCaretColor(Color.WHITE);
        addCardField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        paymentPanel.add(addCardField);

        JButton addCardButton = new JButton("AÑADIR TARJETA");
        addCardButton.setBounds(20, 260, 150, 30);
        addCardButton.setBackground(new Color(24, 32, 46));
        addCardButton.setForeground(Color.WHITE);
        addCardButton.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206)));
        addCardButton.setFocusPainted(false);
        addCardButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        paymentPanel.add(addCardButton);

        // Botón de "Ingresar Domicilio" reposicionado
        JButton enterAddressButton = new JButton("INGRESAR DOMICILIO");
        enterAddressButton.setBounds(950, 480, 200, 30); // Moverlo al lado derecho
        enterAddressButton.setBackground(new Color(222, 54, 206));
        enterAddressButton.setForeground(Color.WHITE);
        enterAddressButton.setBorder(BorderFactory.createEmptyBorder());
        enterAddressButton.setFocusPainted(false);
        enterAddressButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        frame.add(enterAddressButton);

        // Panel de "Cupones" y "Pedido"
        JLabel couponsLabel = new JLabel("Cupones");
        couponsLabel.setBounds(450, 50, 200, 20);
        couponsLabel.setForeground(Color.LIGHT_GRAY);
        couponsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        paymentPanel.add(couponsLabel);

        JLabel couponDetails = new JLabel("\uD83C\uDF81 Envío gratis");
        couponDetails.setBounds(450, 80, 200, 20);
        couponDetails.setForeground(Color.LIGHT_GRAY);
        couponDetails.setFont(new Font("Monospaced", Font.PLAIN, 14));
        paymentPanel.add(couponDetails);

        JLabel orderLabel = new JLabel("Pedido");
        orderLabel.setBounds(450, 140, 200, 20);
        orderLabel.setForeground(Color.LIGHT_GRAY);
        orderLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        paymentPanel.add(orderLabel);

        JLabel orderImage = new JLabel(new ImageIcon(PagoForm.class.getResource("/media/product_image.jpg"))); // Ruta actualizada
        orderImage.setBounds(450, 170, 120, 180);
        orderImage.setBackground(new Color(15, 17, 26));
        orderImage.setOpaque(true);
        paymentPanel.add(orderImage);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
