package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {

  @Test
  public void testArea() {
    Rectangle r = new Rectangle(3, 7);
    Assert.assertEquals(r.area(),21.0);
  }
}
