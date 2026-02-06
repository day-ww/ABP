package Vista;

import app.AppPracticasSwing;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmRegistroProducto extends javax.swing.JFrame {

    public FrmRegistroProducto() {
        initComponents();
        cargarClientes();
        cargarProductos();
        cargarLogo();
    }

    
    private void cargarLogo() {
        URL url = getClass().getResource("/logoRegistroProducto.png");
        if (url == null) {
            System.err.println("Error: no se pudo cargar la imagen");
        } else {
            jlogo.setIcon(new ImageIcon(url));
        }
    }

  
    private void cargarClientes() {
        cbCliente.removeAllItems();
        if (AppPracticasSwing.clientes.isEmpty()) {
            cbCliente.addItem("No hay clientes registrados");
            cbCliente.setEnabled(false);
        } else {
            cbCliente.setEnabled(true);
            for (String c : AppPracticasSwing.clientes) {
                cbCliente.addItem(c);
            }
        }
    }

    
    private void cargarProductos() {
        cbProducto.removeAllItems();
        cbProducto.addItem("Desinfectante Fabuloso Lavanda 1L - $2,39");
        cbProducto.addItem("Estrella Lavavajilla en Crema 450g - $1,99");
        cbProducto.addItem("Papel Higiénico Familia Pack 18 Rollos - $1,99");
        cbProducto.addItem("Ciclón Detergente en Polvo Floral 2kg - $6,58");
        cbProducto.addItem("Raid Repelente Insecticida 335g - $6,58");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbProducto = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        jlogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Producto por Cliente");
        setUndecorated(true);

        jLabel1.setText("Cliente:");

        jLabel2.setText("Producto:");

        btnRegistrar.setText("Registrar Compra");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCliente, 0, 220, Short.MAX_VALUE)
                    .addComponent(cbProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        String cliente = (String) cbCliente.getSelectedItem();
        String producto = (String) cbProducto.getSelectedItem();

        if (cliente == null || cliente.isEmpty() || cliente.equals("No hay clientes registrados")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente válido");
            return;
        }

        if (producto == null || producto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
            return;
        }

        
        AppPracticasSwing.productos.add(cliente + " - " + producto);

        JOptionPane.showMessageDialog(this, "Compra registrada correctamente");

        cbProducto.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmRegistroProducto().setVisible(true));
    }

    // Variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlogo;
}
