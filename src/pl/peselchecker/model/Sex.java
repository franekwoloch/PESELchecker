package pl.peselchecker.model;

public enum Sex {
    F ("Female"),
    M ("Male");

    private final String description;

    private Sex (String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
