package forms;

import javax.swing.*;
import java.awt.*;

public class PreguntasForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace FAQ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(PreguntasForm.class.getResource("/media/logo.png"))); // Ruta actualizada
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

        // Título de la página
        JLabel pageTitleLabel = new JLabel("Buzón de Quejas y Preguntas Frecuentes");
        pageTitleLabel.setBounds(290, 60, 700, 40); // Centrar el título
        pageTitleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        pageTitleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        frame.add(pageTitleLabel);

        JLabel subtitleLabel = new JLabel("¿Tienes alguna pregunta o necesitas ayuda? Estamos aquí para asistirte.");
        subtitleLabel.setBounds(290, 100, 700, 20); // Centrar el subtítulo
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        frame.add(subtitleLabel);

        // Panel de preguntas
        JPanel faqPanel = new JPanel();
        faqPanel.setBounds(290, 140, 700, 300); // Centrar el panel de preguntas
        faqPanel.setBackground(new Color(24, 32, 46));
        faqPanel.setLayout(new GridLayout(5, 1, 10, 10));
        frame.add(faqPanel);

        String[] questions = {
            "¿Cómo puedo restablecer mi contraseña?",
            "¿Cómo cancelo mi suscripción?",
            "¿Dónde puedo encontrar nuevas series y películas?",
            "He encontrado un problema técnico, ¿qué hago?",
            "Tengo una queja, ¿cómo la puedo enviar?"
        };

        for (String question : questions) {
            JButton questionButton = new JButton(question);
            questionButton.setBackground(new Color(15, 17, 26));
            questionButton.setForeground(Color.LIGHT_GRAY);
            questionButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
            questionButton.setHorizontalAlignment(SwingConstants.LEFT);
            questionButton.setBorder(BorderFactory.createLineBorder(new Color(59, 215, 245)));
            questionButton.setFocusPainted(false);
            faqPanel.add(questionButton);
        }

        // Área de texto para escribir un mensaje
        JTextArea messageArea = new JTextArea("Escribe tu mensaje");
        messageArea.setBounds(290, 460, 700, 100); // Centrar el área de texto
        messageArea.setBackground(new Color(15, 17, 26));
        messageArea.setForeground(Color.LIGHT_GRAY);
        messageArea.setCaretColor(Color.WHITE);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        messageArea.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206)));
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        frame.add(messageArea);

        // Botón de enviar
        JButton sendButton = new JButton("ENVIAR");
        sendButton.setBounds(500, 580, 200, 40); // Centrar el botón de enviar
        sendButton.setBackground(new Color(222, 54, 206));
        sendButton.setForeground(Color.WHITE);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.add(sendButton);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}
