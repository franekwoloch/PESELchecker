package pl.peselchecker.model;

public class DataBase {


    public Pesel[] pesels;
    public String[] descriptions;


    public DataBase() {
        pesels = new Pesel[1000];
        descriptions = new String[1000];
        Object [][] DataBase = {pesels, descriptions};

    }

}
