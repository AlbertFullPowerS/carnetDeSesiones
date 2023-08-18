package utez.edu.mx.carnetdesesiones.models.RequestStudents;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.user.User;

public class RequestStudents {
    private long id_request;
    private String reason;
    private long status;
    private Appointment appointment;
    private User user;
    private String typeUser;
    public RequestStudents(){}
    public RequestStudents(long id_request, String reason, long status, Appointment appointment) {
        this.id_request = id_request;
        this.reason = reason;
        this.status = status;
        this.appointment = appointment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public long getId_request() {
        return id_request;
    }

    public void setId_request(long id_request) {
        this.id_request = id_request;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
