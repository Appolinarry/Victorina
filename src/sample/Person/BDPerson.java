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
    //устанавливает значение PersonData
    public static void setPersonData(Gamer person) {PersonData.add(person);}
    // возвращает значение ArrayList
    public static ArrayList<TitleCreator> getTitleCreator() { return TitleCreator; }
    // устанавливает ArrayList
    public static void setTitleCreator (TitleCreator victorin){TitleCreator.add(victorin);}
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
    // заполнение таблицы БД title
    public static void writeDB3() throws SQLException{
        //заполнение таблицы титулов
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Знаток рыбок', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Рыбный умник', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Юный ихтиолог', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Друг рыбок', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Пробирающийся к рыбкам', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Рыбки', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Червячки', 'Друг червей', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Червячки', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Червячки', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Червячки', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Червячки', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Друг паучков', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Юный арахнолог', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Паучкообразные', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Друг деревьев', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Юный биолог', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Деревья', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Друг птичек', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Юный орнитолог', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Птички', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Знаток истории', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Друг Магеллана', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Географические открытия', 'Попавший в бурю', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Знаток истории', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Друг Самоделкина', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Изобретения 20 века', 'Запутавшийся в фактах', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Бывалый путешественник', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Проложивший свой маршрут', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Заплутавший в пути', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('А где город?', 'Бывалый путешественник', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Юный асторонм', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Звездочки', 'Заплутавший в звездах', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Юный физик', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Излучение', 'Заплутавший волнах', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Юный асторонм', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Галактики', 'Заплутавший в черную дыру', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Анотомия', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Анотомия', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Анотомия', 'Юный анатом', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Анотомия', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Анотомия', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Химия', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Химия', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Химия', 'Юный химимк', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Химия', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Химия', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Юный географ', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Потытка не пытка', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('География', 'Товарищ Жака Паганеля', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Обществознание', 'Молодчинка', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Обществознание', 'Умница', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Обществознание', 'Юный обществовед', 'Yes'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Обществознание', 'Начинающий знаток', 'No'); ");
        stab.execute("INSERT INTO 'title' ('NameGame','Title','WinOrNot') VALUES ('Обществознание', 'Потытка не пытка', 'No'); ");
    }
    // вывод данных из таблицы person
    public static void readDB() throws ClassNotFoundException, SQLException {
        // Очистка списка
        PersonData.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM person");
        //Запись данных из БД в List
        while(result.next())
        {
            //выборки данных с помощью команды SELECT
            Person person1 = new Person(result.getInt("NumberPerson"),result.getString("Nicname"),
                    result.getString("NameGame"),result.getInt("GameCount"),
                    result.getString("Title"),result.getInt("LifeCount"),
                    result.getInt("OurCount"),result.getString("Comment"));
            //заполнение списка
            PersonData.add(person1);
        }
    }
    //Вывод данных из таблицы winner
    public static void readDBwinner() throws ClassNotFoundException, SQLException {
        // Очистка списка
        PersonData.clear();
        //выборки данных с помощью команды SELECT
        result = stab.executeQuery("SELECT * FROM winner");
        //Запись данных из БД в List
        while(result.next())
        {
            //выборки данных с помощью команды SELECT
            Winner winner = new Winner(result.getInt("Number"),result.getString("Nicname"),
                    result.getString("Title"),result.getString("NameGame"),
                    result.getInt("GameCount"),result.getInt("FactNumber"));
            //заполнение списка
            PersonData.add(winner);
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
