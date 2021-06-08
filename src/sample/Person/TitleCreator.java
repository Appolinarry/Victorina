package sample.Person;

public class TitleCreator {
    //номер титула
    private int NumberTitle;
    //название темы игры
    private String NameGame;
    //титул
    private String Title;
    //индикатор победы в игре
    private String WinOrNot;
    //конструктор класса
    public TitleCreator(int numberTitle, String nameGame, String title, String winOrNot) {
        NumberTitle = numberTitle;
        NameGame = nameGame;
        Title = title;
        WinOrNot = winOrNot;
    }
    //перезапись toString
    @Override
    public String  toString(){
        return Integer.toString(NumberTitle) + " " + NameGame + " " + Title + " " + " " + WinOrNot;
    }
    //возвращает значение NumberTitle
    public int getNumberTitle() {
        return NumberTitle;
    }
    //устанавливает значение NumberTitle
    public void setNumberTitle(int numberTitle) {
        NumberTitle = numberTitle;
    }
    //возвращает значение NumberTitle
    public String getNameGame() {
        return NameGame;
    }
    //устанавливает значение NumberTitle
    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }
    //возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
    //возвращает значение WinOrNot
    public String getWinOrNot() {
        return WinOrNot;
    }
    //устанавливает значение WinOrNot
    public void setWinOrNot(String winOrNot) {
        WinOrNot = winOrNot;
    }
}
