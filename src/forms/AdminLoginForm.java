package forms;

import javax.swing.*;
import java.awt.*;

public class AdminLoginForm {

    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace - Login de Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon("path/to/logo.png")); // Reemplaza con la ruta de tu logo
        logoLabel.setBounds(30, 20, 100, 100);
        frame.add(logoLabel);

        // Panel para el formulario
        JPanel panel = new JPanel();
        panel.setSize(300, 300); // Tamaño del panel
        panel.setBackground(new Color(24, 32, 46)); // Fondo del panel
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206), 2)); // Borde rosa/neón

        // Calcular la posición para centrar el panel
        int panelX = (frame.getWidth() - panel.getWidth()) / 2;
        int panelY = (frame.getHeight() - panel.getHeight()) / 2;
        panel.setBounds(panelX, panelY, panel.getWidth(), panel.getHeight());
        frame.add(panel);

        // Título VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(85, 10, 160, 30); // Ajustado para estar más a la derecha
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        panel.add(titleLabel);

        // Subtítulo
        JLabel subtitleLabel = new JLabel("LOGIN DE ADMINISTRADOR");
        subtitleLabel.setBounds(70, 45, 200, 20); // Reducir gap superior // Centrando y agregando gap arriba y abajo // Ajustado para estar centrado
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(subtitleLabel);

        // Campo de correo/usuario
        JTextField emailField = new JTextField();
        emailField.setBounds(50, 80, 200, 30);
        emailField.setBackground(new Color(15, 17, 26)); // Fondo oscuro
        emailField.setForeground(Color.WHITE); // Texto blanco
        emailField.setCaretColor(Color.WHITE); // Color del cursor
        emailField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(emailField);

        // Etiqueta para el campo de correo/usuario
        JLabel emailLabel = new JLabel("EMAIL/USUARIO");
        emailLabel.setBounds(50, 75, 150, 20); // Aumentar gap inferior
        emailLabel.setForeground(Color.LIGHT_GRAY);
        emailLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(emailLabel);

        // Campo de contraseña
        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 140, 200, 30);
        passField.setBackground(new Color(15, 17, 26)); // Fondo oscuro
        passField.setForeground(Color.WHITE); // Texto blanco
        passField.setCaretColor(Color.WHITE); // Color del cursor
        passField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(passField);

        // Etiqueta para el campo de contraseña
        JLabel passLabel = new JLabel("CONTRASEÑA");
        passLabel.setBounds(50, 120, 100, 20);
        passLabel.setForeground(Color.LIGHT_GRAY);
        passLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(passLabel);

        // Botón de enviar
        JButton sendButton = new JButton("SEND");
        sendButton.setBounds(50, 200, 200, 30);
        sendButton.setBackground(new Color(222, 54, 206)); // Fondo rosa/neón
        sendButton.setForeground(Color.WHITE);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        panel.add(sendButton);

        // Etiqueta de 'Forgot password?'
        JLabel forgotLabel = new JLabel("Forgot password?");
        forgotLabel.setBounds(90, 240, 120, 20);
        forgotLabel.setForeground(Color.LIGHT_GRAY);
        forgotLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(forgotLabel);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
