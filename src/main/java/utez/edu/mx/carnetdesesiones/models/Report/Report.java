package utez.edu.mx.carnetdesesiones.models.Report;

public class Report {
    private String action;
    private String data;

    private long numero;
    private String tabla;

    public Report(){

    }

    public Report(String action, String data, long numero, String tabla) {
        this.action = action;
        this.data = data;
        this.numero = numero;
        this.tabla = tabla;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
