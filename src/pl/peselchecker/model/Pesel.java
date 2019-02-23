package pl.peselchecker.model;

public class Pesel {
    private int [] p=new int[11];


    public Pesel(int[] p) {
        this.p = p;
    }
    public int getPeselBean(int index){
        return p[index];
    }

    @Override
    public String toString(){
        String pesel;
        StringBuilder peselBuilder=new StringBuilder();
        for (int i=0; i<p.length;i++){
            peselBuilder=peselBuilder.append(p[i]);
        }
        pesel=peselBuilder.toString();
        return pesel;
    }
}
