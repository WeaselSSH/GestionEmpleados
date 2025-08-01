package edwinportillothomaseduardolab2;

public class EmpleadoVentas extends EmpleadoEstandar {
    private double ventasMensuales[];
    private double tasaComision;
    
     public EmpleadoVentas(int codigo, String nombre, double salarioBase, double tasaComision) {
        super(codigo, nombre, salarioBase);
        this.ventasMensuales = new double[12];
        this.tasaComision = tasaComision;
    }
     
     
}
