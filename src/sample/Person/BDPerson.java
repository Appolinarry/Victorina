package sample.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class BDPerson {
    private static ObservableList<Gamer> PersonData = FXCollections.observableArrayList();// List для вывода в таблицу
    public static ObservableList<Gamer> getPersonData() {return PersonData; } //возврат содержания списка PersonData
    public static void setPersonData(Gamer person) {PersonData.add(person);} //устанавливает значение PersonData
    public static ArrayList<TitleCreator> getTitleCreator() { return TitleCreator; }// возвращает значение ArrayList
    public static void setTitleCreator (TitleCreator victorin){TitleCreator.add(victorin);}// устанавливает ArrayList
    private  static ArrayList<TitleCreator> TitleCreator = new ArrayList<>();//List для считывания титулов
    public static Connection person; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    //Подключение к БД
    public static void connectionBDPerson() throws ClassNotFoundException, SQLException {
        person = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        person = DriverManager.getConnection("jdbc:sqlite:dataPerson.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
    }
    //Cоздание таблицы БД играющих
    public static void newTablePerson() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'person' ('NumberPerson' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'NameGame' text, 'GameCount' int,'Title' text, 'Comment' text,'LifeCount' int,'OurCount' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
    }
    //Создание таблицы победителей
    public static void newTableWinner() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'winner' ('Number' INTEGER PRIMARY KEY AUTOINCREMENT, 'Nicname' text," +
                " 'Title' text, 'NameGame' text,'GameCount' int, 'FactNumber' int);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
    }
    //Создание таблицы титулов
    public static void newTableWinner1() throws ClassNotFoundException, SQLException{
        stab = person.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'title' ('NumberTitle' INTEGER PRIMARY KEY AUTOINCREMENT, 'NameGame' text," +
                " 'Title' text, 'WinOrNot' text);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
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
    // заполнение таблицы БД winner
    public static void writeDB4() throws SQLException{
        stab.execute("INSERT INTO 'winner' ('Nicname','Title','NameGame','GameCount','FactNumber') " +
                "VALUES ('lolo', 'Молодец', 'Whereistit', 30, 5 ); ");
        stab.execute("INSERT INTO 'winner' ('Nicname','Title','NameGame','GameCount','FactNumber') " +
                "VALUES ('lololo', 'Молодец', 'Whereistit', 32, 4 ); ");
        stab.execute("INSERT INTO 'winner' ('Nicname','Title','NameGame','GameCount','FactNumber') " +
                "VALUES ('lololo', 'Молодец', 'Whereistit', 32, 5 ); ");
    }
    // заполнение таблицы БД winner
    public static void writeDB3() throws SQLException{
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Whereisit', 'Молодец', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Whereisit', 'Красивчик', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Whereisit', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Whereisit', 'Молодец', 'No'); ");
    }
    // вывод данных из таблицы person
    public static void readDB() throws ClassNotFoundException, SQLException {
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
    public static void readDBwinner() throws ClassNotFoundException, SQLException {
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
    public static void readDBTitle(String topic, String YesOrNot) throws ClassNotFoundException, SQLException {
        TitleCreator.clear();
        result = stab.executeQuery("SELECT * FROM title Where NameGame = '"+ topic + "' and WinOrNot = '"+YesOrNot+"'"); //выборки данных с помощью команды SELECT
        while(result.next())//Запись данных из БД в List для таблицы
        {
            TitleCreator titleCreator = new TitleCreator(result.getInt("NumberTitle"),
                    result.getString("NameGame"),
                    result.getString("Title"),result.getString("WinOrNot"));
            TitleCreator.add(titleCreator);
        }
        Collections.shuffle(TitleCreator);
    }
    //Фильтрция из БД
    public  static void SelecName(String Whatisit) throws SQLException {
        PersonData.clear();// Очистка списка
        result = stab.executeQuery("SELECT * FROM 'winner' WHERE Nicname = '"+Whatisit+"'");
        while(result.next()) {
            Winner winner = new Winner(result.getInt("Number"),result.getString("Nicname"),
                    result.getString("Title"),result.getString("NameGame"),
                    result.getInt("GameCount"),result.getInt("FactNumber"));
            PersonData.add(winner);
        }
    }
    //Фильтрция из БД
    public  static void SelecTitle(String Whatisit) throws SQLException {
        TitleCreator.clear();// Очистка списка
        result = stab.executeQuery("select * from title where 'NameGame'="+Whatisit);
        while(result.next()) {
            TitleCreator winner = new TitleCreator(result.getInt("NumberTitle"),result.getString("NameGame"),
                    result.getString("Title"),result.getString("WinOrNot"));
            TitleCreator.add(winner);
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
