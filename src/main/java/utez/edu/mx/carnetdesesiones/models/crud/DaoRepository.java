package utez.edu.mx.carnetdesesiones.models.crud;

import java.util.List;

public interface DaoRepository<T>{
    List<T> findAll();
    /*Se trae todos los objetos en un listado */

    T findOne(long id);


    boolean save(T object);
    boolean update(T object);

    boolean updateOne(Value object);

    boolean delate(long id);



}
