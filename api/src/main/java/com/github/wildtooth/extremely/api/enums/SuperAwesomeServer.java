package com.github.wildtooth.extremely.api.enums;

public enum SuperAwesomeServer {
  LIMBO,
  LARME_LOBBY,
  SHOPPY_LOBBY,
  MACHINE_ROOM,
  UNRECOGNIZED,
  NONE
  ;

  public static SuperAwesomeServer fromString(String server) {
    return switch (server) {
      case "limbo" -> LIMBO;
      case "larmelobby" -> LARME_LOBBY;
      case "shoppylobby" -> SHOPPY_LOBBY;
      case "maskinrummet" -> MACHINE_ROOM;
      default -> UNRECOGNIZED;
    };
  }
}
