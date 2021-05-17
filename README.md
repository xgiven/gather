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

```java
GDef.comp(
  GBasis.bind_new()
  GBasis.bind_new("is_blue",
    x -> x.get("world/color").close_to(255, 0, 0)
  ),
  GDef.world(new GBasis.remember("rotations", 0))
  GDef.world(new ColorAdapter())
  GDef.world(new ControllerAdapter()),
)
```
