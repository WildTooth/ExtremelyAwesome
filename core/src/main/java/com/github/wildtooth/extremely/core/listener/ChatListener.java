package com.github.wildtooth.extremely.core.listener;

import com.github.wildtooth.extremely.api.enums.MessageType;
import com.github.wildtooth.extremely.api.event.MessageRecognizedEvent;
import com.github.wildtooth.extremely.api.message.MessageService;
import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatListener {

  private final MessageService messageService;

  public ChatListener(MessageService messageService) {
    this.messageService = messageService;
  }

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {
    String message = event.chatMessage().getOriginalPlainText().trim();
    for (Pattern pattern : this.messageService.getMessagePatterns()) {
      Matcher matcher = pattern.matcher(message);
      if (matcher.matches()) {
        MessageType type = this.messageService.getPatternMap().get(pattern);
        MessageRecognizedEvent recognizedEvent = new MessageRecognizedEvent(type, matcher);
        Laby.fireEvent(recognizedEvent);
      }
    }
  }

}
