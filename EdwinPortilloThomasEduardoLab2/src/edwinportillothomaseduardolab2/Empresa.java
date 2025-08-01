package edwinportillothomaseduardolab2;
import java.util.ArrayList;
import java.util.Calendar;

public class Empresa {
    private ArrayList<EmpleadoEstandar> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public boolean registrarEmpleado(EmpleadoEstandar empleado) {
        if (buscarEmpleado(empleado.codigo) != null) {
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    public boolean registrarHoras(int codigo, double horas) {
        EmpleadoEstandar emp = buscarEmpleado(codigo);
        if (emp != null) {
            emp.setHorasTrabajadas(horas);
            return true;
        }
        return false;
    }

    public boolean registrarVenta(int codigo, double monto) {
        EmpleadoEstandar emp = buscarEmpleado(codigo);
        if (emp instanceof EmpleadoVentas) {
            ((EmpleadoVentas) emp).registrarVenta(monto);
            return true;
        }
        return false;
    }

    public boolean actualizarFechaVencimiento(int codigo, Calendar nuevaFecha) {
        EmpleadoEstandar emp = buscarEmpleado(codigo);
        if (emp instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) emp).setFechaVencimiento(nuevaFecha);
            return true;
        }
        return false;
    }

    public double calcularPago(int codigo) {
        EmpleadoEstandar emp = buscarEmpleado(codigo);
        if (emp != null) {
            return emp.calcularPago();
        }
        return -1;
    }

    public EmpleadoEstandar buscarEmpleado(int codigo) {
        for (EmpleadoEstandar emp : empleados) {
            if (emp.codigo == codigo) {
                return emp;
            }
        }
        return null;
    }

    public String generarReporte() {
        String reporte = "";
        int estandar = 0, temporal = 0, ventas = 0;

        for (EmpleadoEstandar emp : empleados) {
            if (emp instanceof EmpleadoTemporal) {
                reporte += "TEMPORAL: " + emp.mostrarInformacion() + "\n";
                temporal++;
            } else if (emp instanceof EmpleadoVentas) {
                reporte += "VENTAS: " + emp.mostrarInformacion() + "\n";
                ventas++;
            } else {
                reporte += "ESTANDAR: " + emp.mostrarInformacion() + "\n";
                estandar++;
            }
        }

        reporte += "\nTotal empleados estándar: " + estandar;
        reporte += "\nTotal empleados temporales: " + temporal;
        reporte += "\nTotal empleados de ventas: " + ventas;

        return reporte;
    }
}
