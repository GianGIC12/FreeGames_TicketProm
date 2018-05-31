/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import beans.JugadorBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class QueryApuestas {

    List<JugadorBean> jugadores;
    String sql;

    String[] fechas1;
    String[] fechas2;

    public QueryApuestas() {

        jugadores = new ArrayList<>();

        fechas1 = new String[366];
        fechas2 = new String[366];

    }

    public void llenarFechas1() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        String fecha = dateFormat.format(date);
        String annio = fecha.substring(0, 4);
        int aux = Integer.parseInt(annio) - 1;

        fechas1[0] = aux + "-12-31";

        int contador = 0;

        for (int i = 1; i <= 12; i++) {

            String mes = "-0";

            if (i >= 10) {
                mes = "-";
            }

            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {

                for (int j = 1; j <= 31; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else if (i == 2) {

                for (int j = 1; j <= 28; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else {

                for (int j = 1; j <= 30; j++) {
                    contador++;

                    if (j < 10) {

                        fechas1[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas1[contador] = annio + mes + i + "-" + j;

                    }

                }

            }

        }

    }

    public void llenarFechas2() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        String fecha = dateFormat.format(date);
        String annio = fecha.substring(0, 4);
        int aux = Integer.parseInt(annio) - 1;
        int aux2 = aux - 1;
        annio = aux + "";

        fechas2[0] = aux2 + "-12-31";

        int contador = 0;

        for (int i = 1; i <= 12; i++) {

            String mes = "-0";

            if (i >= 10) {
                mes = "-";
            }

            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {

                for (int j = 1; j <= 31; j++) {
                    contador++;

                    if (j < 10) {

                        fechas2[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas2[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else if (i == 2) {

                for (int j = 1; j <= 28; j++) {
                    contador++;

                    if (j < 10) {

                        fechas2[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas2[contador] = annio + mes + i + "-" + j;

                    }

                }

            } else {

                for (int j = 1; j <= 30; j++) {
                    contador++;

                    if (j < 10) {

                        fechas2[contador] = annio + mes + i + "-0" + j;

                    } else {

                        fechas2[contador] = annio + mes + i + "-" + j;

                    }

                }

            }

        }

    }

    public void listarfechas1() {

        for (int i = 0; i < fechas1.length; i++) {

            System.out.println(fechas1[i]);
        }

    }

    public void listarfechas2() {

        for (int i = 0; i < fechas2.length; i++) {

            System.out.println(fechas2[i]);
        }

    }

    public void insertarJugadores(int diaNum) throws SQLException {

        String fecha = "";

        fecha = fechas1[diaNum - 1];

        System.out.println("" + fecha);

        Conexion objCon = new Conexion();
        objCon.conectar();

        sql = "select  b.id as id_apuesta, b.iduser as id_user,b.amount as monto_jugada, "
                + " b.created_at as fecha_jugada, u.name as nombre, u.lastname as apellido, u.email as email, u.phone as telefono "
                + "  from db_apuestatotal_prod.user_bet as b "
                + " join db_apuestatotal_prod.user_user as u"
                + " on b.idUser=u.id "
                + " where SUBSTRING(b.created_at,1,10)= " + "'"+fecha +"'"  + " and b.amount is not null";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        int i = 0;
        int id_apuesta = 0;
        int id_user = 0;
        float monto_jugada = 0.0f;
        String nombre = "No Definido";
        String apellido = "No Definido";
        String correo = "No Definido";
        String telefono = "No Definido";

        while (rs.next()) {

            i++;

            JugadorBean jugador = new JugadorBean();

            id_apuesta = rs.getInt(1);
            id_user = rs.getInt(2);
            monto_jugada = rs.getFloat(3);

            if (rs.getString(5) != null) {
                nombre = rs.getString(5);
            }

            if (rs.getString(6) != null) {

                apellido = rs.getString(6);

            }

            if (rs.getString(7) != null) {
                correo = rs.getString(7);
            }

            if (rs.getString(8) != null) {
                telefono = rs.getString(8);
            }

            jugador.setIdApuesta(id_apuesta);
            jugador.setIdUser(id_user);
            jugador.setMonto_jugada(monto_jugada);
            jugador.setFecha_jugada(fecha);
            jugador.setNombre(nombre);
            jugador.setApellido(apellido);
            jugador.setCorreo(correo);
            jugador.setTelefono(telefono);

            jugadores.add(jugador);

            System.out.println(i + " Extraccion ");

        }

        objCon.desconectar();

    }

    public void listarJugadas(){
        
        int k=0;
        for (JugadorBean jugador: jugadores) {
            k++;
            System.out.println(k+": "+ "Id_Puesta: " + jugador.getIdApuesta()
            +" Id_user: "+ jugador.getIdUser()
            +" monto_jugada: "+jugador.getMonto_jugada()
            +" fecha_jugada: "+jugador.getFecha_jugada()
            +" nombreJugador: "+jugador.getNombre()
            +" apellidoJugador: "+jugador.getApellido()
            +" emailJugador: "+jugador.getCorreo()
            +" telefonoJugador: "+jugador.getTelefono()
            );
            
        }
        
        
        
        
        
    }

    public List<JugadorBean> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorBean> jugadores) {
        this.jugadores = jugadores;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String[] getFechas1() {
        return fechas1;
    }

    public void setFechas1(String[] fechas1) {
        this.fechas1 = fechas1;
    }

    public String[] getFechas2() {
        return fechas2;
    }

    public void setFechas2(String[] fechas2) {
        this.fechas2 = fechas2;
    }
    
    
}
