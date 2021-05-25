package sample.Databases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BDPerson {
    private ObservableList<Person> PersonData = FXCollections.observableArrayList();
    public static Connection person; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    public static void connectionBDPerson() throws ClassNotFoundException, SQLException {
        person = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        person = DriverManager.getConnection("jdbc:sqlite:dataPerson.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
        System.out.println("БД подключена!");
    }
    public static void newTable() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'person' ('NumberPerson' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text, 'NameGame' text, 'GameCount' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Студент существует");
    }
    // заполнение таблицы БД
    public static void writeDBPerson(String Nicname, String NameGame,int GameCount) throws SQLException{
        stab.execute("INSERT INTO 'person' ('Nicname','NameGame','GameCount') VALUES ('"+Nicname+"', '"+NameGame+"',"+GameCount+"); ");
    }
    public static void readDB() throws ClassNotFoundException, SQLException {
        Bridge.getPersonData().clear();
        result = stab.executeQuery("SELECT * FROM person"); //выборки данных с помощью команды SELECT
        while(result.next()) {
            Person person1 = new Person(result.getInt("NumberPerson"),result.getString("Nicname"),
                    result.getString("NameGame"),result.getInt("GameCount"));
            Bridge.setPersonData(person1);
        }
        for (int i = 0; i< Bridge.getPersonData().size(); i++){
            System.out.println(Bridge.getPersonData().get(i).toString());
        }
    }
    public static void сloseDB() throws ClassNotFoundException, SQLException
    {
        person.close();
        stab.close();
        result.close();
        System.out.println("Соединения закрыты");
    }
}
