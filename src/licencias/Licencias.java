/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Licencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LicenciaTemporal temporal = new LicenciaTemporal("juan@um.es", "http://api.um.es/disco/v1/", LocalDate.now().plusMonths(1));
        LicenciaTransaccionesLimitadas limitada = new LicenciaTransaccionesLimitadas("pepe@um.es", 3, "http://api.um.es/disco/v1/");
        Licencia_limite_diario limite = new Licencia_limite_diario(4, "paco@um.es", "http://api.um.es/disco/v1/");
        
        ArrayList<Licencia> licencias = new ArrayList<Licencia>();
        licencias.add(temporal);
        licencias.add(limitada);
        licencias.add(limite);
        System.out.println(temporal.getClass().getName());
        
        for(Licencia e : licencias){
            if(e.getClass().getName() == "licencias.Licencia_limite_diario"){
                System.out.println("las transacciones restantes son:" + e.getLimite_dia());
            }else if(e.getClass().getName() == "licencias.LicenciaTemporal"){
                System.out.println("revocada");
                e.revocar();
            }
        }
        
        for(Licencia e : licencias){
            for(int i = 0; i < 4; i++){
                if(e.obtener_autorizacion() != null){
                    System.out.println("transaccion");
                }else{
                    System.out.println("no autorizada");
                }
            }
        }
        
    }
    
}
