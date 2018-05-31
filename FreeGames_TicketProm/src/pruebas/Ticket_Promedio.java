/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import gestion.QueryApuestas;
import java.sql.SQLException;
import java.util.Calendar;

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
        
        Calendar calendar = Calendar.getInstance();

        int num_dia = calendar.get(Calendar.DAY_OF_YEAR);

        
        System.out.println("" + num_dia);

        System.out.println("estamos en el día: " + num_dia);
        
        
        QueryApuestas q= new QueryApuestas();
        
        q.llenarFechas1();
        q.llenarFechas2();
        
        q.listarfechas1();
        q.listarfechas2();
        
        
        q.insertarJugadores(num_dia);
        
        q.listarJugadas();
        
        
        
    }
    
}
