package com.software.RecommendPage;

public class YueQu {
    private String name;
    private int image;

    public YueQu() {
    }

    public YueQu(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "YueQu{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
