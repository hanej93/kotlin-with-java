package com.lannstark.lec07;

import java.io.File;
import java.io.IOException;

public class Lec07Main {

  public static void main(String[] args) throws IOException {
    File currentFile = new File(".");
    JavaFilePrinter javaFilePrinter = new JavaFilePrinter();
    javaFilePrinter.readFile(currentFile.getAbsolutePath() + "/a.txt");
  }

}
