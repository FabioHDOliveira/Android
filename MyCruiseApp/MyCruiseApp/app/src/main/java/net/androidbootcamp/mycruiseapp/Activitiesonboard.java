package net.androidbootcamp.mycruiseapp;

public class Activitiesonboard {
    private int id;
    private String name;
    private int price;
    private String description;

    //Constructor

    public Activitiesonboard(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //Setter, getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return "Description: " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
