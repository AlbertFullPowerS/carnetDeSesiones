package utez.edu.mx.carnetdesesiones.models.Periods;

import utez.edu.mx.carnetdesesiones.models.AcademicProgram.AcademicProgram;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.crud.DaoRepository;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPeriod implements DaoRepository<Periods> {
    private Connection conn;//Coneccion

    private CallableStatement call ;
    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<Periods> findAll() {
        List<Periods> periods = null;
        try {
            periods = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "SELECT * FROM periods;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Periods period = new Periods();
                period.setId_Periods(rs.getLong("id_period"));
                period.setName(rs.getString("name"));
                period.setDateBegin(rs.getString("date_begin"));
                period.setDateEnd(rs.getString("date_end"));
                periods.add(period);


            }

        } catch (SQLException e) {
            Logger.getLogger(DaoPeriod.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return periods;
    }

    @Override
    public Periods findOne(long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "select *from periods where id_period = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            rs = pstm.executeQuery();

            Periods period= new Periods();
            if (rs.next())
            {
                period.setId_Periods(rs.getLong("id_period"));
                period.setName(rs.getString("name"));
                period.setDateBegin(rs.getString("date_begin"));
                period.setDateEnd(rs.getString("date_end"));

            }
            return period;
        }
        catch (SQLException e) {
            Logger.getLogger(DaoPeriod.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    @Override
    public boolean save(Periods object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call create_periods(?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getName());
            pstm.setString(2,object.getDateBegin());
            pstm.setString(3,object.getDateEnd());

            return  pstm.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoConsultor.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(Periods object) {
        return false;
    }

    @Override
    public boolean updateOne(Value object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call UPDATE_PERIODS(?,?,?);";
            System.out.println( "id : " +object.getIdU() );
            System.out.println( "Attr : " + object.getAttr());
            System.out.println( "Data : " + object.getData());

            pstm = conn.prepareStatement(query);
            pstm.setLong(1, Long.parseLong(object.getIdU()));
            pstm.setString(2,object.getAttr());
            pstm.setString(3,object.getData());



            return  pstm.executeUpdate() > 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoPeriod.class.getName())
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
            String query = "call DELETE_USER_PERIODS(?)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            return  pstm.executeUpdate()==0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoPeriod.class.getName())
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
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
