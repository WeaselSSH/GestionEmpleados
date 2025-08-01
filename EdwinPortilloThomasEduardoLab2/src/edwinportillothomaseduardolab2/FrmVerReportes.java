package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class FrmVerReportes extends JFrame {

    private Empresa empresa;

    public FrmVerReportes(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Reporte de Empleados");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("REPORTE DE EMPLEADOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(120, 10, 300, 30);
        panel.add(lblTitulo);

        JTextArea txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        txtReporte.setFont(new Font("ARIAL", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBounds(30, 50, 420, 250);
        panel.add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 320, 120, 30);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        txtReporte.setText(empresa.generarReporte());

        setContentPane(panel);
    }
}
