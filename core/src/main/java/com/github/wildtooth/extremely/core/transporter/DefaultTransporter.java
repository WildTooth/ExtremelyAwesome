package com.github.wildtooth.extremely.core.transporter;

import com.github.wildtooth.extremely.api.transportable.TransportableService;
import com.github.wildtooth.extremely.api.transporter.Transporter;
import net.labymod.api.models.Implements;
import java.util.HashMap;

@Implements(Transporter.class)
public class DefaultTransporter implements Transporter {

  private TransportableService transportableService;
  private final HashMap<String, Integer> transporter = new HashMap<>();

  @Override
  public int getAmount(String transportableId) {
    return this.transporter.getOrDefault(transportableId, 0);
  }

  @Override
  public void setAmount(String transportableId, int amount) {
    if (this.transportableService.hasTransportable(transportableId)) {
      this.transporter.put(transportableId, amount);
    }
  }

  @Override
  public void clearTransporter() {
    this.transporter.clear();
  }

  @Override
  public void setTransportableService(TransportableService transportableService) {
    this.transportableService = transportableService;
  }

  @Override
  public void load() {
    
  }
}
