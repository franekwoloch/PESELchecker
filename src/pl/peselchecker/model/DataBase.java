package pl.peselchecker.model;

import java.util.ArrayList;

public class DataBase {


    public ArrayList<Pesel> pesels =new ArrayList<Pesel>();
    public ArrayList<String> descriptions = new ArrayList<String>();
    public ArrayList<ArrayList> dataBase=new ArrayList<ArrayList>();


    public DataBase(){
        dataBase.add(0,pesels);
        dataBase.add(1,descriptions);
    }

}
