package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprasForm extends JFrame {

    public ComprasForm() {
        // Configuración del marco
        setTitle("VHS Palace - Compras");
        setSize(1280, 720); // Tamaño ajustado a 1280x720
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(15, 17, 26)); // Fondo oscuro

        // Logo (opcional, si tienes una imagen de logo)
        JLabel logoLabel = new JLabel(new ImageIcon(ComprasForm.class.getResource("/media/logo.png"))); // Ruta actualizada
        logoLabel.setBounds(30, 10, 80, 45); // Tamaño reducido del logo
        add(logoLabel);

        // Título de VHS PALACE
        JLabel titleLabel = new JLabel("VHS PALACE");
        titleLabel.setBounds(300, 10, 200, 40); // Posición a la derecha del logo
        titleLabel.setForeground(new Color(59, 215, 245)); // Color cian/neón
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(titleLabel);

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
            
            // Agregar ActionListener para cada botón (personaliza según lo que necesites)
            menuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(ComprasForm.this, "Botón '" + item + "' presionado.");
                }
            });

            menuPanel.add(menuButton);
        }

        // Título de la sección
        JLabel sectionTitle = new JLabel("Historial de Compras");
        sectionTitle.setBounds(50, 80, 400, 40);
        sectionTitle.setForeground(new Color(59, 215, 245)); // Color cian/neón
        sectionTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        add(sectionTitle);

        // Panel de tabla
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(50, 150, 1180, 450); // Ajustar tamaño del panel
        tablePanel.setBackground(new Color(24, 32, 46));
        tablePanel.setLayout(new BorderLayout());
        add(tablePanel);

        // Tabla con datos estáticos
        String[] columnNames = {"Título", "Fecha de Compra", "Precio", "Estado"};
        Object[][] data = {
            {"Star Wars", "01/11/2024", "$15.00", "Entregado"},
            {"Batman", "03/11/2024", "$12.00", "En proceso"},
            {"Los Increíbles", "05/11/2024", "$10.00", "Entregado"},
            {"Pulp Fiction", "07/11/2024", "$14.00", "Pendiente"}
        };

        JTable purchasesTable = new JTable(data, columnNames);
        purchasesTable.setBackground(new Color(15, 17, 26));
        purchasesTable.setForeground(Color.WHITE);
        purchasesTable.setFont(new Font("Monospaced", Font.PLAIN, 12));
        purchasesTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(purchasesTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Botón de detalles
        JButton detailsButton = new JButton("Ver Detalles");
        detailsButton.setBounds(50, 620, 150, 30);
        detailsButton.setBackground(new Color(222, 54, 206));
        detailsButton.setForeground(Color.WHITE);
        detailsButton.setBorder(BorderFactory.createEmptyBorder());
        detailsButton.setFocusPainted(false);
        detailsButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        add(detailsButton);

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = purchasesTable.getSelectedRow();
                if (selectedRow != -1) {
                    String title = (String) purchasesTable.getValueAt(selectedRow, 0);
                    String date = (String) purchasesTable.getValueAt(selectedRow, 1);
                    String price = (String) purchasesTable.getValueAt(selectedRow, 2);
                    String status = (String) purchasesTable.getValueAt(selectedRow, 3);

                    JOptionPane.showMessageDialog(ComprasForm.this, "Detalles de Compra:\n" +
                            "Título: " + title + "\n" +
                            "Fecha de Compra: " + date + "\n" +
                            "Precio: " + price + "\n" +
                            "Estado: " + status);
                } else {
                    JOptionPane.showMessageDialog(ComprasForm.this, "Por favor, selecciona una fila.");
                }
            }
        });

        // Mostrar el marco
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComprasForm();
    }
}
