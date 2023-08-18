package utez.edu.mx.carnetdesesiones.models.justifications;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.crud.DaoRepository;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.user.User;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoJustifications implements DaoRepository<Justifications> {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    private ResultSet rs2;
    private CallableStatement call;
    @Override
    public List<Justifications> findAll() {
        List<Justifications> justifications = null;
        try {
            justifications= new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select * from list_justifications;;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Justifications justification = new Justifications();
                User user = new User();
                justification.setId_justification(rs.getLong("id_justification"));
                justification.setReason(rs.getString("reason"));
                justification.setDate(rs.getString("date"));
                user.setName(rs.getString("name"));
                user.setFirst_last_name(rs.getString("first_last_name"));
                user.setSecond_last_name(rs.getString("second_last_name"));
                justification.setUser(user);
                justifications.add(justification);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoJustifications.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return justifications;
    }

    @Override
    public Justifications findOne(long id) {
        return null;
    }

    @Override
    public boolean save(Justifications object) {
        return false;
    }


    public boolean saveJustification(Justifications object,long id ,User user) {
        try {
            conn = new MySQLConnection().getConnectionStudent();
            String query = "select id_appointment from appointments where  fk_student = ? and status = 'Activo' ORDER BY id_appointment DESC LIMIT 1;";
            String query2 = "call CREATE_JUSTIFY_SESSION(?,?,?,?) ;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            rs.next();

            call = conn.prepareCall(query2);
            call.setLong(3,rs.getLong("id_appointment"));
            call.setLong(1,object.getSession().getId_session());
            call.setLong(4,user.getId_user());
            call.setString(2,object.getReason());

            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoJustifications.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean saveJustificationApp(Justifications object, long id, User user) {
        try {
            conn = new MySQLConnection().getConnectionConsultor();
            String query2 = "call CREATE_JUSTIFY_SESSION(?,?,?,?) ;";

            call = conn.prepareCall(query2);
            call.setLong(4,user.getId_user());
            call.setLong(3,id);
            call.setLong(1,object.getSession().getId_session());
            call.setString(2,object.getReason());

            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoJustifications.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    public boolean Accept(Justifications object, long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query2 = "call ACCEPT_JUSTIFICATION(?,?) ;";

            call = conn.prepareCall(query2);
            call.setLong(1,object.getId_justification());
            call.setLong(2, id);

            return  call.executeUpdate() == 1 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoJustifications.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
    @Override
    public boolean update(Justifications object) {
        return false;
    }

    @Override
    public boolean updateOne(Value object) {
        return false;
    }

    @Override
    public boolean delate(long id) {
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
