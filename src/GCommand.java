public abstract class GCommand extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> op;
  final GReality world = new GReality();
  
  public GCommand(UnaryOperator<GReality> op) {
    this.op = op;
  }
  
  public static GCommand unit() {
    return new GCommand(
      UnaryOperator.identity<GReality>()
    );
  }
  
  public GCommand comp(GCommand other) {
    return new GCommand(
      state -> this.op.compose(other.op)(state)
    );
  }
  
  public GCommand bind(Function<GReality, GCommand> f) {
    return new GCommand(
      state -> this.op.compose(f)(state)(state)
    );
  }
  
  public GReality apply(GReality given) {
    return this.world.apply(given);
  }
}
