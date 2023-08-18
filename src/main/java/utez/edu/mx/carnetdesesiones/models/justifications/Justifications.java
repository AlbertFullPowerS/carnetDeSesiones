package utez.edu.mx.carnetdesesiones.models.justifications;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.user.User;

public class Justifications {
    private long id_justification;
    private String reason;
    private String date;
    private Session session;

    private long status;
    private User user;

    public Justifications(long id_justification, String reason, String date, Session session, long status, User user) {
        this.id_justification = id_justification;
        this.reason = reason;
        this.date = date;
        this.session = session;
        this.status = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Justifications(){}



    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public long getId_justification() {
        return id_justification;
    }

    public void setId_justification(long id_justification) {
        this.id_justification = id_justification;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
