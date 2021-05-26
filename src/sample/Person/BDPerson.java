package sample.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BDPerson {
    private static ObservableList<Gamer> PersonData = FXCollections.observableArrayList();// List для вывода в таблицу
    public static ObservableList<Gamer> getPersonData() {return PersonData; } //возврат содержания списка PersonData
    public static void setPersonData(Gamer person) {PersonData.add(person);} //устанавливает значение PersonData
    public static Connection person; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    //Подключение к БД
    public static void connectionBDPerson() throws ClassNotFoundException, SQLException {
        person = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        person = DriverManager.getConnection("jdbc:sqlite:dataPerson.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
    }
    //Cоздание таблицы БД
    public static void newTablePerson() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'person' ('NumberPerson' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'NameGame' text, 'GameCount' int,'Title' text, 'Comment' text,'LifeCount' int,'OurCount' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
    }
    public static void newTableWinner() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'winner' ('Number' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'Title' text, 'NameGame' text,'GameCount' int, 'FactNumber' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
    }
    // заполнение таблицы БД person
    public static void writeDB(String nic, String game, int count, String title, String com, int life, int ourcount) throws SQLException{
        stab.execute("INSERT INTO 'person' ('Nicname','NameGame','GameCount','Title','Comment','LifeCount','OurCount') " +
                "VALUES ('" + nic + "', '" + game + "', " + count + ", '"+ title + "', '" + com + "', " + life + ", " + ourcount + " ); ");
    }
    // заполнение таблицы БД winner
    public static void writeDB2(String nic, String title,String game,int count, int fact) throws SQLException{
        stab.execute("INSERT INTO 'winner' ('Nicname','Title','NameGame','GameCount','FactNumber') " +
                "VALUES ('" + nic + "', '" + title + "', '" + game + "', "+ count + ", " + fact + " ); ");
    }
    // вывод данных из таблицы person
    public static void readDB() throws ClassNotFoundException, SQLException
    {
        PersonData.clear();// Очистка списка
        result = stab.executeQuery("SELECT * FROM person"); //выборки данных с помощью команды SELECT
        while(result.next())//Запись данных из БД в List для таблицы
        {
            Person person1 = new Person(result.getInt("NumberPerson"),result.getString("Nicname"),
                    result.getString("NameGame"),result.getInt("GameCount"),
                    result.getString("Title"),result.getInt("LifeCount"),
                    result.getInt("OurCount"),result.getString("Comment"));
            PersonData.add(person1);
        }
    }
    //Вывод данных из таблицы winner
    public static void readDBwinner() throws ClassNotFoundException, SQLException
    {
        PersonData.clear();// Очистка списка
        result = stab.executeQuery("SELECT * FROM winner"); //выборки данных с помощью команды SELECT
        while(result.next())//Запись данных из БД в List для таблицы
        {
            Winner winner = new Winner(result.getInt("Number"),result.getString("Nicname"),
                    result.getString("Title"),result.getString("NameGame"),
                    result.getInt("GameCount"),result.getInt("FactNumber"));
            PersonData.add(winner);
        }
    }
    //закрытие БД
    public static void сloseDB() throws ClassNotFoundException, SQLException
    {
        person.close();
        stab.close();
        result.close();
    }
}
