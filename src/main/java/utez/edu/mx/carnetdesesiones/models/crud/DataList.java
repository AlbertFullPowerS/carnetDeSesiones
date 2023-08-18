package utez.edu.mx.carnetdesesiones.models.crud;

import java.time.LocalDate;
import java.time.LocalTime;

public class DataList {
   private  LocalDate localDate ;
    private LocalTime localTime;

    private String prueba;
    private String prueba1;

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public String getPrueba1() {
        return prueba1;
    }

    public void setPrueba1(String prueba1) {
        this.prueba1 = prueba1;
    }

    public DataList(LocalDate localDate, LocalTime localTime) {
        this.localDate = localDate;
        this.localTime = localTime;
        this.prueba= String.valueOf(localDate);
        this.prueba1= String.valueOf(localTime);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
