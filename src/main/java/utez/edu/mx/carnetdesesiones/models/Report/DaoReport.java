package utez.edu.mx.carnetdesesiones.models.Report;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Appoinment.DaoAppointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReport {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    private List<Report> reports;
    public List<Report> findAll(String data_start , String data_end) {
        reports = null;
        try {
            reports = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "call CREATE_REPORT(?,?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setString(1 , data_start);
            pstm.setString(2 , data_end);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Report report = new Report();
                report.setTabla(rs.getString("table"));
                report.setData(rs.getString("date"));
                report.setAction(rs.getString("action"));
                report.setNumero(rs.getLong("numero"));

                reports.add(report);

            }
            return reports;
        } catch (SQLException e) {
            Logger.getLogger(DaoReport.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public void close(){
        try{
            if(conn != null ) conn.close();
            if(pstm != null ) conn.close();
            if(rs != null ) conn.close();


        }catch(SQLException e)
        {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
