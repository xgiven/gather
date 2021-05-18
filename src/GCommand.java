public abstract class GCommand extends CommandBase implements UnaryOperator<GReality> {
  final UnaryOperator<GReality> op;
  final GReality world = new GReality();
  
  public GCommand(UnaryOperator<GReality> op) {
    this.op = op;
  }
  
  public
  
  public GReality apply(GReality given) {
    return this.op.apply(given);
  }
}
