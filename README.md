# gather
A compositional approach to FRC commands

```java
GCommand.unit()
  .comp(new DrivetrainAdapter())
  .comp(new ColorAdapter())
  .comp(new Track("rotations", 0))
  .bind(state -> new TurnInPlace(1, "left"))
  .bind(state -> new MapUpdate<>(
    "is-blue", state.get("color/value").close_to(255, 0, 0)
  ))
  .when("is-blue", state -> new MapUpdate<>(
    "mem/rotations", ++state.get("mem/rotations")
  ))
  .bind(state -> new MapUpdate<>(
    "given/complete", state.get("mem/rotations") >= 10
  ))
```
