package shape;

import java.util.ArrayList;
import java.util.Date;

public class Rectangle implements Shape {
    private int intialXCordinate;
    private int intialYCordinate;
    private int length;
    private int breadth;
    private long time;

    public Rectangle(ArrayList<Integer> parameter, Point p) {
        this.intialXCordinate = p.getXCordinate();
        this.intialYCordinate = p.getYCordinate();
        this.length = parameter.get(0);
        this.breadth = parameter.get(1);
        Date date = new Date();
        time = date.getTime();
    }

    /**
     * 
     * Used to get the area of rectangle
     */
    @Override
    public double getArea() {
        return this.length * this.breadth;
    }

    /**
     * Used to get the perimeter of rectangle
     */
    @Override
    public double getPerimeter() {
        return 2 * (this.length + this.breadth);
    }

    /**
     * Used to get the origin of the shape
     */
    @Override
    public Point getOrigin() {
        Point instance = new Point(this.intialXCordinate, this.intialYCordinate);
        return instance;
    }

    /**
     * Used to get the origin of the shape
     */
    @Override
    public boolean isPointEnclosed(Point p) {
        boolean re = false;
        if ((p.getXCordinate() >= intialXCordinate && p.getXCordinate() <= intialXCordinate + length)
                && (p.getYCordinate() >= intialYCordinate && p.getYCordinate() <= intialYCordinate + breadth))
            re = true;
        else
            re = false;
        return re;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
}