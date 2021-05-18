public abstract class GCommand extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> op;
  final GReality world = new GReality();
  
  public GCommand(UnaryOperator<GReality> op) {
    this.op = op;
  }
  
  @Override
  public void initialize() {
    world.put("given/phase", "__init__");
    world.put("given/complete", false);
    this.execute();
    world.put("given/phase", "__exec__");
  }
  
  public GReality apply(GReality given) {
    return this.op.apply(given);
  }
}
