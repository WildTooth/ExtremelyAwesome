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
      case PUT_ALL:
        putAll(event.getMatcher());
        break;
    }
  }

  private void putAll(Matcher matcher) {
    String item = parseItemToTransportableID(matcher.group(1));
    int amount = Integer.parseInt(matcher.group(2));
    int totalAmount = Integer.parseInt(matcher.group(4));
    this.transporter.setAmount(item, totalAmount);
  }

  private String parseItemToTransportableID(String item) {
    return item.toUpperCase().replace(" ", "_");
  }

}
