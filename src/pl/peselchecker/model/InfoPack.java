package pl.peselchecker.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoPack {
    private int [] peselNumber;
    private LocalDate birthDate;
    private Sex sex;
    private String desc;


    public InfoPack(int[] peselNumber, LocalDate birthDate, Sex sex) {
        this.peselNumber = peselNumber;
        this.birthDate = birthDate;
        this.sex = sex;
    }
}
