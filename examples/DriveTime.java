public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super( // Commands are functions/values, not classes (this is for integration purposes)
      GDef.bind(_ -> new DriveAdapter(drive)), // Underlying subsystems should be low-level
      GDef.bind(_ -> new TimeTrack()), // Like a subsystem, but uses initialize like a command
      G.during(0, time).apply( // G.during(start, end) is a combinator (it modifies actions)
        _ -> new DriveForward(drive, 100, "left") // This is a command (run asynchronously)
      ),
      GDef.bind(state -> new AbstractMap.SimpleEntry<>( // Map entries are a basic modifier
        "given/complete", state.get("time/value").get() >= time // Finish when time passed
      ))
    ); // All of these are going to be "gathered" together by reverse function composition
  }
}
