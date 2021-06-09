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
    //возвращает значение FactContent
    public String getFactContent() {
        return FactContent;
    }
    //возвращает значение FotoFact
    public String getFotoFact() {
        return FotoFact;
    }
}
