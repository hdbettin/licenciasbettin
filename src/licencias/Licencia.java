/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Estudiante
 */
public abstract class Licencia {
    private static String email;
    private final LocalDate fecha = LocalDate.now();
    private String codigo;
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    private int numero_transacciones = this.transacciones.size();
    public boolean revocada = false;
    private static String servicio;

    public Licencia( String email, String cadena) {
        this.email = email;
        this.codigo = UUID.randomUUID().toString();
        this.servicio = cadena;
    }
    
    public void revocar(){
        this.revocada = true;
    }
    
    protected abstract Transaccion obtener_autorizacion();
    protected abstract int getLimite_dia();
    
    
}
