package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class FrmRegistrarVentas extends JFrame {

    private Empresa empresa;

    public FrmRegistrarVentas(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Registrar Ventas");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("REGISTRAR VENTAS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(100, 10, 250, 30);
        panel.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código Empleado:");
        lblCodigo.setBounds(40, 60, 150, 25);
        panel.add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 60, 150, 25);
        panel.add(txtCodigo);

        JLabel lblMonto = new JLabel("Monto de Venta:");
        lblMonto.setBounds(40, 100, 150, 25);
        panel.add(lblMonto);

        JTextField txtMonto = new JTextField();
        txtMonto.setBounds(180, 100, 150, 25);
        panel.add(txtMonto);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(60, 150, 120, 30);
        panel.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 150, 120, 30);
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);

        btnRegistrar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                double monto = Double.parseDouble(txtMonto.getText());

                boolean ok = empresa.registrarVenta(codigo, monto);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Venta registrada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: código no encontrado o no es un empleado de ventas.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: valores inválidos.");
            }
        });

        setContentPane(panel);
    }
}
