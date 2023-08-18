package utez.edu.mx.carnetdesesiones.models.Session;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.justifications.DaoJustifications;
import utez.edu.mx.carnetdesesiones.models.justifications.Justifications;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSession {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql
private CallableStatement call;
    private ResultSet rs;
    private ResultSet rs2;

    public List<Session> findAllConsult(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "call carnet_sesiones.citas_view(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Session session = new Session();
                Appointment appointment = new Appointment();
                Consultor consultor = new Consultor();
                session.setId_session(rs.getLong("id_session"));
                 consultor.setId_consultor(rs.getLong("fk_consultant"));
                 session.setDate_end(rs.getString("date_begin"));
                session.setDate_begin(rs.getString("date_end"));
                session.setAttendance(rs.getString("attendance"));
                appointment.setId_appointment(rs.getLong("fk_appointment"));
                session.setAppointment(appointment);
                session.setConsultor(consultor);
                sessions.add(session);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return sessions;
    }
    public List<Session> findAllCal(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "call carnet_sesiones.citas_view(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Session session = new Session(rs.getString("date_begin"));

                sessions.add(session);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return sessions;
    }
    public List<Session> findAllHistory(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "call ver_historial_alumno(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Session session = new Session();
                Appointment appointment = new Appointment();
                Consultor consultor = new Consultor();
                session.setId_session(rs.getLong("id_session"));
                session.setDate_begin(rs.getString("date_begin"));
                session.setAttendance(rs.getString("attendance"));
                consultor.setName(rs.getString("name"));
                consultor.setFirst_last_name(rs.getString("first_last_name"));
                appointment.setPlace(rs.getString("place"));
                session.setConsultor(consultor);
                session.setAppointment(appointment);
                sessions.add(session);

            }
            return sessions;
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public List<Session> findAllNextSessions(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnectionConsultor(); // Coneccion a la base de datos
            String query = "call next_sessions(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Session session = new Session();
                Appointment appointment = new Appointment();
                Student student = new Student();
                session.setId_session(rs.getLong("id_session"));
                session.setDate_begin(rs.getString("date_begin"));
                session.setAttendance(rs.getString("attendance"));
                student.setName(rs.getString("name"));
                student.setFirst_last_name(rs.getString("first_last_name"));
                student.setSecond_last_name(rs.getString("second_last_name"));
                student.setId_student(rs.getLong("id_student"));
                appointment.setPlace(rs.getString("place"));
                appointment.setId_appointment(rs.getLong("fk_appointment"));
                appointment.setStudent(student);

                session.setAppointment(appointment);
                sessions.add(session);

            }
            return sessions;
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public List<Session> findAllStudent(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnectionStudent(); // Coneccion a la base de datos
            String query = "select id_appointment from appointments where  fk_student = ? and status = 'Activo' ORDER BY id_appointment DESC LIMIT 1;";//Cosulta que se manda a la base de datos
            String query2 = "call WATCH_SESSION_FOR_APPOINTMENT(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            call = conn.prepareCall(query2);
            rs.next();
            call.setLong(1,rs.getLong("id_appointment"));
            rs2 = call.executeQuery();

            while (rs2.next())//Verifica si hay datos
            {


                Session session = new Session(rs2.getString("date_begin"));
                Appointment appointment = new Appointment();
                Consultor consultor = new Consultor();
                session.setId_session(rs2.getLong("id_session"));
                session.setDate_begin(rs2.getString("date_begin"));
                session.setAttendance(rs2.getString("attendance"));
                consultor.setName(rs2.getString("name"));
                consultor.setFirst_last_name(rs2.getString("first_last_name"));
                consultor.setSecond_last_name(rs2.getString("second_last_name"));
                appointment.setPlace(rs2.getString("place"));
                session.setConsultor(consultor);
                session.setAppointment(appointment);
                sessions.add(session);

            }
            return sessions;
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public List<Session> findAllAppointment(long id) {
        List<Session> sessions = null;
        try {
            sessions = new ArrayList<>();
            conn = new MySQLConnection().getConnectionConsultor(); // Coneccion a la base de datos
            String query2 = "call WATCH_SESSION_FOR_APPOINTMENT_STUDENT(?);";//Cosulta que se manda a la base de datos
            call = conn.prepareCall(query2);
            call.setLong(1,id);
            rs2 = call.executeQuery();

            while (rs2.next())//Verifica si hay datos
            {


                Session session = new Session(rs2.getString("date_begin"));
                Appointment appointment = new Appointment();
                Student student = new Student();
                session.setId_session(rs2.getLong("id_session"));
                session.setDate_begin(rs2.getString("date_begin"));
                session.setAttendance(rs2.getString("attendance"));
                student.setName(rs2.getString("name"));
                student.setId_student(rs2.getLong("id_student"));
                student.setFirst_last_name(rs2.getString("first_last_name"));
                student.setSecond_last_name(rs2.getString("second_last_name"));
                appointment.setPlace(rs2.getString("place"));
                appointment.setId_appointment(rs2.getLong("id_appointment"));
                appointment.setStudent(student);
                session.setAppointment(appointment);
                sessions.add(session);

            }
            return sessions;
        } catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return null;

    }
    public boolean saveRegisterFalta(Session object) {
        try {
            conn = new MySQLConnection().getConnectionConsultor();
            String query = "call INASISTENCE_SESSION(?);";

            call = conn.prepareCall(query);
            call.setLong(1,object.getId_session());
            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public boolean saveRegisterAttendance(Session object) {
        try {
            conn = new MySQLConnection().getConnectionConsultor();
            String query = "call REGISTER_ATTENDANCE_SESSION(?);";

            call = conn.prepareCall(query);
            call.setLong(1,object.getId_session());
            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoSession.class.getName())
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
            Logger.getLogger(DaoSession.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
