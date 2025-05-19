package com.tca.Area;

public class CircleArea {

    static final Double PI = 3.14;
    public Double radius;

    public CircleArea(Double radius) {
        this.radius = radius;
    }
    
    public Double getCirclearea() {
        return PI*radius*radius;
    }
    
  
}
