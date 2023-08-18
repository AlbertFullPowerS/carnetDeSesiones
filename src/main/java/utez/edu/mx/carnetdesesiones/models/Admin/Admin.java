package utez.edu.mx.carnetdesesiones.models.Admin;

import utez.edu.mx.carnetdesesiones.models.user.*;

public class Admin extends  User{
    private long id_admin;



    public long getId_admin() {
        return id_admin;
    }

    public void setId_admin(long id_admin) {
        this.id_admin = id_admin;
    }


    public Admin(){}

    public Admin( long id_user, String email, String password, String name, String first_last_name, String second_last_name, long id_admin) {
        super( id_user, email, password, name, first_last_name, second_last_name);
        this.id_admin = id_admin;
    }
}
