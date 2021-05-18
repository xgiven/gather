public abstract class GCommand extends CommandBase implements UnaryOperator<Map<String, Accessible<Object>>> {
  final UnaryOperator<Map<String, Accessible<Object>>> op;
  Map<String, Accessible<Object>> world = new HashMap();
  
  public GCommand(UnaryOperator<Map<String, Accessible<Object>>>... ops) {
    this.op = G.comp(ops);
  }
  
  @Override
  public void initialize() {
    world.put("given/phase", new ARef<>("__init__"));
    world.put("given/complete", new ARef<>(false));
    this.execute();
    world.put("given/phase", new ARef<>("__exec__"));
  }
  
  @Override
  public void execute() {
    world = this.op.apply(world);
  }
  
  @Override
  public void end() {
    world.put("given/phase", new ARef<>("__last__"));
    this.execute();
  }
  
  @Override
  public boolean isFinished() {
    return world.get("given/complete").get();
  }
  
  public GReality apply(GReality given) {
    return this.op.apply(given);
  }
}
