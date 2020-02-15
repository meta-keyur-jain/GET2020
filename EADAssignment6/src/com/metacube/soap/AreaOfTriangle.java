package com.metacube.soap;

/*
 * This class is used to calculate the area of triangle
 */
public class AreaOfTriangle {
    
    public double calculate(double side1,double side2,double side3){
        double half = (side1+side2+side3)/2;
        return (Math.sqrt((half)*(half-side1)*(half-side2)*(half-side3)));
        
        
    }

}
