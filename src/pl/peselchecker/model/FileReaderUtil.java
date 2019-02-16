package pl.peselchecker.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderUtil {

    public DataBase readFile(File file){

        DataBase newDataBase=new DataBase();

        //Creating temporary DataBase
        String [] tempRecords=new String[1000];
        FileReader fileReader = null;
        BufferedReader reader = null;
        int tempRecordsLength=0;


        //reading file to temporary array
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                tempRecords[lines]=nextLine;
                tempRecordsLength=lines+1;
                lines++;
            }
            System.out.println("Wczytano " + lines+" rekordow");
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

        String tempRecord;
        StringBuilder tempDescription=new StringBuilder("desc: ");
        int [] tempPesel=new int [9];
        int tempCharsIndex=0;

        for (int i=0; i<tempRecordsLength; i++) {
            //record analysis
            tempRecord = tempRecords[i];
            char[] tempCharsArray;
            tempCharsArray = tempRecord.toCharArray();
            int tempCharsLength = tempCharsArray.length; //length of record
            //reading first nine chars
            for (int j = 0; j < 9; j++) {
                tempCharsIndex=j;
                char testChar = tempCharsArray[j];
                if (Character.isDigit(testChar)) {
                    tempPesel[j] = Character.getNumericValue(testChar);
                    if (Character.isSpaceChar(tempCharsArray[j + 1])) {
                        tempCharsIndex = j + 1;
                        break;
                    }
                }
            }
            //check length of Pesel
            int difference;
            if (tempCharsIndex<9) {
                difference=9-tempCharsIndex;
                for (int k=8; k>=difference;k--){
                    tempPesel[k]=tempPesel[k-difference];
            }
            for (int l=0;l<difference;l++){
                    tempPesel[l]=0;
            }
            Pesel peselToSave = new Pesel(tempPesel);

                //save pesel to DataBase
            newDataBase.pesels[i]=peselToSave;
            }
            //description analysis
            for (int m=tempCharsIndex+1;m<tempCharsLength;m++){
                tempDescription=tempDescription.append(tempCharsArray[m]);
            }

            newDataBase.descriptions[i]=tempDescription.toString();

        }
        return newDataBase;
    }
}
