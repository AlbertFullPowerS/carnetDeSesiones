package utez.edu.mx.carnetdesesiones.models.Group;

import utez.edu.mx.carnetdesesiones.models.AcademicProgram.AcademicProgram;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Periods.DaoPeriod;
import utez.edu.mx.carnetdesesiones.models.Periods.Periods;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;
import utez.edu.mx.carnetdesesiones.models.crud.DaoRepository;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.user.User;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoGroup implements DaoRepository<Group> {
    private Connection conn;//Coneccion

    private CallableStatement call ;
    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<Group> findAll() {
        List<Group> groups = null;
        try {
            groups = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select * from groups_list_min;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Group group = new  Group ();
                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));
                group.setId_group(rs.getLong("id_group"));
                group.setGroup(rs.getString("group"));
                group.setGrade(rs.getString("grade"));
                group.setAcademic_program(academicProgram);

                groups.add(group);


            }

        } catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return groups;
    }

    public List<Group> findAllMax() {
        List<Group> groups = null;
        try {
            groups = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "call  GROUP_LIST_AVN();";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Group group = new  Group ();
                Tutor tutor = new Tutor();
                Periods period = new Periods();
                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));
                group.setId_group(rs.getLong("id_group"));
                group.setGroup(rs.getString("group"));
                group.setGrade(rs.getString("grade"));
                group.setAcademic_program(academicProgram);
                tutor.setName(rs.getString("name"));
                tutor.setFirst_last_name(rs.getString("first_last_name"));
                period.setName(rs.getString("period_name"));
                period.setDateBegin(rs.getString("date_begin"));

                group.setTutor(tutor);
                group.setPeriodo(period);

                groups.add(group);


            }

        } catch (SQLException e) {
            Logger.getLogger(DaoGroup.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return groups;
    }
    public List<Group> findAllTutor(long id) {
        List<Group> groups = null;
        try {
            groups = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "CAll READ_GROUPS_TUTOR(?);";
            //Cosulta que se manda a la base de datos
            call = conn.prepareCall(query);
            call.setLong(1 , id);
            //Prepara la consulta para mandar el query
            rs = call.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Group group = new  Group ();
                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));
                group.setId_group(rs.getLong("id_group"));
                group.setGroup(rs.getString("group"));
                group.setGrade(rs.getString("grade"));
                group.setAcademic_program(academicProgram);

                groups.add(group);


            }

        } catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return groups;
    }

    @Override
    public Group findOne(long id) {

        try {
            conn = new MySQLConnection().getConnection();
            String query = "CALL WATCH_ONE_GROUP(?)";
            call = conn.prepareCall(query);
            call.setLong(1 , id);
            rs = call.executeQuery();
            Group group= null;
            if (rs.next())
            {
                group= new Group();
                Periods period = new Periods();
                AcademicProgram academicProgram = new AcademicProgram();
                Tutor tutor = new Tutor();

                group.setId_group(rs.getLong("id_group"));
                group.setGrade(rs.getString("grade"));
                group.setGroup(rs.getString("group"));
                tutor.setName(rs.getString("name"));
                tutor.setFirst_last_name(rs.getString("first_last_name"));
                period.setName(rs.getString("perido_name"));
                period.setDateEnd(rs.getString("date_begin"));
                period.setDateBegin(rs.getString("date_end"));
                academicProgram.setProgramName(rs.getString("program_name"));

                group.setTutor(tutor);
                group.setPeriodo(period);
                group.setAcademic_program(academicProgram);


            }
            return group ;
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
    public boolean save(Group object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call CREATE_GRUPO(?,?,?,?,?) ;";
            call = conn.prepareCall(query);
            call.setString(1,object.getGrade());
            call.setString(2,object.getGroup());
            call.setLong(3,object.getAcademic_program().getId_AcademicProgram());
            call.setLong(4,object.getPeriodo().getId_Periods());
            call.setLong(5,object.getTutor().getId_tutor());



            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoGroup.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(Group object) {
        return false;
    }

    @Override
    public boolean updateOne(Value object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call UPDATE_GROUP_ONE(?,?,?);";
            System.out.println( "id : " +object.getIdU() );
            System.out.println( "Attr : " + object.getAttr());
            System.out.println( "Data : " + object.getData());

            pstm = conn.prepareStatement(query);
            pstm.setLong(1, Long.parseLong(object.getIdU()));
            pstm.setString(2,object.getAttr());
            pstm.setString(3,object.getData());



            return  pstm.executeUpdate() > 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoGroup.class.getName())
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
            String query = "call DELETE_USER_GROUPS(?)";
            call = conn.prepareCall(query);
            call.setLong(1 , id);
            return  call.executeUpdate()==0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoGroup.class.getName())
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
