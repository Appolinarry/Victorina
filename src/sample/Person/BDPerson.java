package sample.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class BDPerson {
    // List для вывода в таблицу
    private static ObservableList<Gamer> PersonData = FXCollections.observableArrayList();
    //возврат содержания списка PersonData
    public static ObservableList<Gamer> getPersonData() {return PersonData; }
    // возвращает значение ArrayList
    public static ArrayList<TitleCreator> getTitleCreator() { return TitleCreator; }
    //List для считывания титулов
    private  static ArrayList<TitleCreator> TitleCreator = new ArrayList<>();
    //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Connection person;
    //используется для выполнения SQL-запросов
    public static Statement stab;
    //представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    public static ResultSet result;
    //Подключение к БД
    public static void connectionBDPerson() throws ClassNotFoundException, SQLException {
        person = null;
        //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        Class.forName("org.sqlite.JDBC");
        person = DriverManager.getConnection("jdbc:sqlite:dataPerson.s3db");
        //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
    }
    //Cоздание таблицы БД игроков
    public static void newTablePerson() throws ClassNotFoundException, SQLException{
        //создание экземпляра класса Statement
        stab = person.createStatement();
        // позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        stab.execute("CREATE TABLE if not exists 'person' ('NumberPerson' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'NameGame' text, 'GameCount' int,'Title' text, 'Comment' text,'LifeCount' int,'OurCount' int);");   }
    //Создание таблицы победителей
    public static void newTableWinner() throws ClassNotFoundException, SQLException{
        //создание экземпляра класса Statement
        stab = person.createStatement();
        // позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        stab.execute("CREATE TABLE if not exists 'winner' ('Number' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'Title' text, 'NameGame' text,'GameCount' int, 'FactNumber' int);");    }
    //Создание таблицы титулов
    public static void newTableTitle() throws ClassNotFoundException, SQLException{
        //создание экземпляра класса Statement
        stab = person.createStatement();
        // позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        stab.execute("CREATE TABLE if not exists 'title' ('NumberTitle' INTEGER PRIMARY KEY AUTOINCREMENT, 'NameGame' text," +
                " 'Title' text, 'WinOrNot' text);");    }
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
    public static void readDB() throws ClassNotFoundException, SQLException {
        // Очистка списка
        PersonData.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM person");
        //Запись данных из БД в List
        while(result.next()) {
            //выборки данных с помощью команды SELECT
            Person person1 = new Person(result.getInt("NumberPerson"),result.getString("Nicname"),
                    result.getString("NameGame"),result.getInt("GameCount"),
                    result.getString("Title"),result.getInt("LifeCount"),
                    result.getInt("OurCount"),result.getString("Comment"));
            //заполнение списка
            PersonData.add(person1);
        }
    }
    //чтение титула из таблицы по заданным входящим параметрам
    public static void readDBTitle(String topic, String YesOrNot) throws ClassNotFoundException, SQLException {
        //очищение списка титулов
        TitleCreator.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM title Where NameGame = '"+ topic + "' and WinOrNot = '"+YesOrNot+"'");
        //Запись данных из БД в List
        while(result.next())
        {
            //создание экемпляра с заданным из таблицы параметрам
            TitleCreator titleCreator = new TitleCreator(result.getInt("NumberTitle"),
                    result.getString("NameGame"),
                    result.getString("Title"),result.getString("WinOrNot"));
            //заполнение списка
            TitleCreator.add(titleCreator);
        }
        //перемешивание списка
        Collections.shuffle(TitleCreator);
    }
    //Фильтрция из БД
    public  static void SelecName(String Whatisit) throws SQLException {
        // Очистка списка
        PersonData.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM 'winner' WHERE Nicname = '"+Whatisit+"'");
        //Запись данных из БД в List
        while(result.next()) {
            //создание экемпляра с заданным из таблицы параметрам
            Winner winner = new Winner(result.getInt("Number"),result.getString("Nicname"),
                    result.getString("Title"),result.getString("NameGame"),
                    result.getInt("GameCount"),result.getInt("FactNumber"));
            //заполнение списка
            PersonData.add(winner);
        }
    }
}
