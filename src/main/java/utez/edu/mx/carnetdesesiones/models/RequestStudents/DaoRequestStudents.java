package utez.edu.mx.carnetdesesiones.models.RequestStudents;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.RequestConsultor.DaoRequestConsultor;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.justifications.DaoJustifications;
import utez.edu.mx.carnetdesesiones.models.justifications.Justifications;
import utez.edu.mx.carnetdesesiones.models.user.User;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRequestStudents {

    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql
    private CallableStatement call;
    private ResultSet rs;
    private ResultSet rs2;
    public boolean saveReques(RequestStudents object, long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "select id_appointment from appointments where  fk_student = ? and status = 'Activo' ORDER BY id_appointment DESC LIMIT 1;";
            String query2 = "call CONSULTANT_CHANGE_REQUIREMENT(?,?,?,'Estudiante') ;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            rs.next();
            call = conn.prepareCall(query2);
            call.setLong(1,rs.getLong("id_appointment"));
            call.setString(2,object.getReason());
            call.setLong(3,object.getUser().getId_user());

            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoRequestStudents.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean saveRequesApp(RequestStudents object, long id) {
        try {
            conn = new MySQLConnection().getConnectionConsultor();
            String query2 = "call CONSULTANT_CHANGE_REQUIREMENT(?,?,?,'Consultor') ;";
            call = conn.prepareCall(query2);
            call.setLong(1,id);
            call.setString(2,object.getReason());
            call.setLong(3,object.getUser().getId_user());

            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoRequestStudents.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean denyTranfer(RequestStudents requestStudent) {
        try {
            conn = new MySQLConnection().getConnection();
            String query2 = "call DENY_TRANSFER(?) ;";
            call = conn.prepareCall(query2);
            call.setLong(1,requestStudent.getId_request());
            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoRequestStudents.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean Tranfer(Consultor consultor , Appointment appointment) {
        try {
            conn = new MySQLConnection().getConnection();
            String query2 = "call CHANGES_CONSULTANT_FOR_appointments(?,?) ;";
            call = conn.prepareCall(query2);
            call.setLong(1,consultor.getId_consultor());
            call.setLong(2,appointment.getId_appointment());
            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoRequestStudents.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public List<RequestStudents> findAll() {
        List<RequestStudents> requestStudents = null;
        try {
            requestStudents = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select  * from LIST_TRANSFERENS;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                RequestStudents requestStudent = new RequestStudents();
                Appointment appointment = new Appointment();
                User user = new User();
                requestStudent.setId_request(rs.getLong("id_request"));
                requestStudent.setReason(rs.getString("reason"));
                requestStudent.setTypeUser(rs.getString("typeUser"));
                appointment.setId_appointment(rs.getLong("fk_appointments"));
                user.setName(rs.getString("name"));
                user.setFirst_last_name(rs.getString("first_last_name"));
                user.setSecond_last_name(rs.getString("second_last_name"));
                requestStudent.setUser(user);
                requestStudent.setAppointment(appointment);


                requestStudents.add(requestStudent);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoRequestConsultor.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return requestStudents;
    }

    public void close(){
        try{
            if(conn != null ) conn.close();
            if(pstm != null ) conn.close();
            if(rs != null ) conn.close();


        }catch(SQLException e)
        {
            Logger.getLogger(DaoRequestStudents.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
