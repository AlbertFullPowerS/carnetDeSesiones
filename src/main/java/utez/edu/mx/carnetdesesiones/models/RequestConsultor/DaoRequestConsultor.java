package utez.edu.mx.carnetdesesiones.models.RequestConsultor;

import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRequestConsultor {

    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql
    private CallableStatement call;
    private ResultSet rs;
    private ResultSet rs2;
    public boolean saveReques(RequestConsultor object, long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query2 = "call CREATE_REQUEST_CONSULTANTS(?,?) ;";
            call = conn.prepareCall(query2);
            call.setLong(1,id);
            call.setString(2,object.getReason());

            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoRequestConsultor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public void close(){
        try{
            if(conn != null ) conn.close();
            if(pstm != null ) conn.close();
            if(rs != null ) conn.close();


        }catch(SQLException e)
        {
            Logger.getLogger(DaoRequestConsultor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
