package utez.edu.mx.carnetdesesiones.models.user;

import utez.edu.mx.carnetdesesiones.models.Admin.*;
import utez.edu.mx.carnetdesesiones.models.Consultor.*;
import utez.edu.mx.carnetdesesiones.models.Student.*;
import utez.edu.mx.carnetdesesiones.models.Tutor.*;
import utez.edu.mx.carnetdesesiones.models.crud.*;
import utez.edu.mx.carnetdesesiones.utils.MySQL.*;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser implements DaoRepository<User> {

    private Connection conn;//Coneccion

    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs ;
    private CallableStatement call;

    public  User  login(String email , String password) {
        User user = null;


        try {

            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "CALL login(?,?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6');";//Cosulta que se manda a la base de datos

            call = conn.prepareCall(query);
            call.setString(1, email);
            call.setString(2, password);//Prepara la consulta para mandar el query
            rs = call.executeQuery();//Trae la consulta y ejecuta el query

            if (rs.next()) {

                switch (rs.getString("Us")) {
                    case "Admin":
                       Admin admin = new Admin(rs.getLong("fk_user"), rs.getString("email"),
                               null, rs.getString("name"),
                                rs.getString("first_last_name"), rs.getString("second_last_name"),rs.getLong("id_admin"));
                        return admin;
                    case "Consultants":
                        Consultor consultor = new Consultor(rs.getLong("fk_user"), rs.getString("email"),
                                null, rs.getString("name"),
                                rs.getString("first_last_name"), rs.getString("second_last_name"),rs.getLong("id_consultant"));
                        return consultor;
                    case "Tutors":
                        Tutor tutor = new Tutor(rs.getLong("fk_user"), rs.getString("email"),
                                null, rs.getString("name"),
                                rs.getString("first_last_name"), rs.getString("second_last_name"),rs.getLong("id_tutor"));
                        return tutor;

                    case "Student":
                        Student student = new  DaoStudent().findOne(rs.getLong("fk_user"));
                        return student;
                }
                System.out.println(rs.getString("Us"));

            }

            //


        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }
        return user;
    }
    public  boolean  ChangePassword(String ol_password , String new_password ,User user) {


        try {

            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "CALL CHANGES_PASSWORD_USERS(?,?,?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6');";//Cosulta que se manda a la base de datos

            call = conn.prepareCall(query);
            call.setString(1, ol_password);
            call.setString(2, new_password);
            call.setLong(3, user.getId_user());//Prepara la consulta para mandar el query
            rs = call.executeQuery();//Trae la consulta y ejecuta el query


            //
            rs.next();
            System.out.println(rs.getLong("rest"));
            System.out.println(rs.getLong("rest") == 1);
            return  rs.getLong("rest") == 1 ;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }
        return false;
    }
    @Override
    public List<utez.edu.mx.carnetdesesiones.models.user.User> findAll() {
        return null;
    }

    @Override
    public utez.edu.mx.carnetdesesiones.models.user.User findOne(long id) {
        return null;
    }

    @Override
    public boolean save(utez.edu.mx.carnetdesesiones.models.user.User object) {
        return false;
    }


    @Override
    public boolean update(User object) {
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
}
