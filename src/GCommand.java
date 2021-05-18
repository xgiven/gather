public abstract class GCommand extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> world;
  
  public GCommand(UnaryOperator<GReality> world) {
    this.world = world;
  }
  
  public static GCommand unit() {
    return new GCommand(
      UnaryOperator.identity<GReality>()
    );
  }
  
  public GCommand comp(GCommand other) {
    return this.world.compose(other.world);
  }
  
  public GCommand bind(Function<GReality, GCommand> fn)
  
  public GReality apply(GReality given) {
    return this.world.apply(given);
  }
}
