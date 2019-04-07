package ru.stqa.pft.sandbox;

public class Square {

  public double l;

  public Square(double l) {  // 'l' is an argument
    this.l = l;  // 'this' indicates on variable 'l', which equals to argument 'l'
  }

  public double area(){
    return this.l * this.l;
  }
}
