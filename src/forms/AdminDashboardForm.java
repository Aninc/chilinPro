package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboardForm {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("VHS Palace - Panel de Administración");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720); // Tamaño ajustado a 1280x720
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Título de la página
        JLabel titleLabel = new JLabel("Panel de Administración");
        titleLabel.setBounds(450, 20, 400, 50);
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        frame.add(titleLabel);

        // Tabla de inventario (Placeholder)
        JTable inventoryTable = new JTable(new Object[][]{
                {"Película 1", "PG-13", 10},
                {"Película 2", "R", 5}
        }, new String[]{"Título", "Clasificación", "Cantidad"});
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        scrollPane.setBounds(50, 100, 800, 400);
        frame.add(scrollPane);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(900, 100, 300, 400);
        buttonPanel.setBackground(new Color(15, 17, 26));
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton addButton = new JButton("Agregar");
        JButton editButton = new JButton("Modificar");
        JButton deleteButton = new JButton("Eliminar");

        // Estilizar botones
        for (JButton button : new JButton[]{addButton, editButton, deleteButton}) {
            button.setBackground(new Color(24, 32, 46));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Monospaced", Font.BOLD, 16));
            button.setBorder(BorderFactory.createLineBorder(new Color(59, 215, 245)));
            button.setFocusPainted(false);
            buttonPanel.add(button);
        }

        frame.add(buttonPanel);

        // Acción para el botón "Agregar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addDialog = new JDialog(frame, "Agregar Película/Serie", true);
                addDialog.setSize(400, 300);
                addDialog.setLayout(null);
                addDialog.getContentPane().setBackground(new Color(24, 32, 46)); // Fondo oscuro
                addDialog.setLocationRelativeTo(frame);

                JLabel titleLabel = new JLabel("Título:");
                titleLabel.setBounds(30, 30, 100, 30);
                titleLabel.setForeground(Color.LIGHT_GRAY);
                titleLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                addDialog.add(titleLabel);

                JTextField titleField = new JTextField();
                titleField.setBounds(150, 30, 200, 30);
                titleField.setBackground(new Color(15, 17, 26));
                titleField.setForeground(Color.WHITE);
                titleField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                addDialog.add(titleField);

                JLabel classificationLabel = new JLabel("Clasificación:");
                classificationLabel.setBounds(30, 80, 100, 30);
                classificationLabel.setForeground(Color.LIGHT_GRAY);
                classificationLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                addDialog.add(classificationLabel);

                JTextField classificationField = new JTextField();
                classificationField.setBounds(150, 80, 200, 30);
                classificationField.setBackground(new Color(15, 17, 26));
                classificationField.setForeground(Color.WHITE);
                classificationField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                addDialog.add(classificationField);

                JLabel quantityLabel = new JLabel("Cantidad:");
                quantityLabel.setBounds(30, 130, 100, 30);
                quantityLabel.setForeground(Color.LIGHT_GRAY);
                quantityLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                addDialog.add(quantityLabel);

                JTextField quantityField = new JTextField();
                quantityField.setBounds(150, 130, 200, 30);
                quantityField.setBackground(new Color(15, 17, 26));
                quantityField.setForeground(Color.WHITE);
                quantityField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                addDialog.add(quantityField);

                JButton saveButton = new JButton("Guardar");
                saveButton.setBounds(150, 200, 100, 30);
                saveButton.setBackground(new Color(222, 54, 206));
                saveButton.setForeground(Color.WHITE);
                saveButton.setBorder(BorderFactory.createEmptyBorder());
                saveButton.setFocusPainted(false);
                saveButton.setFont(new Font("Monospaced", Font.BOLD, 14));
                addDialog.add(saveButton);

                addDialog.setVisible(true);
            }
        });

        // Acción para el botón "Modificar"
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog editDialog = new JDialog(frame, "Modificar Película/Serie", true);
                editDialog.setSize(400, 300);
                editDialog.setLayout(null);
                editDialog.getContentPane().setBackground(new Color(24, 32, 46)); // Fondo oscuro
                editDialog.setLocationRelativeTo(frame);

                JLabel titleLabel = new JLabel("Título:");
                titleLabel.setBounds(30, 30, 100, 30);
                titleLabel.setForeground(Color.LIGHT_GRAY);
                titleLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                editDialog.add(titleLabel);

                JTextField titleField = new JTextField();
                titleField.setBounds(150, 30, 200, 30);
                titleField.setBackground(new Color(15, 17, 26));
                titleField.setForeground(Color.WHITE);
                titleField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                editDialog.add(titleField);

                JLabel classificationLabel = new JLabel("Clasificación:");
                classificationLabel.setBounds(30, 80, 100, 30);
                classificationLabel.setForeground(Color.LIGHT_GRAY);
                classificationLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                editDialog.add(classificationLabel);

                JTextField classificationField = new JTextField();
                classificationField.setBounds(150, 80, 200, 30);
                classificationField.setBackground(new Color(15, 17, 26));
                classificationField.setForeground(Color.WHITE);
                classificationField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                editDialog.add(classificationField);

                JLabel quantityLabel = new JLabel("Cantidad:");
                quantityLabel.setBounds(30, 130, 100, 30);
                quantityLabel.setForeground(Color.LIGHT_GRAY);
                quantityLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
                editDialog.add(quantityLabel);

                JTextField quantityField = new JTextField();
                quantityField.setBounds(150, 130, 200, 30);
                quantityField.setBackground(new Color(15, 17, 26));
                quantityField.setForeground(Color.WHITE);
                quantityField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                editDialog.add(quantityField);

                JButton saveButton = new JButton("Guardar cambios");
                saveButton.setBounds(150, 200, 150, 30);
                saveButton.setBackground(new Color(222, 54, 206));
                saveButton.setForeground(Color.WHITE);
                saveButton.setBorder(BorderFactory.createEmptyBorder());
                saveButton.setFocusPainted(false);
                saveButton.setFont(new Font("Monospaced", Font.BOLD, 14));
                editDialog.add(saveButton);

                editDialog.setVisible(true);
            }
        });

        // Acción para el botón "Eliminar"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que deseas eliminar esta película/serie?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Código para eliminar la película/serie
                }
            }
        });

        frame.setVisible(true);
    }
}
