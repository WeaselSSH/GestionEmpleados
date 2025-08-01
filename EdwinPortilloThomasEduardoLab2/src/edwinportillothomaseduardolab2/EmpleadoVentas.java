package edwinportillothomaseduardolab2;

import java.util.Calendar;

public class EmpleadoVentas extends EmpleadoEstandar {

    private double ventasMensuales[];
    private double tasaComision;

    public EmpleadoVentas(int codigo, String nombre, double salarioBase, double tasaComision) {
        super(codigo, nombre, salarioBase);
        this.ventasMensuales = new double[12];
        this.tasaComision = tasaComision;
    }

    public void registrarVenta(double monto) {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        ventasMensuales[mesActual] += monto;
    }

    public double calcularComisionMesActual() {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        return ventasMensuales[mesActual] * tasaComision;
    }

    @Override
    public double calcularPago() {
        return super.calcularPago() + calcularComisionMesActual();
    }

    public double calcularVentasAnuales() {
        double total = 0;
        for (double venta : ventasMensuales) {
            total += venta;
        }
        return total;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " Ventas anuales: " + calcularVentasAnuales();
    }
}
