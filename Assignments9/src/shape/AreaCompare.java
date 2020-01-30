package shape;

import java.util.Comparator;

public class AreaCompare implements Comparator<Shape> 
{
    /**
     * Used to compare shapes according to their area
     * @param shape1 denotes the first shape that is to be compared
     * @param shape2 denotes the second shape that is to be compared
     * @return -1 if first shape is smaller than second else 1 if it is greater else 0
     */
    @Override
    public int compare(Shape shape1, Shape shape2)
    {       int result=0;

        if(shape1.getArea()<shape2.getArea())
            result =  -1;
        else if(shape1.getArea()>shape2.getArea())
            result =  1;
        else 
            result =  0;
        return result;
    }
}
