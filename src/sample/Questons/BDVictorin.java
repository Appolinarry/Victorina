package sample.Questons;

import java.sql.*;
import java.util.ArrayList;

public class BDVictorin {
    public static ArrayList<Victorin> VictorinLits() { return VictorinLits; }// возвращает значение ArrayList
    public static void setVictorinLits (Victorin victorin){VictorinLits.add(victorin);}// устанавливает ArrayList
    private  static ArrayList<Victorin> VictorinLits = new ArrayList<>();//List для считывания вопросов
    public static Connection victorin; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    //подключение к BDVictorin
    public static void connectionBDVictorin() throws ClassNotFoundException, SQLException {
        victorin = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        victorin = DriverManager.getConnection("jdbc:sqlite:dataVictorin.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
    }
    // cоздание таблицы БД
    public static void newTable() throws ClassNotFoundException, SQLException{
        stab = victorin.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'topicone' ('no' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text, 'gender' text);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Студент существует");
    }

    //закрытие БД
    public static void сloseDB() throws ClassNotFoundException, SQLException
    {
        victorin.close();
        stab.close();
        result.close();
        System.out.println("Соединения закрыты");
    }
}
