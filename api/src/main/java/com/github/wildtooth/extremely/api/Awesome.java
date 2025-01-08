package com.github.wildtooth.extremely.api;

import com.github.wildtooth.extremely.api.generated.ReferenceStorage;

public class Awesome {

  private static ReferenceStorage references;

  private Awesome() {}

  public static ReferenceStorage getReferences() {
    return references;
  }

  public static void init(ReferenceStorage references) {
    if (Awesome.references != null) {
      throw new IllegalStateException("ExtremelyAwesome is already initialized");
    } else {
      Awesome.references = references;
      initRefs(references);
    }
  }

  public static void refresh() {

  }

  private static void initRefs(ReferenceStorage references) {
    references.transportableService().load();
    references.transporter().setTransportableService(references.transportableService());
    references.transporter().load();
  }

}
