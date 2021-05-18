public abstract class GCommandObject extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> world;
  
  public GCommandObject(UnaryOperator<GReality> world) {
    this.world = world;
  }
  
  public GReality apply(GReality given) {
    return this.world.apply(given);
  }
}
