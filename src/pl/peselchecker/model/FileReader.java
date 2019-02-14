package pl.peselchecker.model;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileReader {

    DataBase readFile(String path, String fileName){


        String [] templines=new String[1000];
        FileReader fileReader = null;
        BufferedReader reader = null;

        //reading file to temporary array
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                templines[lines]=nextLine;
                lines++;
            }
            System.out.println("Wczytano" + lines+"rekordow");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int [] tempPesel=int [9];
        int peselIndex=0;
        char [] tempChars;
        int tempCharsIndex=0;
        String desc;
        String tempDesc;

        for (int i=0; i<1000; i++){
            tempDesc=templines[i];
            tempChars=tempDesc.toCharArray();
            int tempCharsLength=tempChars.length;
                for (int j=0; j<9;j++){
                    tempCharsIndex=j;
                    char testChar =tempChars[j];
                    if (Character.isDigit(testChar)){
                        tempPesel[peselIndex]=(int)tempChars;
                            if (Character.isSpaceChar(tempChars[j+1])){
                                tempCharsIndex=j+1;
                                break;
                            }
                    }
                }

                for (int k=tempCharsIndex; k<tempCharsLength;k++){

                }



        }




    }
}
