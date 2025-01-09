package com.github.wildtooth.extremely.core.listener;

import com.github.wildtooth.extremely.api.event.MessageRecognizedEvent;
import com.github.wildtooth.extremely.api.transporter.Transporter;
import net.labymod.api.event.Subscribe;
import java.util.regex.Matcher;

public class MessageRecognizedListener {

  private Transporter transporter;

  @Subscribe
  public void onMessageRecognized(MessageRecognizedEvent event) {
    switch (event.getType()) {
      case TRANSPORTER_PUT_ALL:
        putAll(event.getMatcher());
        break;
      case TRANSPORTER_GET:
        get(event.getMatcher());
        break;
      case TRANSPORTER_PUT:
        put(event.getMatcher());
        break;
      case TRANSPORTER_LIST_ALL:
        listAll(event.getMatcher());
        break;
    }
  }

  private void putAll(Matcher matcher) {
    String item = parseItemToTransportableID(matcher.group(1));
    int amount = Integer.parseInt(matcher.group(2));
    int totalAmount = Integer.parseInt(matcher.group(4));
    this.transporter.setAmount(item, totalAmount);
  }

  private void get(Matcher matcher) {

  }

  private void put(Matcher matcher) {

  }

  private void listAll(Matcher matcher) {
    String item = parseItemToTransportableID(matcher.group(1));
    int amount = Integer.parseInt(matcher.group(2));
    this.transporter.setAmount(item, amount);
  }

  private String parseItemToTransportableID(String item) {
    return item.toUpperCase().replace(" ", "_");
  }

}
