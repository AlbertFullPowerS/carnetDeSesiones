package utez.edu.mx.carnetdesesiones.models.Group;

import utez.edu.mx.carnetdesesiones.models.AcademicProgram.AcademicProgram;
import utez.edu.mx.carnetdesesiones.models.Periods.Periods;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;

public class Group {
    private long id_group;
    private String grade;
    private String group;
    private AcademicProgram academic_program;
    private Periods periodo;

    private Tutor tutor ;
    public Group(){}
    public Group(long id_group, String grade, String group, AcademicProgram academic_program, Periods periodo) {
        this.id_group = id_group;
        this.grade = grade;
        this.group = group;
        this.academic_program = academic_program;
        this.periodo = periodo;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public long getId_group() {
        return id_group;
    }

    public void setId_group(long id_group) {
        this.id_group = id_group;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public AcademicProgram getAcademic_program() {
        return academic_program;
    }

    public void setAcademic_program(AcademicProgram academic_program) {
        this.academic_program = academic_program;
    }

    public Periods getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periods periodo) {
        this.periodo = periodo;
    }
}
