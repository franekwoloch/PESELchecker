package pl.peselchecker.model;

import java.time.LocalDate;

@FunctionalInterface
public interface Decoder {
    //p-pesel number

    InfoPack decode(int[] p){
        private LocalDate birthDate;
        private Sex sex;
        private int sexIndex=p[9]%2;

        if (sexIndex==0){
            sex=Sex.F;
        } else if {
            sex=Sex.M;
        }

    }
}
