package utez.edu.mx.carnetdesesiones.models.Student;

import utez.edu.mx.carnetdesesiones.models.AcademicProgram.*;
import utez.edu.mx.carnetdesesiones.models.Group.*;
import utez.edu.mx.carnetdesesiones.models.Tutor.*;
import utez.edu.mx.carnetdesesiones.models.crud.*;
import utez.edu.mx.carnetdesesiones.utils.MySQL.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoStudent implements DaoRepository<Student> {
    private Connection conn;//Coneccion

    private CallableStatement call ;
    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<Student> findAll() {
        List<Student> students = null;
        try {
            students = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "select * from students_lists;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Group group = new  Group ();
                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));

                group.setGroup(rs.getString("group"));
                group.setGrade(rs.getString("grade"));
                group.setAcademic_program(academicProgram);
                Student studet = new Student(
                        rs.getString("name"),
                        rs.getString("first_last_name"),
                        rs.getString("second_last_name"),
                        rs.getLong("id_student"),
                        rs.getString("enrollment"),group
                        );
                studet.setId_user(rs.getLong("id_user"));
                //Crea el objeto para almacnarlo al array list
                //user.setId(rs.getLong("id"));//Le asigna el valor

                students.add(studet);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return students;
    }
    public List<Student> findAllTutor(long id) {
        List<Student> students = null;
        try {
            students = new ArrayList<>();
            conn = new MySQLConnection().getConnectionTutor();// Coneccion a la base de datos
            String query = "call LIST_STUDENTS_FOR_TUTOR(?);";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                Group group = new  Group ();
                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));

                group.setGroup(rs.getString("group"));
                group.setGrade(rs.getString("grade"));
                group.setAcademic_program(academicProgram);
                Student studet = new Student(
                        rs.getString("name"),
                        rs.getString("first_last_name"),
                        rs.getString("second_last_name"),
                        rs.getLong("id_student"),
                        rs.getString("enrollment"),group
                );
                studet.setId_user(rs.getLong("fk_user"));
                //Crea el objeto para almacnarlo al array list
                //user.setId(rs.getLong("id"));//Le asigna el valor

                students.add(studet);

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }

        return students;
    }
    @Override
    public Student findOne(long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "CALL READ_ESTUDIANTE_GROUP(?);";
            call = conn.prepareCall(query);
            call.setLong(1 , id);
            rs = call.executeQuery();

            Tutor tutor = new Tutor();
            Group group = new Group();
            Student student= new Student();
            if (rs.next())
            {

                    student.setId_user(rs.getLong("id_user"));
                    student.setId_student(rs.getLong("id_student"));
                    tutor.setName(rs.getString("nombre_Consultor"));
                    student.setSessiones_view(rs.getInt("sesiones"));
                    student.setCitas_view(rs.getInt("citas"));
                    student.setPhone(rs.getString("phone_number"));

                    student.setName(rs.getString("name"));
                    student.setFirst_last_name(rs.getString("first_last_name"));
                    student.setSecond_last_name(rs.getString("second_last_name"));
                    student.setEmail(rs.getString("email"));

                    group.setGrade(rs.getString("grade"));
                    group.setGroup(rs.getString("group"));

                AcademicProgram academicProgram = new AcademicProgram();
                academicProgram.setProgramName(rs.getString("program_name"));


                    group.setAcademic_program(academicProgram);
                    student.setStatus(rs.getString("status"));
                    student.setEnrollment(rs.getString("enrollment"));
                    
                    group.setTutor(tutor);
                    student.setGroup(group);

            }
            return student;
        }
        catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    @Override
    public boolean save(Student object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call CREATE_USER_ESTUDIANTES(?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6',?,?,?,?,?,?,?);";

            call = conn.prepareCall(query);
            call.setString(1,object.getEmail());
            call.setString(2,object.getPassword());
            call.setString(3,object.getName());
            call.setString(4,object.getFirst_last_name());
            call.setString(5,object.getSecond_last_name());
            call.setString(6,object.getEnrollment());
            call.setString(7,object.getPhone());
            call.setLong(8,object.getGroup().getId_group());


            return  call.executeUpdate() == 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE,"Error findOne" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(Student object) {
        return false;
    }

    @Override
    public boolean updateOne(Value object) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "call update_student_one(?,?,?,'b8b784cd6a579eca7fbd9ac04b102e12e92d135fe55b3b9bd6fbb8061afb36b6');";
            System.out.println( "id : " +object.getIdU() );
            System.out.println( "Attr : " + object.getAttr());
            System.out.println( "Data : " + object.getData());

            pstm = conn.prepareStatement(query);
            pstm.setLong(1, Long.parseLong(object.getIdU()));
            pstm.setString(2,object.getAttr());
            pstm.setString(3,object.getData());



            return  pstm.executeUpdate() > 0 ; //1
        }catch (SQLException e) {
            Logger.getLogger(DaoStudent.class.getName())
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
            String query = "call DELETE_USER_STUDENT(?)";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1 , id);
            return  pstm.executeUpdate()==0;
        }catch ( SQLException e)
        {
            Logger.getLogger(DaoStudent.class.getName())
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
