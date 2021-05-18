# gather
A compositional approach to FRC commands

```java
public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.unit()
        .andThen(GDef.bind(_ -> new DriveAdapter(drive)))
        .andThen(GDef.bind(_ -> new TimeTrack()))
        .andThen(G.track("time-start", null))
        .andThen(G.until_completion(_ -> new DriveForward(drive, 100, "left")))
        .andThen(G.if_equal("given/phase", "__init__",
          state -> new AbstractMap.SimpleEntry<>(
            "mem/time-start", state.get("time/value").get()
          )
        ))
        .andThen(GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "time-elapsed", state.get("time/value").get() - state.get("mem/time-start").get()
        )))
        .andThen(GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("time-elapsed").get() >= time
        )))
    );
  }
}
```
