package com.book.java8feature;

public class Orange extends Fruit {

    private Integer weight;
    private String color;

    public Orange (Integer weight) {
        this.weight = weight;
    }

    public Orange (Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight () {
        return weight;
    }

    public void setWeight (Integer weight) {
        this.weight = weight;
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }

    @Override
    public String toString () {
        return "Orange{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
