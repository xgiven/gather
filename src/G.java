public class G {
  public static comp(UnaryOperator<Map<String, Accessible<Object>>>... ops) {
    return ops.stream().reduce(
      GDef.unit(),
      (a, x) -> a.andThen(x)
    );
  }
  
  public static comp(UnaryOperator<Map<String, Accessible<Object>>>[] ops) {
    return G.comp(ops);
  }
}
