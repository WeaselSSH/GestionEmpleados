package edwinportillothomaseduardolab2;
import java.util.*;

public class Empresa {
    private List<EmpleadoEstandar> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public boolean registrarEmpleado(EmpleadoEstandar empleado) {
        if (buscarEmpleado(empleado.codigo) != null) {
            return false; // Ya existe
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

    public Double calcularPago(int codigo) {
        EmpleadoEstandar emp = buscarEmpleado(codigo);
        if (emp != null) {
            return emp.calcularPago();
        }
        return null;
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
        StringBuilder reporte = new StringBuilder();
        int estandar = 0, temporal = 0, ventas = 0;

        for (EmpleadoEstandar emp : empleados) {
            if (emp instanceof EmpleadoTemporal) {
                reporte.append("TEMPORAL: ").append(emp.mostrarInformacion()).append("\n");
                temporal++;
            } else if (emp instanceof EmpleadoVentas) {
                reporte.append("VENTAS: ").append(emp.mostrarInformacion()).append("\n");
                ventas++;
            } else {
                reporte.append("ESTANDAR: ").append(emp.mostrarInformacion()).append("\n");
                estandar++;
            }
        }

        reporte.append("\nTotal empleados estándar: ").append(estandar)
               .append("\nTotal empleados temporales: ").append(temporal)
               .append("\nTotal empleados de ventas: ").append(ventas);

        return reporte.toString();
    }

    public List<EmpleadoEstandar> getEmpleados() {
        return empleados;
    }
}