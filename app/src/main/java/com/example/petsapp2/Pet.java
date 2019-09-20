package com.example.petsapp2;

import com.google.gson.annotations.SerializedName;

public class Pet {

    //@SerializedName("name")
    private String name;
    //@SerializedName("id")
    private String id;
    //@SerializedName("photoUrls")
    private String photo;
    //@SerializedName("status")
    private String status;

    public Pet() {
    }

    public Pet(String name, String id, String photo, String status) {
        this.name = name;
        this.id = id;
        this.photo = photo;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
