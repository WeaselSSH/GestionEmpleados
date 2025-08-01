package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class FrmVerReportes extends JFrame {

    private Empresa empresa;

    public FrmVerReportes(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Reporte de Empleados");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("REPORTE DE EMPLEADOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(85, 10, 250, 25);
        panel.add(lblTitulo);

        JTextArea txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        txtReporte.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBounds(75, 50, 250, 100);
        panel.add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(140, 170, 120, 30);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        txtReporte.setText(empresa.generarReporte());

        setContentPane(panel);
    }
}
