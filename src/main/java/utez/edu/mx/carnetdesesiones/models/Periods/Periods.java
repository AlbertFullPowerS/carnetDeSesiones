package utez.edu.mx.carnetdesesiones.models.Periods;

public class Periods {

    private long id_Periods;

    private String name ;
    private String dateBegin ;
    private String dateEnd ;

    private int count ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Periods(){}
    public Periods(long id_Periods, String name, String dateBegin, String dateEnd) {
        this.id_Periods = id_Periods;
        this.name = name;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public long getId_Periods() {
        return id_Periods;
    }

    public void setId_Periods(long id_Periods) {
        this.id_Periods = id_Periods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
