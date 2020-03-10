package ua.lviv.iot.manager;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class PenultimateWordFromFileReader {
  FileInputStream fileInputStream;

  public void setFileInputStream(FileInputStream fileInputStream) {
    this.fileInputStream = fileInputStream;
  }

  @SuppressWarnings("deprecation")
  public String readFromFile() throws IOException {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    DataInputStream reader = new DataInputStream(bufferedInputStream);
    String returnString = "";
    String getString;
    while ((getString = reader.readLine()) != null) {
      returnString = returnString + "\n" + getString;
    }
    return returnString;
  }
}
