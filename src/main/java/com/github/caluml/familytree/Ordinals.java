package com.github.caluml.familytree;

public class Ordinals {

  public static String ordinal(int number) {
    switch (number) {
      case 1:
        return "first";
      case 2:
        return "second";
      case 3:
        return "third";
      // TODO: Cover higher numbers
    }
    throw new RuntimeException("No ordinal for " + number);
  }

}
