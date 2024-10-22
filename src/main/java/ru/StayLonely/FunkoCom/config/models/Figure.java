package ru.StayLonely.FunkoCom.config.models;

public class Figure {
    private int id;
    private String name;
    private String collection;
    private byte[] photo;

    public Figure(int id, String name, String collection, byte[] photo) {
        this.id = id;
        this.name = name;
        this.collection = collection;
        this.photo = photo;
    }

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

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
