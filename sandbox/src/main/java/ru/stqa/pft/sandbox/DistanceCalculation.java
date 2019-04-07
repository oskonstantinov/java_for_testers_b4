package ru.stqa.pft.sandbox;

public class DistanceCalculation {

  public static void main(String[] args) {

    Point p1 = new Point(2, 6);
    Point p2 = new Point(6, 11);
    Point p3 = new Point (5, 4);
    System.out.println("The distance between points is equals to " + distance(p1, p2));

    System.out.println("The distance between points, calculated by method 'distanceNew', is equals to " + p3.distanceNew(3, 7));
  }

  public static double distance(Point p1, Point p2) {
    double diffx = p2.x- p1.x;
    double diffy = p2.y - p1.y;
    return Math.sqrt(diffx * diffx + diffy * diffy);
  }
}
