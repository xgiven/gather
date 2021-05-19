# gather
A compositional approach to FRC commands

```java
public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.bind(_ -> new DriveAdapter(drive)), // Underlying subsystems should be low-level only
      GDef.bind(_ -> new TimeTrack()), // Like a subsystem, but uses initialize like a command
      G.during(0, time).apply( // G.during(start, end) is a combinator (it modifies actions)
        _ -> new DriveForward(drive, 100, "left") // This is a command (run asynchronously)
      ),
      GDef.bind(state -> new AbstractMap.SimpleEntry<>(
        "given/complete", state.get("time/value").get() >= time
      ))
    );
  }
}
```
