package utez.edu.mx.carnetdesesiones.models.Tutor;

import utez.edu.mx.carnetdesesiones.models.user.User;

public class Tutor extends User{
    private long id_tutor;

    private long countGroup;

    public long getCountGroup() {
        return countGroup;
    }

    public void setCountGroup(long countGroup) {
        this.countGroup = countGroup;
    }

    public long getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(long id_tutor) {
        this.id_tutor = id_tutor;
    }

    public Tutor(){}

    public Tutor(long id_user, String email, String password, String name, String first_last_name, String second_last_name, long id_tutor) {
        super( id_user, email, password, name, first_last_name, second_last_name);
        this.id_tutor = id_tutor;
    }
}
