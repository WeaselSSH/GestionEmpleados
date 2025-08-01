package edwinportillothomaseduardolab2;

import java.util.Calendar;

public class EmpleadoTemporal extends EmpleadoEstandar {

    private Calendar fechaVencimiento;

    public EmpleadoTemporal(int codigo, String nombre, double salarioBase, Calendar fechaContratacion, Calendar fechaVencimiento) {
        super(codigo, nombre, salarioBase, fechaContratacion);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public double calcularPago() {
        Calendar hoy = Calendar.getInstance();

        if (hoy.before(fechaVencimiento) || hoy.equals(fechaVencimiento)) {
            super.calcularPago();
        }
        return 0.0;
    }

    public void setFechaVencimiento(Calendar nuevaFecha) {
        fechaVencimiento = nuevaFecha;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " Fecha fin del contrato: " + fechaVencimiento.getTime();
    }
}
