package utez.edu.mx.carnetdesesiones.models.AcademicProgram;

import utez.edu.mx.carnetdesesiones.models.AcademicDivisions.AcademicDivisions;
import utez.edu.mx.carnetdesesiones.models.Periods.DaoPeriod;
import utez.edu.mx.carnetdesesiones.models.Periods.Periods;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.crud.DaoRepository;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.utils.MySQL.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAcademicProgram implements DaoRepository<AcademicProgram> {
    private Connection conn;//Coneccion

    private CallableStatement call ;
    private PreparedStatement pstm; //Es domnde nosotros preparamos la sentencia sql y se pueda leer del lado del sql

    private ResultSet rs;
    @Override
    public List<AcademicProgram> findAll() {
        List<AcademicProgram> academicPrograms = null;
        try {
            academicPrograms = new ArrayList<>();
            conn = new MySQLConnection().getConnection(); // Coneccion a la base de datos
            String query = "SELECT * FROM academic_program_list;";//Cosulta que se manda a la base de datos
            pstm = conn.prepareStatement(query);//Prepara la consulta para mandar el query
            rs = pstm.executeQuery();//Trae la consulta y ejecuta el query
            while (rs.next())//Verifica si hay datos
            {

                AcademicProgram academicProgram = new AcademicProgram();
                AcademicDivisions academicDivision = new AcademicDivisions();
                academicProgram.setProgramName(rs.getString("program_name"));
                academicProgram.setId_AcademicProgram(rs.getLong("id_academic_program"));
                academicDivision.setName(rs.getString("name"));
                academicProgram.setAcademicDivisions(academicDivision);

                academicPrograms.add(academicProgram);


            }

        } catch (SQLException e) {
            Logger.getLogger(DaoAcademicProgram.class.getName())
                    .log(Level.SEVERE, "Error findAll" + e.getMessage());
        }finally {
            close();
        }
        return academicPrograms;
    }

    @Override
    public AcademicProgram findOne(long id) {
        return null;
    }

    @Override
    public boolean save(AcademicProgram object) {
        return false;
    }

    @Override
    public boolean update(AcademicProgram object) {
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
            Logger.getLogger(DaoStudent.class.getName())
                    .log(Level.SEVERE,"Error findAll" + e.getMessage());
        }
    }
}
