package javaClasses.ht14;

public class Region {
    private int id;
    private int country_id;
    private String name;

    public Region(int id, int country_id, String name) {
        this.id = id;
        this.country_id = country_id;
        this.name = name;
    }

    public Region(int id,  String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
