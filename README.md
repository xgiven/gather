# gather
A compositional approach to FRC commands

```java
public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.bind(_ -> new DriveAdapter(drive)),
      GDef.bind(_ -> new TimeTrack()),
      G.during(0, time).apply(
        _ -> new DriveForward(drive, 100, "left")
      ),
      GDef.bind(state -> new AbstractMap.SimpleEntry<>(
        "given/complete", state.get("time/value").get() >= time
      ))
    );
  }
}
```
