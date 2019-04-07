package ru.stqa.pft.sandbox;

public class First {

  public static void main(String[] args) {
    hello("fellow");

    Square s = new Square(5);
    System.out.println("The area of the square with the side " + s.l + " is equal to " + s.area());

    Rectangle r = new Rectangle(3, 8);
    System.out.println("The area of the rectangle with the sides " + r.a + " and " + r.b + " is equal to " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}