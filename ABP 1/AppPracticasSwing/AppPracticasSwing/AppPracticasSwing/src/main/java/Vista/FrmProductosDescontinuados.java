package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class FrmProductosDescontinuados extends javax.swing.JFrame {

    private JTable tablaDescontinuados;
    private DefaultTableModel modelo;

    public FrmProductosDescontinuados() {
        initComponents();
        cargarProductosDescontinuados();
    }

    private void initComponents() {
        setTitle("Productos Descontinuados");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Lista de Productos Descontinuados");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(150, 0, 0));

        modelo = new DefaultTableModel(new Object[]{"Producto", "Motivo", "Último Precio"}, 0);
        tablaDescontinuados = new JTable(modelo);
        tablaDescontinuados.setEnabled(false);

        JScrollPane scroll = new JScrollPane(tablaDescontinuados);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnCerrar, BorderLayout.SOUTH);

        add(panel);
    }

    private void cargarProductosDescontinuados() {
        // 🔹 Lista simulada de productos descontinuados
        List<String[]> productos = new ArrayList<>();
        productos.add(new String[]{"Suavitel floral 2L", "Falta de stock permanente", "$3,80"});
        productos.add(new String[]{"Cloro CleanMax 1L", "Reemplazado por nueva fórmula", "$1,25"});
        productos.add(new String[]{"Limpiavidrios Brillax 500ml", "Baja demanda", "$2,10"});

        for (String[] p : productos) {
            modelo.addRow(p);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FrmProductosDescontinuados().setVisible(true));
    }
}
