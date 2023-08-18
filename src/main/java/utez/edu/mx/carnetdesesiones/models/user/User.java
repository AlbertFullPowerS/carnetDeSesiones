package utez.edu.mx.carnetdesesiones.models.user;

import java.util.ArrayList;

public class User {

    private long id_user;
    private String email;
    private String password;
    private String name;
    private String first_last_name;
    private String second_last_name;

    public User(){}

    public User( long id_user, String email, String password, String name, String first_last_name, String second_last_name) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.name = name;
        this.first_last_name = first_last_name;
        this.second_last_name = second_last_name;

    }

    public User(String name, String first_last_name, String second_last_name) {
        this.name = name;
        this.first_last_name = first_last_name;
        this.second_last_name = second_last_name;
    }

    public User(String email, String name, String first_last_name, String second_last_name) {
        this.email = email;
        this.first_last_name = first_last_name;
        this.name = name;
        this.second_last_name = second_last_name;
    }


    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }
}
