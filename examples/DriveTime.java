public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.comp(
        new DriveAdapter(drive),
        new Track("time-start", null),
        G.until_completion(new DriveForward(drive, 100, "left"))
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "time-elapsed", state.get("given/time") - state.get("mem/time-start")
        )),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("time-elapsed") >= time
        )),
      )
    );
  }
}
