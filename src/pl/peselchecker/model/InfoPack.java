package pl.peselchecker.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoPack {
    private int [] peselNumber;
    private LocalDate birthDate;
    private Sex sex;


    public InfoPack(int[] peselNumber) {
        this.peselNumber = peselNumber;
    }
}
