# gather
A compositional approach to FRC commands

```java
GDef.comp(
  G.bind("__complete__",
    state -> state.get("rotations") > 10
  ),
  G.bind_value("dt/polar", new Polar2D(1, 0)),
  G.on("is_blue",
    state -> new AbstractMap.SimpleEntry<>(
      "rotations", state.get("rotations") + 1
    )
  ),
  G.bind_new("is_blue",
    state -> state.get("color/value").close_to(255, 0, 0)
  ),
  GDef.world(new G.remember("rotations", 0)),
  GDef.world(new ColorAdapter()),
  GDef.world(new DrivetrainAdapter()),
)
```
