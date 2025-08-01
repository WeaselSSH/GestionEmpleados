/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edwinportillothomaseduardolab2;
import java.util.*;
/**
 *
 * @author Mayra Bardales
 */

public class Empresa {
    private Map<Integer, EmpleadoEstandar> empleados;

    public Empresa() {
        empleados = new HashMap<>();
    }

    public boolean registrarEmpleado(EmpleadoEstandar empleado) {
        if (empleados.containsKey(empleado.codigo)) {
            return false; // Ya existe
        }
        empleados.put(empleado.codigo, empleado);
        return true;
    }

   
    public boolean registrarHoras(int codigo, double horas) {
        EmpleadoEstandar emp = empleados.get(codigo);
        if (emp != null) {
            emp.setHorasTrabajadas(horas);
            return true;
        }
        return false;
    }

   
    public boolean registrarVenta(int codigo, double monto) {
        EmpleadoEstandar emp = empleados.get(codigo);
        if (emp instanceof EmpleadoVentas) {
            ((EmpleadoVentas) emp).registrarVenta(monto);
            return true;
        }
        return false;
    }

    
    public boolean actualizarFechaVencimiento(int codigo, Calendar nuevaFecha) {
        EmpleadoEstandar emp = empleados.get(codigo);
        if (emp instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) emp).setFechaVencimiento(nuevaFecha);
            return true;
        }
        return false;
    }
    public Double calcularPago(int codigo) {
        EmpleadoEstandar emp = empleados.get(codigo);
        if (emp != null) {
            return emp.calcularPago();
        }
        return null;
    }

  
    public EmpleadoEstandar buscarEmpleado(int codigo) {
        return empleados.get(codigo);
    }

    
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        int estandar = 0, temporal = 0, ventas = 0;

        for (EmpleadoEstandar emp : empleados.values()) {
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

    public Collection<EmpleadoEstandar> getEmpleados() {
        return empleados.values();
    }
}