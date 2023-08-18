package utez.edu.mx.carnetdesesiones.models.crud;

import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.Periods.Periods;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Value {
    private String Card;
    private String Camp;

    private String valueView;
    private String Campv2;

    private ArrayList<DataList> dataList = new ArrayList<>() ;

    public ArrayList<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<DataList> dataList) {
        this.dataList = dataList;
    }

    private String idU;
    private String attr;
    private String data;

    public Value(String idU, String attr, String data) {
        this.idU = idU;
        this.attr = attr;
        this.data = data;
    }
    public Value(LocalDate localDate , LocalTime localTime) {


        for (int i = 0 ; i < 6 ; i++)
            {

                DataList dataListitem = new DataList(localDate.plusWeeks(i),localTime);
                this.dataList.add(dataListitem);

            }
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValueView() {
        return valueView;
    }

    public void setValueView(String valueView) {
        this.valueView = valueView;
    }

    public String getCampv2() {
        return Campv2;
    }

    public void setCampv2(String campv2) {
        Campv2 = campv2;
    }
    public Value (String Card, String Camp, Periods periods) {
        this.Card = Card;
        this.Camp = Camp;
        switch (Camp){
            case "Nombre":
                this.Campv2="name";
                this.valueView = periods.getName();
                break;
            case "Fecha de inicio":
                this.Campv2="date_begin";
                this.valueView = periods.getDateBegin();
                break;
            case "Fecha de fin":
                this.Campv2="date_end";
                this.valueView = periods.getDateEnd();
                break;
        }
    }
    public Value (String Card, String Camp, Group group) {
        this.Card = Card;
        this.Camp = Camp;
        switch (Camp){
            case "Grupo":
                this.Campv2="group";
                    this.valueView = group.getGroup();
                break;
            case "Grado":
                this.Campv2="grade";
                this.valueView = group.getGrade();
                break;
            case "Programa Academico":
                this.Campv2="fk_academic_program";
                this.valueView = "academic";
                break;
            case "Periodo":
                this.Campv2="fk_period";
                this.valueView = "periods";
                break;
            case "Tutor":
                this.Campv2="fk_tutor";
                this.valueView ="tutor";
                break;
        }
    }
    public Value (String Card, String Camp, User user) {
        this.Card = Card;
        this.Camp = Camp;
        switch (Camp){
            case "Nombre":
                this.Campv2="name";
                this.valueView = user.getName();
                break;
            case "Teléfono":
                this.Campv2="phone_number";
                this.valueView = user.getName();
                break;
            case "Apellido Paterno":
                this.Campv2="first_last_name";
                this.valueView = user.getFirst_last_name();
                break;
            case "Apellido Materno":
                this.Campv2="second_last_name";
                this.valueView = user.getSecond_last_name();
                break;
            case "Email":
                this.Campv2="email";
                this.valueView = user.getEmail();
                break;
            case "Contrasela":
                this.Campv2="password";

                break;
            case "Grupos":
                this.Campv2="viewGroups";
                break;
            case "Grupo":
                this.Campv2="fk_group";
                break;
            case "Estado":
                this.Campv2="status";
                Student student = (Student) user;
                this.valueView = student.getStatus();
                break;
            case "Matrícula":
                this.Campv2="enrollment";
                Student studen = (Student) user;
                this.valueView = studen.getEnrollment();
                break;

        }

    }
    public Value(){

    }


    public String getCard() {
        return Card;
    }

    public void setCard(String Card) {
        this.Card = Card;
    }

    public String getCamp() {
        return Camp;
    }

    public void setCamp(String Camp) {
        this.Camp = Camp;
    }
}
