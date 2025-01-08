package com.github.wildtooth.extremely.api.transporter;

import com.github.wildtooth.extremely.api.Service;
import com.github.wildtooth.extremely.api.transportable.TransportableService;
import net.labymod.api.reference.annotation.Referenceable;

@Referenceable
public interface Transporter extends Service {

  int getAmount(String transportableId);

  void setAmount(String transportableId, int amount);

  void clearTransporter();

  void setTransportableService(TransportableService transportableService);
}
