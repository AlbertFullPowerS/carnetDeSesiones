package utez.edu.mx.carnetdesesiones.models.Appoinment;

import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
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

public class DaoAppointment {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    private List<Appointment> appointments;
    public List<Appointment> findAllAppoinments(long id) {
        appointments = null;
        try {
            appointments = new ArrayList<>();
            conn = new MySQLConnection().getConnectionConsultor(); // Coneccion a la base de datos
            String query = "call WATCH_APPOINTMENTS_CONSULTANT(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Appointment appointment = new Appointment();
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setFirst_last_name(rs.getString("first_last_name"));
                student.setSecond_last_name(rs.getString("second_last_name"));
                appointment.setPlace(rs.getString("place"));
                appointment.setId_appointment(rs.getLong("id_appointment"));
                appointment.setStudent(student);
                appointments.add(appointment);

            }
            return appointments;
        } catch (SQLException e) {
            Logger.getLogger(DaoAppointment.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public boolean save(Appointment object , String date , Consultor consultor) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "CALL CREATE_APPOINTMENTS(?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,object.getStudent().getId_student());
            pstm.setString(2,object.getPlace());
            pstm.setString(3,date);
            pstm.setLong(4,consultor.getId_consultor());



            return  pstm.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoAppointment.class.getName())
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
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
