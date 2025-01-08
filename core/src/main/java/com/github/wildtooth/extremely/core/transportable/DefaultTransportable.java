package com.github.wildtooth.extremely.core.transportable;

import com.github.wildtooth.extremely.api.transportable.Transportable;

public class DefaultTransportable implements Transportable {
  private final String transportableId;
  private final String displayName;
  private final Double pricePoint;

  public DefaultTransportable(String transportableId, String displayName, Double pricePoint) {
    this.transportableId = transportableId;
    this.displayName = displayName;
    this.pricePoint = pricePoint;
  }

  @Override
  public String getTransportableId() {
    return this.transportableId;
  }

  @Override
  public String getDisplayName() {
    return this.displayName;
  }

  @Override
  public Double getPricePoint() {
    return this.pricePoint;
  }
}
