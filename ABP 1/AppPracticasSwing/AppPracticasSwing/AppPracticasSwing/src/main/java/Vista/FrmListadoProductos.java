package Vista;

import app.AppPracticasSwing;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmRegistroCliente extends javax.swing.JFrame {

    public FrmRegistroCliente() {
        initComponents();
        URL url = getClass().getResource("/logoRegistroCliente.png");
        if (url == null) {
            System.err.println("Error: no se pudo cargar la imagen");
        } else {
            jlogo.setIcon(new ImageIcon(url));
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jlogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 2, 14)); 
        jLabel1.setText("Ingrese el nombre del Cliente");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); 
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); 
        jLabel2.setText("Registrar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String nombre = txtNombre.getText().trim(); // eliminamos espacios al inicio y al final

        if (nombre.isEmpty()) { // validamos que no esté vacío
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de cliente", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus(); // enfoca el campo para que el usuario escriba
            return; // salimos sin registrar
        }

        AppPracticasSwing.clientes.add(nombre); // registramos el cliente
        JOptionPane.showMessageDialog(this, "Cliente registrado");

        txtNombre.setText(""); // limpiamos el campo
        txtNombre.requestFocus(); // volvemos a enfocar el campo para el siguiente registro
    }                                        

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // no se requiere acción adicional
    }                                         

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {                                   
        char caracter = evt.getKeyChar();
        if (!Character.isLetter(caracter) && caracter != ' ') {
            evt.consume();  
        }
    }                                  

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FrmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlogo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration                   
}
