package sample.Questons;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class BDVictorin {
    public static ArrayList<Victorin> VictorinLits() { return VictorinLits; }// возвращает значение ArrayList
    public static void setVictorinLits (Victorin victorin){VictorinLits.add(victorin);}// устанавливает ArrayList
    private  static ArrayList<Victorin> VictorinLits = new ArrayList<>();//List для считывания вопросов
    public static ArrayList<Facts> getFactsLits() { return FactsLits; }// возвращает значение ArrayList
    public static void setFactsLits (Facts facts){FactsLits.add(facts);}// устанавливает ArrayList
    private  static ArrayList<Facts> FactsLits = new ArrayList<>();//List для считывания фактов
    public static Connection victorin; //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Statement stab; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    //подключение к BDVictorin
    public static void connectionBDVictorin() throws ClassNotFoundException, SQLException {
        victorin = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        victorin = DriverManager.getConnection("jdbc:sqlite:dataVictorin.s3db"); //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
    }
    // cоздание таблицы БД с 3 ответами
    public static void newTable1() throws ClassNotFoundException, SQLException{
        stab = victorin.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'typicalqueston' ('NumberQueston' INTEGER PRIMARY KEY AUTOINCREMENT," +
                " 'Queston' text, 'AnswerA' text,'AnswerB' text,'AnswerC' text,'RightAnswer' text,'Count'int," +
                "'NameTopic' text, 'FotoName' text);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Студент1 существует");
    }
    // cоздание таблицы БД с 4 ответами
    public static void newTable2() throws ClassNotFoundException, SQLException{
        stab = victorin.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'untypicalqueston' ('NumberQueston' INTEGER PRIMARY KEY AUTOINCREMENT," +
                " 'Queston' text, 'AnswerA' text,'AnswerB' text,'AnswerC' text,'AnswerD' text,'RightAnswer' text,'Count'int," +
                "'NameTopic' text,'FotoName' text);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Студент2 существует");
    }
    // cоздание таблицы БД с интересными фактами
    public static void newTable3() throws ClassNotFoundException, SQLException{
        stab = victorin.createStatement();//создание экземпляра класса Statement
        stab.execute("CREATE TABLE if not exists 'Fact' ('Number' INTEGER PRIMARY KEY AUTOINCREMENT," +
                " 'FactContent' text, 'FotoFact' text);");// позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        System.out.println("Таблица Студент3 существует");
    }
    // заполнение таблицы БД с 3 вариантами ответов
    public static void writeDB1() throws SQLException{
        stab.execute("INSERT INTO 'typicalqueston' ('Queston','AnswerA','AnswerB','AnswerC','RightAnswer'" +
                " ,'Count','NameTopic','FotoName') VALUES ('', '','', '', '','','',''); ");
        System.out.println("Таблица заполнена");
    }
    // заполнение таблицы БД вопросом с 4 вариантами ответов
    public static void writeDB2() throws SQLException{
        stab.execute("INSERT INTO 'untypicalqueston' ('Queston','AnswerA','AnswerB','AnswerC'," +
                "'AnswerD','RightAnswer','Count','NameTopic','FotoName') VALUES ('', '','', '', '','','','',''); ");
        System.out.println("Таблица заполнена");
    }
    //Заполнение таблицы БД с фактами
    public static void writeDB3() throws SQLException{
        stab.execute("INSERT INTO 'Fact' ('Number','FactContent','FotoFact') VALUES ('', '', ''); ");
        System.out.println("Таблица заполнена");
    }
    // вывод всех данных из таблицы
    public static void readDB0() throws ClassNotFoundException, SQLException {
        result = stab.executeQuery("SELECT * FROM typicalqueston"); //выборки данных с помощью команды SELECT
        while(result.next()) {
            TipicalQueston tipicalQueston =new TipicalQueston(result.getInt("NumberQueston"),
                    result.getString("Queston"),result.getString("AnswerA"),
                    result.getString("AnswerB"),result.getString("AnswerC"),
                    result.getString("RightAnswer"),result.getInt("Count"),
                    result.getString("NameTopic"),result.getString("FotoName"));
            VictorinLits.add(tipicalQueston);
        }
        result = stab.executeQuery("SELECT * FROM untypicalqueston"); //выборки данных с помощью команды SELECT
        while(result.next()) {
            SomeUntipicalQueston untipicalQueston =new SomeUntipicalQueston(result.getInt("NumberQueston"),
                    result.getString("Queston"),result.getString("AnswerA"),
                    result.getString("AnswerB"),result.getString("AnswerC"),
                    result.getString("AnswerD"),result.getString("RightAnswer"),
                    result.getInt("Count"),result.getString("NameTopic"),
                    result.getString("FotoName"));
            VictorinLits.add(untipicalQueston);
        }
        Collections.shuffle(VictorinLits);
        System.out.println("Таблица выгружена");
        for (int i=0;i<VictorinLits.size();i++){
            System.out.println(VictorinLits.get(i).toString());
        }
    }
    // вывод части данных из таблицы
    public static void readDB1(String topic) throws ClassNotFoundException, SQLException {
        result = stab.executeQuery("SELECT * FROM typicalqueston where 'NameTopic' = '" + topic + "'"); //выборки данных с помощью команды SELECT
        while(result.next()) {
            TipicalQueston tipicalQueston =new TipicalQueston(result.getInt("NumberQueston"),
                    result.getString("Queston"),result.getString("AnswerA"),
                    result.getString("AnswerB"),result.getString("AnswerC"),
                    result.getString("RightAnswer"),result.getInt("Count"),
                    result.getString("NameTopic"),result.getString("FotoName"));
            VictorinLits.add(tipicalQueston);
        }
        result = stab.executeQuery("SELECT * FROM untypicalqueston where 'NameTopic' = '\" + topic + \"'\""); //выборки данных с помощью команды SELECT
        while(result.next()) {
            SomeUntipicalQueston untipicalQueston =new SomeUntipicalQueston(result.getInt("NumberQueston"),
                    result.getString("Queston"),result.getString("AnswerA"),
                    result.getString("AnswerB"),result.getString("AnswerC"),
                    result.getString("AnswerD"),result.getString("RightAnswer"),
                    result.getInt("Count"),result.getString("NameTopic"),
                    result.getString("FotoName"));
            VictorinLits.add(untipicalQueston);
        }
        Collections.shuffle(VictorinLits);
        System.out.println("Таблица выгружена");
        for (int i=0;i<VictorinLits.size();i++){
            System.out.println(VictorinLits.get(i).toString());
        }
    }
    //Вывод фактов из таблицы
    public static void readDB2(int topic) throws ClassNotFoundException, SQLException {
        result = stab.executeQuery("SELECT * FROM Fact where 'Number' = '" + topic + "'"); //выборки данных с помощью команды SELECT
        while(result.next()) {
            Facts facts = new Facts(result.getInt("Number"),
                    result.getString("FactContent"), result.getString("FotoFact"));
            FactsLits.add(facts);
        }
        System.out.println("Таблица выгружена");
        for (int i=0;i<VictorinLits.size();i++){
            System.out.println(VictorinLits.get(i).toString());
        }
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
