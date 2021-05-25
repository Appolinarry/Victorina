package sample.Databases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bridge {
    private static ObservableList<Person> PersonData = FXCollections.observableArrayList();
    public static ObservableList<Person> getPersonData() {return PersonData; }
    public static void setPersonData(Person person) {PersonData.add(person);}
}
