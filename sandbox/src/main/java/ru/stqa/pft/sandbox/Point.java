package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point( double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceNew(Point p) {
    double diffx = this.x - p.x;
    double diffy = this.y - p.y;
    return Math.sqrt(diffx * diffx + diffy * diffy);
  }
}
