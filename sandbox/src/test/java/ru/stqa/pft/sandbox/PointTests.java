package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistanceNotNull() {
    Point p1 = new Point(5, 11);
    Point p2 = new Point(7, 16);
    Assert.assertNotNull(p2.distanceNew(p1));
  }

  @Test
  public void testDistanceCorrect() {
    Point p1 = new Point(5, 11);
    Point p2 = new Point(7, 16);
    Assert.assertEquals(p2.distanceNew(p1), 5.385164807134504);
  }

  @Test
  public void testDistanceIncorrect() {
    Point p1 = new Point(5, 11);
    Point p2 = new Point(7, 16);
    Assert.assertNotEquals(p2.distanceNew(p1), 17.145125);
  }
}
