public class ExampleCommand extends GCommandObject {
  public ExampleCommand() {
    super(
      GCommand.unit()
        .comp(new DrivetrainAdapter())
        .comp(new ColorAdapter())
        .comp(new Track("rotations", 0))
        .bind(state -> new TurnInPlace(1, "left"))
        .bind(state -> new AbstractMap.SimpleEntry<>(
          "is-blue", state.get("color/value").close_to(255, 0, 0)
        ))
        .when("is-blue", state -> new AbstractMap.SimpleEntry<>(
          "mem/rotations", ++state.get("mem/rotations")
        ))
        .bind(state -> new AbstractMap.SimpleEntry<>(
          "given/complete", state.get("mem/rotations") >= 10
        ))
    );
  }
}

public class ExampleCommand extends GCommand {
  public ExampleCommand() {
    super(
      GDef.comp(
        new DrivetrainAdapter(),
        new ColorAdapter(),
        new Track("rotations", 0),
        GDef.bind(state -> new TurnInPlace(100, "left")),
        GDef.bind(state -> new MapUpdate<>(
          "mem/rotations", ++state.get("mem/rotations")
        )),
        G.when("is_blue", state -> new MapUpdate<>(
          "mem/rotations", state.get("mem/rotations") >= 10
        )),
        GDef.bind(state -> new MapUpdate)
      )
    );
  }
}
