package net.example.fitness.model;

import net.example.fitness.model.common.Entity;

public class BodyParameters extends Entity {

    private Integer weight;

    private Integer growth;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    @Override
    public String toString() {
        return "BodyParameters{" +
                "weight=" + weight +
                ", growth=" + growth +
                '}';
    }
}
