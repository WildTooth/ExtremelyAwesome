package com.github.wildtooth.extremely.api.event;

import com.github.wildtooth.extremely.api.enums.MessageType;
import net.labymod.api.event.Event;
import java.util.regex.Matcher;

public class MessageRecognizedEvent implements Event {
  private final MessageType type;
  private final Matcher matcher;

  public MessageRecognizedEvent(MessageType type, Matcher matcher) {
    this.type = type;
    this.matcher = matcher;
  }

  public MessageType getType() {
    return this.type;
  }

  public Matcher getMatcher() {
    return this.matcher;
  }
}
