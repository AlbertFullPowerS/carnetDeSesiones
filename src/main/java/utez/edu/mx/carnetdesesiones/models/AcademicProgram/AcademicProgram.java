package utez.edu.mx.carnetdesesiones.models.AcademicProgram;

import utez.edu.mx.carnetdesesiones.models.AcademicDivisions.AcademicDivisions;

public class AcademicProgram {

    private long id_AcademicProgram;

    private String programName ;

    private AcademicDivisions academicDivisions;
    public AcademicProgram(){}
    public AcademicProgram(long id_AcademicProgram, String programName, AcademicDivisions academicDivisions) {
        this.id_AcademicProgram = id_AcademicProgram;
        this.programName = programName;
        this.academicDivisions = academicDivisions;
    }

    public long getId_AcademicProgram() {
        return id_AcademicProgram;
    }

    public void setId_AcademicProgram(long id_AcademicProgram) {
        this.id_AcademicProgram = id_AcademicProgram;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public AcademicDivisions getAcademicDivisions() {
        return academicDivisions;
    }

    public void setAcademicDivisions(AcademicDivisions academicDivisions) {
        this.academicDivisions = academicDivisions;
    }
}
