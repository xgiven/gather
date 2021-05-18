# gather
A compositional approach to FRC commands

```java
public class ExampleCommand extends GCommand {
  final GReality world;
  
  public ExampleCommand() {
    super(
      GReality.unit()
        .comp(new DrivetrainAdapter())
        .comp(new ColorAdapter())
        .fmap(state -> new AbstractMap.SimpleEntry<>(
          "is_blue", state.get("color/value").close_to(255, 0, 0)
        ))
        .fmap(state -> new AbstractMap.SimpleEntry<>(
          "rotations", state.get
        ))
    );
  }
}
```

```java
compose(
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
  )
GDef.comp(
  GDef.world(new G.remember("rotations", 0)),
  GDef.world(new ColorAdapter()),
  GDef.world(new DrivetrainAdapter()),
)
```

### `GDef`: A world (`GWorldAdapter`) is a monoid

### `GDef`: An intent (`G`) is an endofunctor

1. `GDef.world(GWorldAdapter...)`
2. `GDef.intern()`
3. `GDef.comp(GRepr...)`
