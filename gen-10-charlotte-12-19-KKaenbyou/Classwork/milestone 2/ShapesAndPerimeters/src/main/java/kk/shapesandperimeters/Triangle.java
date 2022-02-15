// @author Kenji Kaenbyou

package kk.shapesandperimeters;

// Copied from square class,convert to triangle formulas later
abstract class Triangle extends Shape {
    
    double length = 0;
    double width = 0;
    
    @Override
    public double getArea() {
        double area;
        area = length * width;
        return area;
    }
    
    @Override
    public double getPeri() {   
        double peri;
        peri = (length * 2) + (width * 2);
        return peri;
    }
}