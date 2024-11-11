/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace - Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Título de la aplicación
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(490, 50, 300, 60);
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 48));
        frame.add(titleLabel);

        // Botón de Administrador
        JButton adminButton = new JButton("Administrador");
        adminButton.setBounds(440, 200, 400, 80);
        adminButton.setBackground(new Color(24, 32, 46)); // Fondo del botón
        adminButton.setForeground(Color.WHITE);
        adminButton.setBorder(BorderFactory.createLineBorder(new Color(222, 54, 206), 3)); // Borde rosa/neón
        adminButton.setFocusPainted(false);
        adminButton.setFont(new Font("Monospaced", Font.BOLD, 24));
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic: redirigir a la GUI de administrador
                JOptionPane.showMessageDialog(frame, "Redirigiendo a la interfaz de administrador...");
                // Aquí se debe abrir la GUI de administración
            }
        });
        frame.add(adminButton);

        // Botón de Usuario
        JButton userButton = new JButton("Usuario");
        userButton.setBounds(440, 350, 400, 80);
        userButton.setBackground(new Color(24, 32, 46)); // Fondo del botón
        userButton.setForeground(Color.WHITE);
        userButton.setBorder(BorderFactory.createLineBorder(new Color(59, 215, 245), 3)); // Borde cian/neón
        userButton.setFocusPainted(false);
        userButton.setFont(new Font("Monospaced", Font.BOLD, 24));
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic: redirigir a la GUI de usuario
                JOptionPane.showMessageDialog(frame, "Redirigiendo a la interfaz de usuario...");
                // Aquí se debe abrir la GUI de usuario
            }
        });
        frame.add(userButton);

        // Mostrar el marco
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }
}

