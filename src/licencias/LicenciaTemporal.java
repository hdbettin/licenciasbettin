/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;
import java.time.LocalDate;
/**
 *
 * @author Estudiante
 */
public class LicenciaTemporal extends Licencia {
    
    private LocalDate fecha_caducidad;
    private boolean caducada = false;

    public LicenciaTemporal(String email, String cadena, LocalDate caducidad) {
        super(email, cadena);
        this.fecha_caducidad = caducidad;
        boolean caducada = false;
    }
    public LicenciaTemporal(String email, String cadena) {
        super(email, cadena);
        this.fecha_caducidad = LocalDate.now().plusMonths(3);
        boolean caducada = false;
    }

    public LocalDate getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(LocalDate fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    
    protected Transaccion obtener_autorizacion(){
        if(caducada){
            return new Transaccion(this);
        }else{
            return null;
        }
    }
    public void extender_fecha(int meses){
        this.setFecha_caducidad(this.getFecha_caducidad().plusMonths(meses));
    }
    
    protected int getLimite_dia(){
        return 1;
    }

    
    
    
    
}