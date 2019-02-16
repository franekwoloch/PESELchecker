package pl.peselchecker.model;

public class Checker {

    //p - pesel number
    boolean check(int [] p){
        int sum;
        double remainder;
        boolean result;
        sum=p[0]+p[1]*3+p[2]*7+p[3]*9+p[4]+p[5]*3+p[6]*7+p[7]*9+p[8]+p[9]*3+p[10];
        remainder=sum%10;
        if (remainder==0){
            result=true;
        } else {
            result= false;
        }

        return result;
    }

}
