package com.github.wildtooth.extremely.core.util;

import static net.labymod.api.util.CharSequences.capitalize;

public class StringUtil {
  private StringUtil() {
  }

  public static String capitalizeWords(String str, char delimiter) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    String[] words = str.split(String.valueOf(delimiter));
    for (String word : words) {
      sb.append(capitalize(word)).append(delimiter);
    }
    return sb.substring(0, sb.length() - 1);
  }
}
