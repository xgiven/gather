# gather
A compositional approach to FRC commands

```java
GDef.comp(
  GBasis.bind(
    "is_red", state -> state.ref.get("color").close_to("FF0000")
  ),
  GBasis.track(
    Map.of("is_red", false, "is_blue", false, "stage", 0)
  ),
  GDef.world(ColorAdapter),
  GDef.world(ControllerAdapter),
)
```
