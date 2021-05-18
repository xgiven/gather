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
        .comp(new Track("rotations", 0))
        .fmap(state -> new AbstractMap.SimpleEntry<>(
          "is-blue", state.get("color/value").close_to(255, 0, 0)
        ))
        .when("is-blue",
          state -> new AbstractMap.SimpleEntry<>(
            "mem/rotations", state.get("mem/rotations") + 1
          )
        )
    );
  }
}
```
