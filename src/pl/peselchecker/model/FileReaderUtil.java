package pl.peselchecker.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileReaderUtil {

    public DataBase readFile(File file){

        DataBase newDataBase=new DataBase();

        //Creating temporary DataBase
        ArrayList<String> tempRecords=new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader reader = null;
        int tempRecordsLength=0;


        //reading file to temporary array
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String nextLine = null;

            while ((nextLine = reader.readLine()) != null) {
                tempRecords.add(nextLine);
            }
            System.out.println("Wczytano " + tempRecords.size()+" rekordow");
            tempRecordsLength=tempRecords.size();
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
        int [] tempPesel=new int [11];
        int tempCharsIndex=0;

        for (int i=0; i<tempRecordsLength; i++) {
            //record analysis
            tempRecord = tempRecords.get(i);
            char[] tempCharsArray;
            tempCharsArray = tempRecord.toCharArray();
            int tempCharsLength = tempCharsArray.length; //length of record
            //reading first nine chars
            for (int j = 0; j < 11; j++) {
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
            if (tempCharsIndex<11) {
                difference=11-tempCharsIndex;
                for (int k=9; k>=difference;k--){
                    tempPesel[k]=tempPesel[k-difference];
                }
                for (int l=0;l<difference;l++){
                    tempPesel[l]=0;
                }
            }

            Pesel peselToSave = new Pesel(tempPesel);

            //save pesel to DataBase
            newDataBase.pesels.add(peselToSave);

            //description analysis
            for (int m=tempCharsIndex+1;m<tempCharsLength;m++){
                tempDescription=tempDescription.append(tempCharsArray[m]);
            }

            newDataBase.descriptions.add(tempDescription.toString());

        }
        System.out.println("First record:"+newDataBase.pesels.get(0).toString());
        return newDataBase;

    }
}
