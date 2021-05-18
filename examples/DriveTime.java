public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.comp(
        new DriveAdapter(drive),
        new Track("time-start", null),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "time-elapsed", state.get("given/time") - state.get("mem/time-start")
        )),
        
      )
    );
  }
}
