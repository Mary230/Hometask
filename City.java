package javaClasses.ht14;

public class City {
    public int country_id;
    public int city_id;

    public String name;

    public City(int country_id,int city_id, String name) {
        this.country_id = country_id;
        this.city_id = city_id;
        this.name = name;
    }

    public City(int city_id, String name) {
        this.city_id = city_id;
        this.name = name;
    }


    public int getCountry_id() {
        return country_id;
    }



    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
