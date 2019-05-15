/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Estudiante
 */
public class Licencia_limite_diario extends Licencia {
    private static int limite_dia;
    private HashMap<LocalDate, Integer> dias = new HashMap<LocalDate, Integer>();

    public Licencia_limite_diario(int limite_dia, String email, String cadena) {
        super(email, cadena);
        this.limite_dia = limite_dia;
    }
    
    public Map.Entry<LocalDate, Integer> obtener_transacciones_restantes(){
        Map.Entry<LocalDate, Integer> valor = null;
        for(Map.Entry<LocalDate, Integer> entrada : this.dias.entrySet()){
            if(entrada.getKey() == LocalDate.now()){
                valor = entrada;
            }
        }
        
        return valor;
    }
    
    public Map.Entry<LocalDate, Integer> obtener_transacciones_restantes(LocalDate fecha){
        Map.Entry<LocalDate, Integer> valor = null;
        for(Map.Entry<LocalDate, Integer> entrada : this.dias.entrySet()){
            if(entrada.getKey() == fecha){
                valor = entrada;
            }
        }
        
        return valor;
    }
    
    
    protected Transaccion obtener_autorizacion(){
        if(this.obtener_transacciones_restantes().getValue() < this.limite_dia){
            this.obtener_transacciones_restantes().setValue(this.obtener_transacciones_restantes().getValue()+1);
            return new Transaccion(this);
        }else{
            return null;
        }
    }

    protected int getLimite_dia(){
        return this.limite_dia;
    }
    
    
    
    
}
