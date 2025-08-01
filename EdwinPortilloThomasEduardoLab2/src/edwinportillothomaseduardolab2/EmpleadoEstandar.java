package edwinportillothomaseduardolab2;

import java.util.Calendar;

public class EmpleadoEstandar {

    protected int codigo;
    protected String nombre;
    protected Calendar fechaContratacion;
    protected double salarioBase;
    protected double horasTrabajadas;

    public EmpleadoEstandar(int codigo, String nombre, double salarioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = 0;
        fechaContratacion = Calendar.getInstance();
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas += horasTrabajadas;
    }

    public double calcularPago() {
        double salarioProporcional = (horasTrabajadas / 160.0) * salarioBase;
        return salarioProporcional * 0.965; // deducción del 3.5%
    }

    public String mostrarInformacion() {
        return "Código: " + codigo + "Nombre: " + nombre + "Fecha contratación: " + fechaContratacion.getTime();
    }

}
