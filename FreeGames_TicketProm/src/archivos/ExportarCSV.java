/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.JugadorBean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }
    
  public void exportarResultados(List<JugadorBean> jugadores, String fechita) throws IOException{
      
      String outputFile = "C:/Users/user/Desktop/bd_ticket_promedio_" + fechita + ".csv";
      
       boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File bd_ticket_promedio = new File(outputFile);
            bd_ticket_promedio.delete();
        }
      
      
        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

        csvOutput.write("id_apuesta");
        csvOutput.write("id_usuario");
        csvOutput.write("monto_jugada");
        csvOutput.write("tipo_apuesta");

        csvOutput.write("fecha_jugada");
        csvOutput.write("nombre_jugador");
        csvOutput.write("apellido_jugador");
        csvOutput.write("correo_jugador");

        csvOutput.write("telefono_jugador");
        
        csvOutput.endRecord();
        
        
      for (JugadorBean jugador: jugadores) {
         
           csvOutput.write(jugador.getIdApuesta()+"");
        csvOutput.write(jugador.getIdUser()+"");
        csvOutput.write(jugador.getMonto_jugada()+"");
        csvOutput.write(jugador.getTipo()+"");

        csvOutput.write(jugador.getFecha_jugada());
        csvOutput.write(jugador.getNombre());
        csvOutput.write(jugador.getApellido());
        csvOutput.write(jugador.getCorreo());

        csvOutput.write(jugador.getTelefono());
        
        csvOutput.endRecord();
        
          
          
          
      }
        
        
        
        
        
        csvOutput.close();
        
  }  
    
    
    
    
}
