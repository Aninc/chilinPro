package forms;

import javax.swing.*;
import java.awt.*;

public class LoginForm {

    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace Login");
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
        JLabel subtitleLabel = new JLabel("LOGIN DE USUARIO");
        subtitleLabel.setBounds(85, 40, 160, 20); // Ajustado para estar más a la derecha
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(subtitleLabel);

        // Campo de usuario
        JTextField userField = new JTextField();
        userField.setBounds(50, 80, 200, 30);
        userField.setBackground(new Color(15, 17, 26)); // Fondo oscuro
        userField.setForeground(Color.WHITE); // Texto blanco
        userField.setCaretColor(Color.WHITE); // Color del cursor
        userField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(userField);

        // Etiqueta para el campo de usuario
        JLabel userLabel = new JLabel("USERNAME");
        userLabel.setBounds(50, 60, 100, 20);
        userLabel.setForeground(Color.LIGHT_GRAY);
        userLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(userLabel);

        // Campo de contraseña
        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 140, 200, 30);
        passField.setBackground(new Color(15, 17, 26)); // Fondo oscuro
        passField.setForeground(Color.WHITE); // Texto blanco
        passField.setCaretColor(Color.WHITE); // Color del cursor
        passField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(passField);

        // Etiqueta para el campo de contraseña
        JLabel passLabel = new JLabel("PASSWORD");
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
