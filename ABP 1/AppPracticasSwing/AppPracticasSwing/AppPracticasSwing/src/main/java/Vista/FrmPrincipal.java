package Vista;

import javax.swing.*;
import java.awt.*;
import app.AppPracticasSwing;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        menuRegistroCliente = new javax.swing.JMenuItem();
        menuRegistroProducto = new javax.swing.JMenuItem();
        menuListadoProductos = new javax.swing.JMenuItem();
        menuProductosDescontinuados = new javax.swing.JMenuItem(); // 🔹 Nuevo menú
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Registro de Productos de Limpieza");

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));
        jLabel1.setText("Sistema de Registro de Productos de Limpieza");

        txtContexto.setEditable(false);
        txtContexto.setColumns(20);
        txtContexto.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        txtContexto.setLineWrap(true);
        txtContexto.setWrapStyleWord(true);
        txtContexto.setText(
            "Contexto del problema:\n" +
            "Actualmente, el registro de productos de limpieza se realiza de forma manual, " +
            "lo que genera pérdida de datos y errores. Esta aplicación digitaliza el proceso " +
            "para registrar, consultar y gestionar los productos de limpieza de manera " +
            "rápida, organizada y segura."
        );
        jScrollPane1.setViewportView(txtContexto);

        // --- MENÚ PRINCIPAL ---
        jMenuFile.setText("Menú Principal");

        menuRegistroCliente.setText("Registrar Cliente");
        menuRegistroCliente.addActionListener(evt -> {
            new FrmRegistroCliente().setVisible(true);
        });
        jMenuFile.add(menuRegistroCliente);

        menuRegistroProducto.setText("Registrar Producto");
        menuRegistroProducto.addActionListener(evt -> {
            new FrmRegistroProducto().setVisible(true);
        });
        jMenuFile.add(menuRegistroProducto);

        menuListadoProductos.setText("Listado de Productos");
        menuListadoProductos.addActionListener(evt -> {
            new FrmListadoProductos().setVisible(true);
        });
        jMenuFile.add(menuListadoProductos);

        // 🔹 NUEVO MENÚ: VER PRODUCTOS DESCONTINUADOS
        menuProductosDescontinuados.setText("Ver productos descontinuados");
        menuProductosDescontinuados.addActionListener(evt -> {
            new FrmProductosDescontinuados().setVisible(true);
        });
        jMenuFile.add(menuProductosDescontinuados);

        jMenuBar1.add(jMenuFile);

        jMenuSalir.setText("Salir");
        jMenuSalir.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {}
            public void menuCanceled(javax.swing.event.MenuEvent evt) {}
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        // --- DISEÑO ---
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }

    // Variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuRegistroCliente;
    private javax.swing.JMenuItem menuRegistroProducto;
    private javax.swing.JMenuItem menuListadoProductos;
    private javax.swing.JMenuItem menuProductosDescontinuados; // 🔹 Declarado aquí
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtContexto;
}
