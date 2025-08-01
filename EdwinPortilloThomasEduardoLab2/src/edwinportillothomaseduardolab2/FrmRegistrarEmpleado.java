package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class FrmRegistrarEmpleado extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtSalarioBase;
    private JComboBox<String> cmbTipoEmpleado;
    private JTextField txtFechaContratacion;

    private JTextField txtFechaFinContrato;
    private JTextField txtComision;

    public FrmRegistrarEmpleado() {
        setTitle("Registrar Empleado");
        setSize(500, 420);
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

        txtCodigo = new JTextField();
        txtCodigo.setBounds(200, 60, 200, 25);
        panel.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 100, 150, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(200, 100, 200, 25);
        panel.add(txtNombre);

        JLabel lblSalario = new JLabel("Salario Base:");
        lblSalario.setBounds(40, 140, 150, 25);
        panel.add(lblSalario);

        txtSalarioBase = new JTextField();
        txtSalarioBase.setBounds(200, 140, 200, 25);
        panel.add(txtSalarioBase);

        JLabel lblFecha = new JLabel("Fecha Contratación (dd/mm/yyyy):");
        lblFecha.setBounds(40, 180, 200, 25);
        panel.add(lblFecha);

        txtFechaContratacion = new JTextField();
        txtFechaContratacion.setBounds(240, 180, 160, 25);
        panel.add(txtFechaContratacion);

        JLabel lblTipo = new JLabel("Tipo de Empleado:");
        lblTipo.setBounds(40, 220, 150, 25);
        panel.add(lblTipo);

        cmbTipoEmpleado = new JComboBox<>(new String[]{"Estandar", "Temporal", "Ventas"});
        cmbTipoEmpleado.setBounds(200, 220, 200, 25);
        panel.add(cmbTipoEmpleado);

        // Dinámico: Fin de contrato
        JLabel lblFinContrato = new JLabel("Fin Contrato (dd/mm/yyyy):");
        lblFinContrato.setBounds(40, 260, 180, 25);
        lblFinContrato.setVisible(false);
        panel.add(lblFinContrato);

        txtFechaFinContrato = new JTextField();
        txtFechaFinContrato.setBounds(240, 260, 160, 25);
        txtFechaFinContrato.setVisible(false);
        panel.add(txtFechaFinContrato);

        // Dinámico: Comisión
        JLabel lblComision = new JLabel("Tasa Comisión (%):");
        lblComision.setBounds(40, 260, 150, 25);
        lblComision.setVisible(false);
        panel.add(lblComision);

        txtComision = new JTextField();
        txtComision.setBounds(200, 260, 200, 25);
        txtComision.setVisible(false);
        panel.add(txtComision);

        cmbTipoEmpleado.addActionListener(e -> {
            String tipo = (String) cmbTipoEmpleado.getSelectedItem();

            boolean esTemporal = tipo.equals("Temporal");
            boolean esVentas = tipo.equals("Ventas");

            lblFinContrato.setVisible(esTemporal);
            txtFechaFinContrato.setVisible(esTemporal);

            lblComision.setVisible(esVentas);
            txtComision.setVisible(esVentas);
        });

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 310, 120, 35);
        panel.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(260, 310, 120, 35);
        btnCancelar.addActionListener(e -> dispose());
        panel.add(btnCancelar);

        setContentPane(panel);
    }
}
