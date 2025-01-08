package com.github.wildtooth.extremely.api.message;

import com.github.wildtooth.extremely.api.enums.MessageType;
import net.labymod.api.reference.annotation.Referenceable;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

@Referenceable
public interface MessageService {

  /**
   * Tilføjer et pattern ved hjælp af en string.
   * @param message en string som skal konverteres til et pattern.
   * @param type en message type som skal tilknyttes til pattern.
   */
  void addMessagePattern(String message, MessageType type);

  /**
   * Returnerer en kopi af en collection med alle message patterns.
   * @return en kopi af en collection med alle message patterns.
   */
  Collection<Pattern> getMessagePatterns();

  /**
   * Returnerer en kopi af en map med alle message patterns og deres tilhørende message types.
   * @return en kopi af en map med alle message patterns og deres tilhørende message types.
   */
  Map<Pattern, MessageType> getPatternMap();
}
