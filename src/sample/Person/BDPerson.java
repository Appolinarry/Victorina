package sample.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BDPerson {
    private static ObservableList<Person> PersonData = FXCollections.observableArrayList();// List для вывода в таблицу
    public static ObservableList<Person> getPersonData() {return PersonData; } //возврат содержания списка PersonData
    public static void setPersonData(Person person) {PersonData.add(person);} //устанавливает значение PersonData
    public static Connection person; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    //Подключение к БД
    public static void connectionBDPerson() throws ClassNotFoundException, SQLException {
        person = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        person = DriverManager.getConnection("jdbc:sqlite:dataPerson.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
        System.out.println("БД подключена!");
    }
    //Cоздание таблицы БД
    public static void newTable() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'person' ('no' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'NameGame' text, 'GameCount' int,'Title' text, 'Comment' text,'LifeCount' int,'OurCount' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Person существует");
    }
    // заполнение таблицы БД
    public static void writeDB(String nic, String game, int count, String title, String com, int life, int ourcount) throws SQLException{
        stab.execute("INSERT INTO 'person' ('Nicname','NameGame','GameCount','Title','Comment','LifeCount','OurCount') " +
                "VALUES ('" + nic + "', '" + game + "', " + count + ", '"+ title + "', '" + com + "', " + life + ", " + ourcount + " ); ");
        System.out.println("Таблица заполнена");
    }
    // вывод данных из таблицы
    public static void readDB() throws ClassNotFoundException, SQLException
    {
        result = stab.executeQuery("SELECT * FROM person"); //выборки данных с помощью команды SELECT
        while(result.next())
        {
            Person person1 = new Person(result.getInt("NumberPerson"),result.getString("Nicname"),
                    result.getString("NameGame"),result.getInt("GameCount"),
                    result.getString("Title"),result.getString("Comment"),
                    result.getInt("LifeCount"),result.getInt("OurCount"));
            PersonData.add(person1);
        }
        System.out.println("Таблица выгружена");
        for (int i=0;i<PersonData.size();i++){
            System.out.println(PersonData.get(i).toString());
        }
    }
    //закрытие БД
    public static void сloseDB() throws ClassNotFoundException, SQLException
    {
        person.close();
        stab.close();
        result.close();
        System.out.println("Соединения закрыты");
    }
}
