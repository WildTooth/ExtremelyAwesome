package com.github.wildtooth.extremely.core.message;

import com.github.wildtooth.extremely.api.enums.MessageType;
import com.github.wildtooth.extremely.api.message.MessageService;
import com.github.wildtooth.extremely.core.util.DataUtil;
import net.labymod.api.models.Implements;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Implements(MessageService.class)
public class DefaultMessageService implements MessageService {

  private final HashMap<Pattern, MessageType> patternMap = new HashMap<>();

  @Override
  public void addMessagePattern(String message, MessageType type) {
    this.patternMap.put(Pattern.compile(message), type);
  }

  @Override
  public Collection<Pattern> getMessagePatterns() {
    return this.patternMap.keySet();
  }

  @Override
  public Map<Pattern, MessageType> getPatternMap() {
    return Map.of(
        Pattern.compile("^([\\w\\s]+): ([0-9]+([,.][0-9]+)*) \\(([0-9]+([,.][0-9]+)*) i alt\\)$"),
        MessageType.TRANSPORTER_PUT_ALL,
        Pattern.compile("^([\\w\\s]+): ([0-9]+([,.][0-9]+)*)$"),
        MessageType.TRANSPORTER_LIST_ALL,
        Pattern.compile("^\\[Money\\] Balance: ([0-9]+([,.][0-9]+)*) Emeralds$"),
        MessageType.MONEY_BALANCE,
        Pattern.compile("^\\[Money\\] Du har sendt ([0-9]+([,.][0-9]+)*) Emerald to ([a-zA-Z0-9_]{2,16})\\.$"),
        MessageType.MONEY_SEND,
        Pattern.compile("^\\[Money\\] ([a-zA-Z0-9_]{2,16}) har sendt dig ([0-9]+([,.][0-9]+)*) Emerald\\.$"),
        MessageType.MONEY_RECEIVE,
        Pattern.compile("^Du er lige nu forbundet til ([a-z]+), brug \\/server <navn> for at joine en anden server\\.$"),
        MessageType.SERVER_CONNECTED
    );
  }

  @Override
  public void load() {
    ArrayList<String[]> messages = DataUtil.csv("", true, "==!==");
    for (String[] message : messages) {
      addMessagePattern(message[0], MessageType.of(message[1]));
    }
  }
}
