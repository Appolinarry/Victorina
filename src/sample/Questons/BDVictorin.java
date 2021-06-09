package sample.Questons;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class BDVictorin {
    // возвращает значение VictorinLits
    public static ArrayList<Victorin> getVictorinLits() {
        return VictorinLits;
    }
    //List для считывания вопросов
    private static ArrayList<Victorin> VictorinLits = new ArrayList<>();
    // возвращает значение FactsLits
    public static ArrayList<Facts> getFactsLits() {
        return FactsLits;
    }
    //List для считывания фактов
    private static ArrayList<Facts> FactsLits = new ArrayList<>();
    //Для соединения с БД необходимо использовать класс Connection пакета java.sql.
    public static Connection victorin;
    //используется для выполнения SQL-запросов
    public static Statement stab;
    //представляет результирующий набор данных и обеспечивает приложению построчный доступ к результатам запросов
    public static ResultSet result;
    //подключение к BDVictorin
    public static void connectionBDVictorin() throws ClassNotFoundException, SQLException {
        victorin = null;
        //("имя движка") вызывает динамическую загрузку класса, org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        Class.forName("org.sqlite.JDBC");
        //("протокол:движок:имя_файла_БД")находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect всегда создает базу данных заранее)
        victorin = DriverManager.getConnection("jdbc:sqlite:dataVictorin.s3db");
    }
    // cоздание таблицы БД с 3 ответами
    public static void newTableVictorin() throws ClassNotFoundException, SQLException {
        //создание экземпляра класса Statement
        stab = victorin.createStatement();
        // позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        stab.execute("CREATE TABLE if not exists 'Victirin' ('NumberQueston' INTEGER PRIMARY KEY AUTOINCREMENT," +
                " 'Queston' text, 'AnswerA' text,'AnswerB' text,'AnswerC' text,'RightAnswer' int,'Count'int," +
                "'NameTopic' text);");    }
    // cоздание таблицы БД с интересными фактами
    public static void newTableFact() throws ClassNotFoundException, SQLException {
        //создание экземпляра класса Statement
        stab = victorin.createStatement();
        // позволяет выполнять различные статичные SQL запросы, используется, когда операторы SQL возвращают более одного набора данных, более одного счетчика обновлений или и то, и другое
        stab.execute("CREATE TABLE if not exists 'Fact' ('Number' INTEGER PRIMARY KEY AUTOINCREMENT," +
                " 'FactContent' text, 'FotoFact' text);");    }
    // вывод части данных из таблицы по заданной теме
    public static void readDBQueston(String topic) throws ClassNotFoundException, SQLException {
        //очищаем список
        VictorinLits.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM Victirin where NameTopic = '" + topic + "'");
        //Запись данных из БД в List
        while(result.next()) {
            //создаем объект с значениями извлеченными из таблицы
            Victorin tipicalQueston =new Victorin(result.getInt("NumberQueston"),
                    result.getString("Queston"),result.getString("AnswerA"),
                    result.getString("AnswerB"),result.getString("AnswerC"),
                    result.getInt("RightAnswer"),result.getInt("Count"),
                    result.getString("NameTopic"));
            //добавляем значение в спикок
            VictorinLits.add(tipicalQueston);
        }
        //перемшивает коллекцию значений
        Collections.shuffle(VictorinLits);
    }
    //Вывод фактов из таблицы
    public static void readFact() throws ClassNotFoundException, SQLException {
        //очищает список
        FactsLits.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM Fact");
        //Запись данных из БД в List
        while(result.next()) {
            //создаем объект с значениями извлеченными из таблицы
            Facts facts = new Facts(result.getInt("Number"),
                    result.getString("FactContent"), result.getString("FotoFact"));
            //добавляем значение в спикок
            FactsLits.add(facts);
        }
        //перемшивает коллекцию значений
        Collections.shuffle(FactsLits);
    }
}
