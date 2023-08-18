package utez.edu.mx.carnetdesesiones.models.Session;

import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;

public class Session {

    private long id_session   ;
      private String date_begin ,date_end ,attendance;
      private Consultor consultor;
      private Appointment appointment;

      private String data;
    private String hour;

    public Session(String dataS){
            this.hour = dataS.substring(11,dataS.length()).replaceFirst("^0+", "");;

        this.data = dataS.substring(0,10);



    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public long getId_session() {
        return id_session;
    }

    public void setId_session(long id_session) {
        this.id_session = id_session;
    }

    public String getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(String date_begin) {
        this.date_begin = date_begin;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {

        if (attendance == null)this.attendance = "-";
        else this.attendance = attendance;


    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public Session(){}
    public Session(long id_session, String date_begin, String date_end, String attendance, Consultor consultor, Appointment appointment) {
        this.id_session = id_session;
        this.date_begin = date_begin;
        this.date_end = date_end;
        this.attendance = attendance;
        this.consultor = consultor;
        this.appointment = appointment;
    }
}
