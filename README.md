# gather
A compositional approach to FRC commands

```java
GDef.comp(
  new DrivetrainAdapter(),
  new ColorAdapter(),
  new Track("rotations", 0),
  GDef.bind(state -> new TurnInPlace(100, "left")),
  GDef.bind(state -> new MapUpdate<>(
    "is-blue", state.get("color/value").close_to(255, 0, 0)
  )),
  G.when("is_blue", state -> new MapUpdate<>(
    "mem/rotations", ++state.get("mem/rotations")
  )),
  GDef.bind(state -> new MapUpdate<>(
    "given/complete", state.get("mem/rotations") >= 10
  ))
)
```
