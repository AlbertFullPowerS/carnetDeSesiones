package utez.edu.mx.carnetdesesiones.models.Consultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
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
public class DaoConsultor implements DaoRepository<Consultor> {
    private Connection conn;//Coneccion


    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<Consultor> findAll() {
            List<Consultor> Consultors = null;
        try {
            Consultors = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select * from consultors_list;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {


                Consultor consultor = new Consultor(
                        rs.getLong("id_user"),
                        rs.getString("name"),
                        rs.getString("first_last_name"),
                        rs.getString("second_last_name"),
                        rs.getString("email")

                );
                consultor.setId_user( rs.getLong("id_consultant"));
                //Crea el objeto para almacnarlo al array list
                //user.setId(rs.getLong("id"));//Le asigna el valor

                Consultors.add(consultor);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return Consultors;
    }

    @Override
    public Consultor findOne(long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call info_users_consultor__tutor (?,'consultants');";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            rs = pstm.executeQuery();

            Consultor consultor= new Consultor();
            if (rs.next())
            {
                consultor.setId_consultor(rs.getLong("id_consultant"));
                consultor.setId_user(rs.getLong("id_user"));
                consultor.setEmail(rs.getString("email"));
                consultor.setName(rs.getString("name"));
                consultor.setFirst_last_name(rs.getString("first_last_name"));
                consultor.setSecond_last_name(rs.getString("second_last_name"));
            }
            return consultor;
        }
        catch (SQLException e) {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    @Override
    public boolean save(Consultor object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call CREATE_USER_CONSULTANTS(?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6',?,?,?,?) ;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getEmail());
            pstm.setString(2,object.getPassword());
            pstm.setString(3,object.getName());
            pstm.setString(4,object.getFirst_last_name());
            pstm.setString(5,object.getSecond_last_name());



            return  pstm.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }
/*----------..----------*/
    @Override
    public boolean update(Consultor object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "CALL UPDATE_STUDENT(?,?,?,?,?,?,?,?,?,?)";

            pstm = conn.prepareStatement(query);
            pstm.setLong(1,object.getId_consultor());
            pstm.setString(2,object.getEmail());
            pstm.setString(3,object.getPassword());
            pstm.setString(4,object.getName());
            pstm.setString(5,object.getFirst_last_name());
            pstm.setString(6,object.getSecond_last_name());


            return  pstm.executeUpdate() > 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
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
            Logger.getLogger(DaoConsultor.class.getName())
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
            String query = "call DELETE_USER_CONSULTANTS(?)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            return  pstm.executeUpdate()==0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoConsultor.class.getName())
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
