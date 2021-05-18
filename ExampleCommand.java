public class ExampleCommand extends GCommand {
  public ExampleCommand() {
    super(
      GDef.comp(
        new DrivetrainAdapter(),
        new ColorAdapter(),
        new Track("rotations", 0),
        GDef.bind(state -> new TurnInPlace(100, "left")),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "is-blue", state.get("color/value").close_to(255, 0, 0)
        )),
        G.when("is_blue", state -> new AbstractMap.SimpleEntry<>(
          "mem/rotations", ++state.get("mem/rotations")
        )),
        GDef.bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("mem/rotations") >= 10
        )),
      )
    );
  }
}
