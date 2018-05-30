/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import gestion.QueryApuestas;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Ticket_Promedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        QueryApuestas q= new QueryApuestas();
        
        q.llenarFechas1();
        q.llenarFechas2();
        
        q.listarfechas1();
        q.listarfechas2();
        
        
        q.insertarJugadores(1);
        
        
    }
    
}
