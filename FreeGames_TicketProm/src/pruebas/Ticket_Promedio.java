/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import archivos.ExportarCSV;
import gestion.QueryApuestas;
import java.io.IOException;
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
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        
        Calendar calendar = Calendar.getInstance();

        int num_dia = calendar.get(Calendar.DAY_OF_YEAR);

        
        System.out.println("" + num_dia);

        System.out.println("estamos en el día: " + num_dia);
        
        
        QueryApuestas q= new QueryApuestas();
        
        System.out.println("LLenando la fecha 1:**************");
        q.llenarFechas1();
         System.out.println("LLenando la fecha 2:*************");
        q.llenarFechas2();
        
        
        q.listarfechas1();
        q.listarfechas2();
        System.out.println("Estamos en la fecha: " +q.getFechas1()[num_dia]);
        
        System.out.println("Insertando Jugadas*************");
        q.insertarJugadores(num_dia);
        
        System.out.println("Listando Jugadas *************");
        q.listarJugadas();
        
        System.out.println("****Carga Exitosa*****");
        ExportarCSV e= new ExportarCSV();
        e.exportarResultados(q.getJugadores(),q.getFechas1()[num_dia-1]);
        
        System.out.println("Exportación exitosa*************");
        System.out.println("Migración exitosa!!!!!!!!!!!!");
        
    }
    
}
