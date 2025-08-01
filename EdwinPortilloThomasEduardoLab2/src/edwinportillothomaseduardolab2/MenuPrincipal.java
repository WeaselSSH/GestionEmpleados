package edwinportillothomaseduardolab2;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private Empresa empresa = new Empresa();

    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelNorte.setPreferredSize(new Dimension(0, 60));
        JLabel lblTitulo = new JLabel("MENÚ PRINCIPAL");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelNorte.add(lblTitulo);
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(null);
        panelCentro.setBackground(new Color(240, 240, 240));

        JButton btnRegistrarEmpleado = new JButton("Registrar Empleado");
        btnRegistrarEmpleado.setBounds(130, 20, 220, 35);
        panelCentro.add(btnRegistrarEmpleado);

        JButton btnRegistrarHoras = new JButton("Registrar Horas");
        btnRegistrarHoras.setBounds(130, 65, 220, 35);
        panelCentro.add(btnRegistrarHoras);

        JButton btnRegistrarVentas = new JButton("Registrar Ventas");
        btnRegistrarVentas.setBounds(130, 110, 220, 35);
        panelCentro.add(btnRegistrarVentas);

        JButton btnActualizarContrato = new JButton("Actualizar Contrato");
        btnActualizarContrato.setBounds(130, 155, 220, 35);
        panelCentro.add(btnActualizarContrato);

        JButton btnCalcularPago = new JButton("Calcular Pago");
        btnCalcularPago.setBounds(130, 200, 220, 35);
        panelCentro.add(btnCalcularPago);

        JButton btnVerReportes = new JButton("Ver Reportes");
        btnVerReportes.setBounds(130, 245, 220, 35);
        panelCentro.add(btnVerReportes);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        JPanel panelSur = new JPanel(null);
        panelSur.setPreferredSize(new Dimension(0, 60));

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(180, 10, 120, 30);
        btnSalir.addActionListener(e -> System.exit(0));
        panelSur.add(btnSalir);

        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);

        btnRegistrarHoras.addActionListener(e -> {
            FrmRegistrarHoras frm = new FrmRegistrarHoras(empresa);
            frm.setVisible(true);
        });

        btnRegistrarEmpleado.addActionListener(e -> {
            FrmRegistrarEmpleado frm = new FrmRegistrarEmpleado(empresa);
            frm.setVisible(true);
        });

        btnRegistrarVentas.addActionListener(e -> {
            FrmRegistrarVentas frm = new FrmRegistrarVentas(empresa);
            frm.setVisible(true);
        });

        btnActualizarContrato.addActionListener(e -> {
            FrmActualizarContrato frm = new FrmActualizarContrato(empresa);
            frm.setVisible(true);
        });

        btnCalcularPago.addActionListener(e -> {
            FrmCalcularPago frm = new FrmCalcularPago(empresa);
            frm.setVisible(true);
        });

        btnVerReportes.addActionListener(e -> {
            FrmVerReportes frm = new FrmVerReportes(empresa);
            frm.setVisible(true);
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}
