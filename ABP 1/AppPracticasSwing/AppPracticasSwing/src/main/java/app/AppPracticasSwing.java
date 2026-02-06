/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import Vista.FrmPrincipal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ernesto Robles
 */
public class AppPracticasSwing {

    
    public static ArrayList<String> clientes = new ArrayList<>();
    public static List<String> productos = new ArrayList<>();

    public static void main(String[] args) {
        FrmPrincipal frmprincipal = new FrmPrincipal();
        frmprincipal.setVisible(true);
    }
}
