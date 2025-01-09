package com.github.wildtooth.extremely.api.enums;

public enum MessageType {
  TRANSPORTER_PUT,
  TRANSPORTER_GET,
  TRANSPORTER_PUT_ALL,
  TRANSPORTER_LIST_ALL,

  MONEY_BALANCE,
  MONEY_SEND,
  MONEY_RECEIVE,

  SERVER_CONNECTED,

  UNKNOWN;

  public static MessageType of(String name) {
    MessageType type = null;
    try {
      type = MessageType.valueOf(name.toUpperCase());
    } catch (IllegalArgumentException e) {
      type = MessageType.UNKNOWN;
    } finally {
      if (type == null) {
        type = MessageType.UNKNOWN;
      }
    }
    return type;
  }
}
