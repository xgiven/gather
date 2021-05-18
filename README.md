# gather
A compositional approach to FRC commands

```java
public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(G.comp(
        GDef.bind(_ -> new DriveAdapter(drive)),
        G.until_completion(_ -> new DriveForward(drive, 100, "left"))
        GDef.bind(_ -> new Track("time-start", null)),
        GDef.bind(_ -> new TimeTrack()),
        G.if_equal("given/phase", "__init__",
          state -> new AbstractMap.SimpleEntry<>(
            "mem/time-start", state.get("time.value").get()
          )
        ),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "time-elapsed", state.get("time/value").get() - state.get("mem/time-start").get()
        )),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("time-elapsed").get() >= time
        )),
    ));
  }
}
```
