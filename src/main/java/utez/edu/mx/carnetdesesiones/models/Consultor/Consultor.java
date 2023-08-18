package utez.edu.mx.carnetdesesiones.models.Consultor;

import utez.edu.mx.carnetdesesiones.models.user.User;

public class Consultor extends User {
    private long id_consultor;

    public long getId_consultor() {
        return id_consultor;
    }

    public void setId_consultor(long id_consultor) {
        this.id_consultor = id_consultor;
    }

    public Consultor(){}
    public Consultor(long id_consultor, String name, String first_last_name, String second_last_name,
                     String email) {
        super( email, name, first_last_name, second_last_name);
        this.id_consultor = id_consultor;
    }
    public Consultor(long id_user, String email, String password, String name, String first_last_name, String second_last_name, long id_consultor) {
        super(id_user, email, password, name, first_last_name, second_last_name);
        this.id_consultor = id_consultor;
    }
}
