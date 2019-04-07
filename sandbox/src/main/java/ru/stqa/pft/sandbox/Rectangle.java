package ru.stqa.pft.sandbox;

public class Rectangle {

  public double a;
  public double b;

  public Rectangle(double a, double b) {
    this.a = a; // 'this' indicates on variable 'a', which equals to argument 'a'
    this.b = b;
  }

  public double area() {
    return this.a * this.b;
  }
}
