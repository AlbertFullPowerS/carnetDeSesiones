package utez.edu.mx.carnetdesesiones.models.Appoinment;

import utez.edu.mx.carnetdesesiones.models.Student.Student;

public class Appointment {

    private long id_appointment;
     private Student student;
     private  String place , status;

    public long getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(long id_appointment) {
        this.id_appointment = id_appointment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Appointment(){}
    public Appointment(long id_appointment, Student student, String place, String status) {
        this.id_appointment = id_appointment;
        this.student = student;
        this.place = place;
        this.status = status;
    }
}
