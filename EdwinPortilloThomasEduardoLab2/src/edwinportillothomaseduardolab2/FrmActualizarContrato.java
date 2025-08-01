package edwinportillothomaseduardolab2;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class FrmActualizarContrato extends JFrame {

    private Empresa empresa;

    public FrmActualizarContrato(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Actualizar Contrato");
        setSize(420, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("ACTUALIZAR CONTRATO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(90, 10, 300, 30);
        panel.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código Empleado:");
        lblCodigo.setBounds(40, 60, 150, 25);
        panel.add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 60, 170, 25);
        panel.add(txtCodigo);

        JLabel lblFecha = new JLabel("Nueva Fecha Fin:");
        lblFecha.setBounds(40, 100, 150, 25);
        panel.add(lblFecha);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(180, 100, 170, 25);
        panel.add(dateChooser);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(60, 150, 120, 30);
        panel.add(btnActualizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 150, 120, 30);
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);

        btnActualizar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                Date fecha = dateChooser.getDate();

                if (fecha == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
                    return;
                }

                Calendar nuevaFecha = Calendar.getInstance();
                nuevaFecha.setTime(fecha);

                boolean ok = empresa.actualizarFechaVencimiento(codigo, nuevaFecha);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Contrato actualizado correctamente.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: código no encontrado o no es un empleado temporal.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código inválido.");
            }
        });

        setContentPane(panel);
    }
}
