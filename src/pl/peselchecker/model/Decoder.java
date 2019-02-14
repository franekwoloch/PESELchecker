package pl.peselchecker.model;

import java.time.LocalDate;

@FunctionalInterface
public interface Decoder {
    //p-pesel number

    InfoPack decode(int[] p){
        private LocalDate birthDate;
        private Sex sex;
        private int sexIndex=p[9]%2;

        private int day;
        day=10*p[5]+p[6];

        private int month;
        month=10*p[3]+p[4];

        private int century=20;

        if (month>20&&month<33){
            month=month-20;
            century=21;
        }

        private int year;
        year=1900+10*p[1]+p[2];

        if (century==21){
            year=year+100;
        }

        birthDate=LocalDate.of(year, month, day);

        if (sexIndex==0){
            sex=Sex.F;
        } else if {
            sex=Sex.M;
        }

        InfoPack infoPack=new InfoPack(p,birthDate,sex);
        return infoPack;
    }
}
