package pl.peselchecker.model;

public class DataBase {

    Pesel[] pesels = new Pesel[1000];
    String [] descriptions = new String[1000];

    Object [][] DataBase = new Object[2][];
    DataBase[0]=pesels;
    DataBase[1]=descriptions;


}
