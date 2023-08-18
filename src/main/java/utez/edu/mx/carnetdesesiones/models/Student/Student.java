package utez.edu.mx.carnetdesesiones.models.Student;

import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.user.User;

public class Student extends User{
    private long id_student;
    private String phone;
    private String status;
    private String enrollment;

    private Group group ;

    private int citas_view , sessiones_view;

    public int getCitas_view() {
        return citas_view;
    }

    public void setCitas_view(int citas_view) {
        this.citas_view = citas_view;
    }

    public int getSessiones_view() {
        return sessiones_view;
    }

    public void setSessiones_view(int sessiones_view) {
        this.sessiones_view = sessiones_view;
    }

    public long getId_student() {
        return id_student;
    }
    public Student(){}
    public Student(  String name,
                   String first_last_name, String second_last_name,
                   long id_student,  String enrollment , Group group ) {
        super(name, first_last_name, second_last_name);
        this.id_student = id_student;
        this.enrollment = enrollment;
        this.group = group;
    }
    public Student(long id_user, String email, String password, String name,
                   String first_last_name, String second_last_name,
                   long id_student, String phone, String status, String enrollment) {
        super(id_user, email, password, name, first_last_name, second_last_name);
        this.id_student = id_student;
        this.phone = phone;
        this.status = status;
        this.enrollment = enrollment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setId_student(long id_student) {
        this.id_student = id_student;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }
}
