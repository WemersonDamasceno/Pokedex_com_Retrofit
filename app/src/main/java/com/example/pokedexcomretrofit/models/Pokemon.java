package com.example.pokedexcomretrofit.models;

public class Pokemon {
    private int numberImg;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public int getNumberImg() {
        String [] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length -1]);
    }

    public void setNumberImg(int numberImg) {
        this.numberImg = numberImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
