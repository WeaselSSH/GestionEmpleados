package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class FrmCalcularPago extends JFrame {

    private Empresa empresa;

    public FrmCalcularPago(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Calcular Pago");
        setSize(400, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("CALCULAR PAGO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(110, 10, 250, 30);
        panel.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código Empleado:");
        lblCodigo.setBounds(40, 60, 150, 25);
        panel.add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 60, 150, 25);
        panel.add(txtCodigo);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(60, 120, 120, 30);
        panel.add(btnCalcular);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 120, 120, 30);
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);

        btnCalcular.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                double pago = empresa.calcularPago(codigo);

                if (pago >= 0) {
                    JOptionPane.showMessageDialog(this, "Pago mensual: L. " + String.format("%.2f", pago));
                } else {
                    JOptionPane.showMessageDialog(this, "Error: código no encontrado.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
            }
        });

        setContentPane(panel);
    }
}
