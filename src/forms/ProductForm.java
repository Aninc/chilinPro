package forms;

import javax.swing.*;
import java.awt.*;

public class ProductForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Product Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(ProductForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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
            menuButton.setFont(new Font("Monospaced", Font.BOLD, 14));
            menuPanel.add(menuButton);
        }

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(300, 10, 300, 40); // Mover el título a la izquierda
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        frame.add(titleLabel);

        // Panel de información del producto
        JPanel productPanel = new JPanel();
        productPanel.setBounds(50, 70, 800, 400); // Ajustar tamaño del panel
        productPanel.setBackground(new Color(24, 32, 46));
        productPanel.setLayout(null);
        frame.add(productPanel);

        JLabel infoLabel = new JLabel("Información del producto");
        infoLabel.setBounds(20, 10, 300, 30);
        infoLabel.setForeground(Color.LIGHT_GRAY);
        infoLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        productPanel.add(infoLabel);

        // Detalles del producto
        JLabel productDetails = new JLabel("<html><ul>\n<li><b>Artículo:</b> Un Show Más 4 temporadas pack</li>\n<li><b>Cantidad:</b> 1</li>\n<li><b>Precio:</b> 239$</li>\n<li><b>Estado:</b> Nuevo</li>\n</ul></html>");
        productDetails.setBounds(20, 50, 300, 120);
        productDetails.setForeground(Color.LIGHT_GRAY);
        productDetails.setFont(new Font("Monospaced", Font.PLAIN, 14));
        productPanel.add(productDetails);

        // Botón de "Añadir al Carrito"
        JButton addToCartButton = new JButton("AÑADIR AL CARRITO");
        addToCartButton.setBounds(20, 300, 220, 30); // Ajustado a 220 de ancho
        addToCartButton.setBackground(Color.BLACK);
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        addToCartButton.setFocusPainted(false);
        addToCartButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        productPanel.add(addToCartButton);

        // Botón de "Pedir Ahora"
        JButton orderNowButton = new JButton("PEDIR AHORA");
        orderNowButton.setBounds(260, 300, 220, 30); // Ajustado a 220 de ancho
        orderNowButton.setBackground(new Color(222, 54, 206));
        orderNowButton.setForeground(Color.WHITE);
        orderNowButton.setBorder(BorderFactory.createEmptyBorder());
        orderNowButton.setFocusPainted(false);
        orderNowButton.setFont(new Font("Monospaced", Font.BOLD, 12));
        productPanel.add(orderNowButton);

        // Imagen del producto (placeholder)
        JLabel productImage = new JLabel(new ImageIcon(ProductForm.class.getResource("/media/product_image.jpg"))); // Ruta actualizada
        productImage.setBounds(550, 10, 200, 300); // Ajustado para el tamaño adecuado
        productImage.setBackground(new Color(15, 17, 26));
        productImage.setOpaque(true);
        productPanel.add(productImage);

        // Panel de contenido similar
        JLabel similarContentLabel = new JLabel("Contenido físico similar");
        similarContentLabel.setBounds(50, 500, 300, 30);
        similarContentLabel.setForeground(Color.LIGHT_GRAY);
        similarContentLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.add(similarContentLabel);

        JPanel similarContentPanel = new JPanel();
        similarContentPanel.setBounds(50, 540, 1100, 120); // Ajustado a 1100 de ancho
        similarContentPanel.setBackground(new Color(24, 32, 46));
        similarContentPanel.setLayout(new GridLayout(1, 4, 10, 0));
        frame.add(similarContentPanel);

        for (int i = 0; i < 4; i++) {
            JButton contentButton = new JButton();
            contentButton.setBackground(new Color(15, 17, 26));
            contentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            similarContentPanel.add(contentButton);
        }

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
