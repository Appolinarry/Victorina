package sample.Person;

public class TitleCreator {
    private int NumberTitle;
    private String NameGame;
    private String Title;
    private String WinOrNot;

    public TitleCreator(int numberTitle, String nameGame, String title, String winOrNot) {
        NumberTitle = numberTitle;
        NameGame = nameGame;
        Title = title;
        WinOrNot = winOrNot;
    }
    @Override
    public String  toString(){
        return Integer.toString(NumberTitle) + " " + NameGame + " " + Title + " " + " " + WinOrNot;
    }

    public int getNumberTitle() {
        return NumberTitle;
    }

    public void setNumberTitle(int numberTitle) {
        NumberTitle = numberTitle;
    }

    public String getNameGame() {
        return NameGame;
    }

    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getWinOrNot() {
        return WinOrNot;
    }

    public void setWinOrNot(String winOrNot) {
        WinOrNot = winOrNot;
    }
}
