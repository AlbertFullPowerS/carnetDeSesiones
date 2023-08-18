package utez.edu.mx.carnetdesesiones.utils.MySQL;


import com.mysql.cj.MysqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    /*
final String HOST = "integradora.cqku2plgaxh8.us-east-1.rds.amazonaws.com",
            PORT = "3306",
            DBNAME = "carnet_sesiones",
            USARNAME = "admin",
            PASSWORD = "12345678",
            TIMEZONE = "America/Mexico_City",
            USESSL = "false",
            PUBLICKEY = "true",
            DDLAUTO = "true";



final String HOST = "127.0.0.1",
            PORT = "3306",
            DBNAME = "carnet_sesiones",
            USARNAME = "root",
            PASSWORD = "25Return09-",
            TIMEZONE = "America/Mexico_City",
            USESSL = "false",
            PUBLICKEY = "true",
            DDLAUTO = "true";



            */

    final String HOST = "44.204.90.59",
            PORT = "3306",
            DBNAME = "carnet_sesiones",
            USARNAME = "admin",
            PASSWORD = "25Marmolejo09-",
            TIMEZONE = "America/Mexico_City",
            USESSL = "false",
            PUBLICKEY = "true",
            DDLAUTO = "true",
            Student = "estudiante",
            Consultor = "consultor",
            Tutor = "tutor";






    public Connection getConnection() {
        String dataSource = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s&serverTimezone=%s " +
                        "&useSSl=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNoExist=%s",
                HOST,PORT,DBNAME,USARNAME,PASSWORD,TIMEZONE,USESSL,PUBLICKEY,DDLAUTO
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public Connection getConnectionStudent() {
        String dataSource = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s&serverTimezone=%s " +
                        "&useSSl=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNoExist=%s",
                HOST,PORT,DBNAME,Student,PASSWORD,TIMEZONE,USESSL,PUBLICKEY,DDLAUTO
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public Connection getConnectionConsultor() {
        String dataSource = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s&serverTimezone=%s " +
                        "&useSSl=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNoExist=%s",
                HOST,PORT,DBNAME,Consultor,PASSWORD,TIMEZONE,USESSL,PUBLICKEY,DDLAUTO
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public Connection getConnectionTutor() {
        String dataSource = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s&serverTimezone=%s " +
                        "&useSSl=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNoExist=%s",
                HOST,PORT,DBNAME,Tutor,PASSWORD,TIMEZONE,USESSL,PUBLICKEY,DDLAUTO
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            Connection conn =new MySQLConnection().getConnectionTutor();
            if(conn != null){
                System.out.printf("Conexión Exitosa!!");
                conn.close();
            }else {
                System.out.println("Error de conexion");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
