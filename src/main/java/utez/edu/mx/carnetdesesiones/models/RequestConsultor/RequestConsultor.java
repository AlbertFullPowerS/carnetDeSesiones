package utez.edu.mx.carnetdesesiones.models.RequestConsultor;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;

public class RequestConsultor {
    private long id_request;
    private String reason;
    private long status;
    private Appointment appointment;
    public RequestConsultor(){}
    public RequestConsultor(long id_request, String reason, long status, Appointment appointment) {
        this.id_request = id_request;
        this.reason = reason;
        this.status = status;
        this.appointment = appointment;
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
