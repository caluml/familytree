package com.github.caluml.familytree;

public class Greats {

  public static String great(int descendants) {
    if (descendants < 2) {
      return "";
    }
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < descendants - 2; i++) {
      ret.append("great-");
    }
    ret.append("grand-");
    return ret.toString();
  }
}
