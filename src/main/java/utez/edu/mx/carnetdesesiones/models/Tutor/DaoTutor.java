package utez.edu.mx.carnetdesesiones.models.Tutor;

import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.crud.DaoRepository;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTutor implements DaoRepository<Tutor> {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<Tutor> findAll() {
        List<Tutor> tutors = null;
        try {
            tutors = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select * from tutors_list;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {






                Tutor tutor = new Tutor();
                tutor.setId_tutor(rs.getLong("id_tutor"));
                tutor.setId_user(rs.getLong("id_user"));
                tutor.setName(rs.getString("name"));
                tutor.setEmail(rs.getString("email"));
                tutor.setFirst_last_name(rs.getString("first_last_name"));
                tutor.setSecond_last_name(rs.getString("second_last_name"));
                //Crea el objeto para almacnarlo al array list
                //user.setId(rs.getLong("id"));//Le asigna el valor

                tutors.add(tutor);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return tutors;
    }

    @Override
    public Tutor findOne(long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call info_users_consultor__tutor (?,'tutors');";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            rs = pstm.executeQuery();

            Tutor tutor= new Tutor();
            if (rs.next())
            {
                tutor.setId_tutor(rs.getLong("id_tutor"));
                tutor.setId_user(rs.getLong("id_user"));
                tutor.setEmail(rs.getString("email"));
                tutor.setName(rs.getString("name"));
                tutor.setFirst_last_name(rs.getString("first_last_name"));
                tutor.setSecond_last_name(rs.getString("second_last_name"));
                tutor.setCountGroup(rs.getLong("count_group"));
            }
            return tutor;
        }
        catch (SQLException e) {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    @Override
    public boolean save(Tutor object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call CREATE_USER_TUTOR(?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6',?,?,?,?) ;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getEmail());
            pstm.setString(2,object.getPassword());
            pstm.setString(3,object.getName());
            pstm.setString(4,object.getFirst_last_name());
            pstm.setString(5,object.getSecond_last_name());



            return  pstm.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(Tutor object) {
        return false;
    }

    @Override
    public boolean updateOne(Value object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call UPDATE_USER_CT_ONE(?,?,?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6');";
            System.out.println( "id : " +object.getIdU() );
            System.out.println( "Attr : " + object.getAttr());
            System.out.println( "Data : " + object.getData());

            pstm = conn.prepareStatement(query);
            pstm.setLong(1, Long.parseLong(object.getIdU()));
            pstm.setString(2,object.getAttr());
            pstm.setString(3,object.getData());



            return  pstm.executeUpdate() > 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean delate(long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call DELETE_USER_TUTOR(?)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            return  pstm.executeUpdate()==0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());

        }finally {
            close();
        }
        return false;
    }
    public boolean addGroup(Group group, Tutor tutor) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call UPDATE_GROUP_ONE(?,'fk_tutor',?)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , group.getId_group());
            pstm.setString(2 , String.valueOf(tutor.getId_tutor()));
            return  pstm.executeUpdate()>0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());

        }finally {
            close();
        }
        return false;
    }
    public boolean delateGroup(Group group) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call UPDATE_GROUP_ONE(?,'fk_tutor',null)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , group.getId_group());
            return  pstm.executeUpdate()>0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoTutor.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());

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
