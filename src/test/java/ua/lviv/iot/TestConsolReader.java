package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.manager.PenultimateWordFinder;

class TestConsolReader {

  String s = "";

  private static final String expected = "humoured,spoke,valley,find,estimable,reasonably,marriage,gay,met,in,no,in,welcomed,therefore,contrasted,are,replied,she,chamber,interested,in,am,do,as,shall,on,recurred,why,satisfied,smallness,in,the,dependent,is,mean,do,son,at,drawn,led,near,others,marked,ye,blushes,my,oh,now,of,contempt,sentiments,arrived,you,nor,his,small,answered,provided,while,door,marianne,child,ye";

  // @Test
  void testPrintPenultimateWordFromConsole() {
    PenultimateWordFinder.printPenultimateWordFromConsole();
  }

  @Test
  void testPrintPenultimateWordFromFile() {
    PenultimateWordFinder.printPenultimateWordFromFile("input.txt");
  }

  // @Test
  void testFindPenultimateWordFromConsole() {
    assertEquals(PenultimateWordFinder.findPenultimateWordFromConsole(), expected);
  }

  @Test
  void testFindPenultimateWordFromFile() {
    assertEquals(PenultimateWordFinder.findPenultimateWordFromFile("input.txt"), expected);
  }

}
