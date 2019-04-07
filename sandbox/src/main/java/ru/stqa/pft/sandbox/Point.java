package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point( double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceNew(double x1, double y1) {
    double diffx = this.x - x1;
    double diffy = this.y - y1;
    return Math.sqrt(diffx * diffx + diffy * diffy);
  }
}
