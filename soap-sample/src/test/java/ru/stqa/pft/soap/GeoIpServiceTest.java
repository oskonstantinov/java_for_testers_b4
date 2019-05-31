package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {

  @Test
  public void testMyIp() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("109.106.140.132");
    assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>86</State></GeoIP>");
  }
}
