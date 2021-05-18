public class ExampleCommand extends GCommand {
  public ExampleCommand(int n_rotations, DriveSubsystem drive, ColorSubsystem color) {
    addRequirements(drive, color);
    super(
      GDef.comp(
        new DriveAdapter(drive),
        new ColorAdapter(color),
        new Track("rotations", 0),
        G.until_completion(new TurnInPlace(drive, 100, "left")),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "is-blue", state.get("color/value").close_to(255, 0, 0)
        )),
        G.when("is_blue", state -> new AbstractMap.SimpleEntry<>(
          "mem/rotations", ++state.get("mem/rotations")
        )),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("mem/rotations") >= n_rotations
        )),
      )
    );
  }
}
