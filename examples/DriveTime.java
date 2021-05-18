public class DriveTime extends GCommand {
  public DriveTime(int time, DriveSubsystem drive) {
    addRequirements(drive);
    super(
      GDef.comp(
        new DriveAdapter(drive),
        new Track("time-start", null),
        G.until_completion(new DriveForward(drive, 100, "left")),
        G.if_equal("given/phase", "__init__",
          state -> new AbstractMap.SimpleEntry<>(
            "mem/time-start", Timer.getFPGATimestamp()
          )
        )
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "time-elapsed", state.get("given/time").get() - state.get("mem/time-start").get()
        )),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("time-elapsed").get() >= time
        )),
      )
    );
  }
}
