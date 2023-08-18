package utez.edu.mx.carnetdesesiones.models.AcademicDivisions;

public class AcademicDivisions {
    private long id_AcademicDivisions;

    private String name ;

    public long getId_AAcademicDivisions() {
        return id_AcademicDivisions;
    }

    public void setId_AAcademicDivisions(long id_AcademicDivisions) {
        this.id_AcademicDivisions = id_AcademicDivisions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AcademicDivisions(long id_AcademicDivisions, String name) {
        this.id_AcademicDivisions = id_AcademicDivisions;
        this.name = name;
    }

    public AcademicDivisions(){}
}
