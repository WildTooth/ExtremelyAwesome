package com.github.wildtooth.extremely.core.transportable;

import com.github.wildtooth.extremely.api.enums.Material;
import com.github.wildtooth.extremely.api.transportable.Transportable;
import com.github.wildtooth.extremely.api.transportable.TransportableService;
import com.github.wildtooth.extremely.core.util.DataUtil;
import com.github.wildtooth.extremely.core.util.StringUtil;
import net.labymod.api.models.Implements;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Implements(TransportableService.class)
public class DefaultTransportableService implements TransportableService {

  private final Set<Transportable> transportables;

  public DefaultTransportableService() {
    this.transportables = new HashSet<>();
  }

  @Override
  public Optional<Transportable> getTransportable(String transportableId) {
    Transportable transportable = null;
    for (Transportable t : this.transportables) {
      if (t.getTransportableId().equalsIgnoreCase(transportableId)) {
        transportable = t;
        break;
      }
    }
    return Optional.ofNullable(transportable);
  }

  @Override
  public void addTransportable(Transportable transportable) {
    this.transportables.add(transportable);
  }

  @Override
  public boolean hasTransportable(String transportableId) {
    return getTransportable(transportableId).isPresent();
  }

  @Override
  public Set<Transportable> getTransportables() {
    return this.transportables;
  }

  @Override
  public void load() {
    ArrayList<String[]> csv = DataUtil.csv("transportables.csv", true);
    int count = 0;
    for (String[] lines : csv) {
      if (!lines[0].equals(Material.values()[count].name())) {
        throw new RuntimeException("Transportable ID does not match Material ID");
      }
      String transportableId = StringUtil.capitalizeWords(lines[0].toLowerCase(), '_');
      addTransportable(
          new DefaultTransportable(
              transportableId,
              transportableId.replaceAll("_", " "),
              Double.parseDouble(lines[1])
          )
      );
      count++;
    }
  }
}
