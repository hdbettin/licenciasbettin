/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;

/**
 *
 * @author Estudiante
 */
public class LicenciaTransaccionesLimitadas extends Licencia {
    private static int numero_transacciones_permitidas;
    private static int transacciones_restantes;

    public LicenciaTransaccionesLimitadas(String email, int numero_transacciones, String cadena) {
        super(email, cadena);
        this.numero_transacciones_permitidas = numero_transacciones;
        this.transacciones_restantes = numero_transacciones;
    }
    
    protected Transaccion obtener_autorizacion(){
        if(this.getTransacciones_restantes() > 0){
            this.setTransacciones_restantes(this.getTransacciones_restantes()-1);
            return new Transaccion(this);
        }else{
            return null;
        }
    }

    public static int getNumero_transacciones_permitidas() {
        return numero_transacciones_permitidas;
    }

    public static void setNumero_transacciones_permitidas(int numero_transacciones_permitidas) {
        LicenciaTransaccionesLimitadas.numero_transacciones_permitidas = numero_transacciones_permitidas;
    }

    public static int getTransacciones_restantes() {
        return transacciones_restantes;
    }

    public static void setTransacciones_restantes(int transacciones_restantes) {
        LicenciaTransaccionesLimitadas.transacciones_restantes = transacciones_restantes;
    }
    
    protected int getLimite_dia(){
        return 1;
    }
    
    
    
    
}
