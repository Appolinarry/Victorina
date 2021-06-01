package sample.Questons;

public class Facts {
    private int Number;//номер факта
    private String FactContent;//содержание факта
    private String FotoFact;//картинка к нему
    //конструктор класса Facts
    public Facts(int number, String factContent, String fotoFact) {
        Number = number;
        FactContent = factContent;
        FotoFact = fotoFact;
    }
    // перезапись метода toString
    @Override
    public String  toString(){
        return FactContent;
    }
    //возвращает значение Number
    public int getNumber() {
        return Number;
    }
    //устанавливает значение Number
    public void setNumber(int number) {
        Number = number;
    }
    //возвращает значение FactContent
    public String getFactContent() {
        return FactContent;
    }
    //устанавливает значение FactContent
    public void setFactContent(String factContent) {
        FactContent = factContent;
    }
    //возвращает значение FotoFact
    public String getFotoFact() {
        return FotoFact;
    }
    //устанавливает значение FotoFact
    public void setFotoFact(String fotoFact) {
        FotoFact = fotoFact;
    }
}
