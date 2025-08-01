package edwinportillothomaseduardolab2;
import java.util.Calendar;

public class EmpleadoVentas extends EmpleadoEstandar {
    private Calendar fechaVencimiento;
    
    public EmpleadoVentas(int codigo, String nombre, double salarioBase) {
        super(codigo, nombre, salarioBase);
    }
    
    @Override
    public double calcularPago() {
        Calendar hoy = Calendar.getInstance();
        
        if(hoy.before(fechaVencimiento) || hoy.equals(fechaVencimiento)) {
            super.calcularPago();
        }
        return 0.0;
    }
    
    public void setFechaVencimiento(Calendar nuevaFecha) {
        fechaVencimiento = nuevaFecha;
    }
    
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "Fecha fin del contrato: " + fechaVencimiento.getTime();
    }
}
