package ua.lviv.iot.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PenultimateWordFinder {
  static PenultimateWordFromFileReader fileReader;

  public static final String PATTERN_CONST = "(\\w|'|\\(|\\))+?\\s(\\w|'|\\(|\\))+?(\\.|\\?|\\!|\\.\\.\\.)";

  private static String findPenultimateWord(String text) {
    String returnString = null;
    Pattern pattern = Pattern.compile(PATTERN_CONST);
    Matcher matcher = pattern.matcher(text);
    boolean flag = false;
    while (matcher.find()) {
      String string = text.substring(matcher.start(), matcher.end());
      Pattern pattern2 = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
      String word = pattern2.split(string)[0];
      if (!flag) {
        returnString = word;
        flag = true;
      } else {
        returnString = returnString + "," + word;
      }
    }
    return returnString;
  }

  @SuppressWarnings("resource")
  public static String findPenultimateWordFromConsole() {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    String text = "";
    text = scanner.nextLine();
    return findPenultimateWord(text);
  }

  public static void printPenultimateWordFromConsole() {
    System.out.println(findPenultimateWordFromConsole());
  }

  public static String findPenultimateWordFromFile(String fileName) {
    fileReader = new PenultimateWordFromFileReader();
    String retuntString = null;
    try (FileInputStream fileInputStream = new FileInputStream(fileName);) {
      fileReader.setFileInputStream(fileInputStream);
      String text = fileReader.readFromFile();
      retuntString = findPenultimateWord(text);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return retuntString;
  }

  public static void printPenultimateWordFromFile(String fileName) {
    System.out.println(findPenultimateWordFromFile(fileName));
  }
}
