package sample.Databases;

public class Person {
    private int NumberPerson;
    private String Nicname;
    private String NameGame;
    private int GameCount;

    public Person(int numberPerson, String nicname, String nameGame, int gameCount) {
        NumberPerson = numberPerson;
        Nicname = nicname;
        NameGame = nameGame;
        GameCount = gameCount;
    }

    @Override
    public String  toString(){

        return Integer.toString(NumberPerson)+" "+Nicname+" "+ NameGame+" "+Integer.toString(GameCount)+"\n";
    }

    public int getNumberPerson() {
        return NumberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        NumberPerson = numberPerson;
    }

    public String getNicname() {
        return Nicname;
    }

    public void setNicname(String nicname) {
        Nicname = nicname;
    }

    public String getNameGame() {return NameGame; }

    public void setNameGame(String nameGame) {NameGame = nameGame; }

    public int getGameCount() {return GameCount; }

    public void setGameCount(int gameCount) {GameCount = gameCount; }
}
