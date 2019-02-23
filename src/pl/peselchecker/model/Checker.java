package pl.peselchecker.model;

public class Checker {



    //p - pesel number
    public static boolean check(Pesel p){
        int sum;
        double remainder;
        boolean result;
        sum=p.getPeselBean(0)+(p.getPeselBean(1))*3+(p.getPeselBean(2))*7+(p.getPeselBean(3))*9+p.getPeselBean(4);
        sum=sum+(p.getPeselBean(5))*3+(p.getPeselBean(6))*7+(p.getPeselBean(7))*9+p.getPeselBean(8)+(p.getPeselBean(9))*3+p.getPeselBean(10);
        System.out.println("suma:"+sum);
        remainder=sum%10;
        if (remainder==0){
            result=true;
        } else {
            result= false;
        }

        return result;
    }

}
