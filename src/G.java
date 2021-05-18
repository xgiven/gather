public class G {
  public static comp(UnaryOperator<Map<String, Accessible<Object>>>... ops) {
    return base -> ops.stream().reduce(
      base,
      (a, x) -> a.andThen(x)
    );
  }
  
  public static comp(UnaryOperator<Map<String, Accessible<Object>>>[] ops) {
    return G.comp(ops);
  }
}
