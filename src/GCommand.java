public abstract class GCommand extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> world;
  
  public GCommand(UnaryOperator<GReality> world) {
    this.world = world;
  }
  
  public GReality apply(GReality given) {
    return this.world.apply(given);
  }
}
