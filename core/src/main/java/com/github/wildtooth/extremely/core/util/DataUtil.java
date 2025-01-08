package com.github.wildtooth.extremely.core.util;

import net.labymod.api.util.io.web.request.Request;
import net.labymod.api.util.io.web.request.Response;
import java.util.ArrayList;

public class DataUtil {
  public static ArrayList<String[]> csv(String url, boolean skipHeader) {
    return csv(url, skipHeader, ",");
  }

  public static ArrayList<String[]> csv(String url, boolean skipHeader, String delimiter) {
    Response<String> response = Request.ofString()
        .url(url)
        .executeSync();
    ArrayList<String[]> data = new ArrayList<>();
    for (String line : response.get().split("\n")) {
      data.add(line.split(delimiter));
    }
    if (!data.isEmpty() && skipHeader) {
      data.removeFirst();
    }
    return data;
  }
}
