public class G {
  public static UnaryOperator<Map<String, Accessible<Object>>> comp(
    UnaryOperator<Map<String, Accessible<Object>>>... ops
  ) {
    return base -> ops.stream().reduce(
      base,
      (a, x) -> a.andThen(x)
    );
  }
  
  public static UnaryOperator<Map<String, Accessible<Object>>> comp(
    UnaryOperator<Map<String, Accessible<Object>>>[] ops
  ) {
    return G.comp(ops);
  }
  
  public static UnaryOperator<UnaryOperator<Map<String, Accessible<Object>>>> during(
    ...
  )
}
