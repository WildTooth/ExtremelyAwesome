package com.github.wildtooth.extremely.api.transportable;

import com.github.wildtooth.extremely.api.Service;
import net.labymod.api.reference.annotation.Referenceable;
import java.util.Collection;
import java.util.Optional;

@Referenceable
public interface TransportableService extends Service {

  Optional<Transportable> getTransportable(String transportableId);

  void addTransportable(Transportable transportable);

  boolean hasTransportable(String transportableId);

  Collection<Transportable> getTransportables();
}
