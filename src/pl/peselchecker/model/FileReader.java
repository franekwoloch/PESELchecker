package pl.peselchecker.model;

import jdk.nashorn.internal.parser.Scanner;

@FunctionalInterface
public interface FileReader {

    DataBase readFile(String path, String fileName){
        Scanner scanner=new Scanner(fileName);
        
    }
}
