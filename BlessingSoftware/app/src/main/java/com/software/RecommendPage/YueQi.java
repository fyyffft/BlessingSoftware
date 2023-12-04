package com.software.RecommendPage;

public class YueQi {
    private String yName;
    private int yImage;

    public YueQi() {
    }

    public YueQi(String yName, int yImage) {
        this.yName = yName;
        this.yImage = yImage;
    }

    public String getyName() {
        return yName;
    }

    public void setyName(String yName) {
        this.yName = yName;
    }

    public int getyImage() {
        return yImage;
    }

    public void setyImage(int yImage) {
        this.yImage = yImage;
    }

    @Override
    public String toString() {
        return "yueQi{" +
                "yName='" + yName + '\'' +
                ", yImage='" + yImage + '\'' +
                '}';
    }
}
