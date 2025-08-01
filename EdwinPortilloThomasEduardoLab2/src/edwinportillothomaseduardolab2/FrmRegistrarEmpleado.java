package edwinportillothomaseduardolab2;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class FrmRegistrarEmpleado extends JFrame {

    private Empresa empresa;

    public FrmRegistrarEmpleado(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Registrar Empleado");
        setSize(500, 440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(null);

        JLabel lblTitulo = new JLabel("REGISTRO DE EMPLEADO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(120, 10, 300, 30);
        panel.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(40, 60, 150, 25);
        panel.add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(200, 60, 200, 25);
        panel.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 100, 150, 25);
        panel.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(200, 100, 200, 25);
        panel.add(txtNombre);

        JLabel lblSalario = new JLabel("Salario Base:");
        lblSalario.setBounds(40, 140, 150, 25);
        panel.add(lblSalario);

        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(200, 140, 200, 25);
        panel.add(txtSalario);

        JLabel lblFechaContratacion = new JLabel("Fecha Contratación:");
        lblFechaContratacion.setBounds(40, 180, 150, 25);
        panel.add(lblFechaContratacion);

        JDateChooser fechaContratacion = new JDateChooser();
        fechaContratacion.setBounds(200, 180, 200, 25);
        panel.add(fechaContratacion);

        JLabel lblTipo = new JLabel("Tipo de Empleado:");
        lblTipo.setBounds(40, 220, 150, 25);
        panel.add(lblTipo);

        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Estandar", "Temporal", "Ventas"});
        cmbTipo.setBounds(200, 220, 200, 25);
        panel.add(cmbTipo);

        JLabel lblFinContrato = new JLabel("Fin de Contrato:");
        lblFinContrato.setBounds(40, 260, 150, 25);
        panel.add(lblFinContrato);
        lblFinContrato.setVisible(false);

        JDateChooser fechaFinContrato = new JDateChooser();
        fechaFinContrato.setBounds(200, 260, 200, 25);
        panel.add(fechaFinContrato);
        fechaFinContrato.setVisible(false);

        JLabel lblComision = new JLabel("Tasa Comisión (%):");
        lblComision.setBounds(40, 260, 150, 25);
        panel.add(lblComision);
        lblComision.setVisible(false);

        JTextField txtComision = new JTextField();
        txtComision.setBounds(200, 260, 200, 25);
        panel.add(txtComision);
        txtComision.setVisible(false);

        cmbTipo.addActionListener(e -> {
            String tipo = (String) cmbTipo.getSelectedItem();
            boolean temporal = tipo.equals("Temporal");
            boolean ventas = tipo.equals("Ventas");

            lblFinContrato.setVisible(temporal);
            fechaFinContrato.setVisible(temporal);

            lblComision.setVisible(ventas);
            txtComision.setVisible(ventas);
        });

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 330, 120, 30);
        panel.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(250, 330, 120, 30);
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);

        btnRegistrar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String nombre = txtNombre.getText();
                double salario = Double.parseDouble(txtSalario.getText());

                if (fechaContratacion.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione una fecha de contratación.");
                    return;
                }
                Calendar fechaCont = Calendar.getInstance();
                fechaCont.setTime(fechaContratacion.getDate());

                String tipo = (String) cmbTipo.getSelectedItem();
                EmpleadoEstandar nuevo;

                switch (tipo) {
                    case "Temporal":
                        if (fechaFinContrato.getDate() == null) {
                            JOptionPane.showMessageDialog(this, "Seleccione la fecha fin de contrato.");
                            return;
                        }
                        Calendar fin = Calendar.getInstance();
                        fin.setTime(fechaFinContrato.getDate());
                        nuevo = new EmpleadoTemporal(codigo, nombre, salario, fechaCont, fin);
                        break;

                    case "Ventas":
                        double comision = Double.parseDouble(txtComision.getText());
                        nuevo = new EmpleadoVentas(codigo, nombre, salario, fechaCont, comision);
                        break;

                    default:
                        nuevo = new EmpleadoEstandar(codigo, nombre, salario, fechaCont);
                        break;
                }

                boolean ok = empresa.registrarEmpleado(nuevo);
                if (ok) {
                    JOptionPane.showMessageDialog(this, "Empleado registrado exitosamente.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: código duplicado.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en datos numéricos.");
            }
        });

        setContentPane(panel);
    }
}
