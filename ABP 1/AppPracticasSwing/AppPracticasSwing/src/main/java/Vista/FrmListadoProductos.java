package Vista;

import app.AppPracticasSwing;
import java.awt.*;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class FrmListadoProductos extends javax.swing.JFrame {

    public FrmListadoProductos() {
        initComponents();
        cargarProductos();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPaneMain = new javax.swing.JScrollPane();
        panelClientes = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de Productos Registrados");
        setSize(700, 500);
        setLocationRelativeTo(null);

        panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.Y_AXIS));
        jScrollPaneMain.setViewportView(panelClientes);

        jLabel1.setText("Buscar cliente:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarClientes();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

   
    private void cargarProductos() {
        panelClientes.removeAll();

        // Mapa para agrupar productos por cliente
        Map<String, List<String[]>> productosPorCliente = new LinkedHashMap<>();

        for (String registro : AppPracticasSwing.productos) {
            String[] partes = registro.split(" - ", 3);
            if (partes.length == 3) {
                String cliente = partes[0];
                String producto = partes[1];
                String precio = partes[2];
                productosPorCliente.computeIfAbsent(cliente, k -> new ArrayList<>())
                        .add(new String[]{producto, precio});
            }
        }

        
        for (String cliente : productosPorCliente.keySet()) {
            JLabel lblCliente = new JLabel("Cliente: " + cliente);
            lblCliente.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblCliente.setForeground(new Color(0, 102, 204));

            DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Producto", "Precio"}, 0);
            double total = 0.0;

            for (String[] datos : productosPorCliente.get(cliente)) {
                modelo.addRow(new Object[]{datos[0], datos[1]});
                try {
                    total += Double.parseDouble(datos[1].replace("$", "").replace(",", "."));
                } catch (Exception e) {}
            }

            JTable tabla = new JTable(modelo);
            tabla.setEnabled(false);
            tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            tabla.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);

            JScrollPane scrollTabla = new JScrollPane(tabla);
            scrollTabla.setPreferredSize(new Dimension(550, productosPorCliente.get(cliente).size() * 20 + 40));

            JLabel lblTotal = new JLabel("Total: $" + String.format("%.2f", total));
            lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
            lblTotal.setForeground(new Color(0, 128, 0));

            
            JPanel panelCliente = new JPanel();
            panelCliente.setLayout(new BoxLayout(panelCliente, BoxLayout.Y_AXIS));
            panelCliente.setBorder(BorderFactory.createTitledBorder(""));
            panelCliente.add(lblCliente);
            panelCliente.add(scrollTabla);
            panelCliente.add(lblTotal);

            panelClientes.add(panelCliente);
            panelClientes.add(Box.createVerticalStrut(10)); // espacio entre bloques
        }

        panelClientes.revalidate();
        panelClientes.repaint();
    }

    
    private void filtrarClientes() {
        String filtro = txtBuscar.getText().trim().toLowerCase();
        panelClientes.removeAll();

        if (filtro.isEmpty()) {
            cargarProductos();
            return;
        }

       
        Map<String, List<String[]>> productosPorCliente = new LinkedHashMap<>();

        for (String registro : AppPracticasSwing.productos) {
            String[] partes = registro.split(" - ", 3);
            if (partes.length == 3) {
                String cliente = partes[0];
                String producto = partes[1];
                String precio = partes[2];
                if (cliente.toLowerCase().contains(filtro) || producto.toLowerCase().contains(filtro)) {
                    productosPorCliente.computeIfAbsent(cliente, k -> new ArrayList<>())
                            .add(new String[]{producto, precio});
                }
            }
        }

        for (String cliente : productosPorCliente.keySet()) {
            JLabel lblCliente = new JLabel("Cliente: " + cliente);
            lblCliente.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblCliente.setForeground(new Color(0, 102, 204));

            DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Producto", "Precio"}, 0);
            double total = 0.0;

            for (String[] datos : productosPorCliente.get(cliente)) {
                modelo.addRow(new Object[]{datos[0], datos[1]});
                try {
                    total += Double.parseDouble(datos[1].replace("$", "").replace(",", "."));
                } catch (Exception e) {}
            }

            JTable tabla = new JTable(modelo);
            tabla.setEnabled(false);
            JScrollPane scrollTabla = new JScrollPane(tabla);

            JLabel lblTotal = new JLabel("Total: $" + String.format("%.2f", total));
            lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
            lblTotal.setForeground(new Color(0, 128, 0));

            JPanel panelCliente = new JPanel();
            panelCliente.setLayout(new BoxLayout(panelCliente, BoxLayout.Y_AXIS));
            panelCliente.setBorder(BorderFactory.createTitledBorder(""));
            panelCliente.add(lblCliente);
            panelCliente.add(scrollTabla);
            panelCliente.add(lblTotal);

            panelClientes.add(panelCliente);
            panelClientes.add(Box.createVerticalStrut(10));
        }

        panelClientes.revalidate();
        panelClientes.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmListadoProductos().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration
}
