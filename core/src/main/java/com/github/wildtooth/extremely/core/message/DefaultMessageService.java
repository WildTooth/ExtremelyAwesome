package com.github.wildtooth.extremely.core.message;

import com.github.wildtooth.extremely.api.enums.MessageType;
import com.github.wildtooth.extremely.api.message.MessageService;
import net.labymod.api.models.Implements;
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
        Pattern.compile("^([\\w+\\s?]+): ([0-9]+([,.][0-9]+)*) \\(([0-9]+([,.][0-9]+)*) i alt\\)$"),
        MessageType.PUT_ALL
    );
  }

}
