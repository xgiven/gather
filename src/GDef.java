public class GDef {
  public static UnaryOperator<Map<String, Accessible<Object>>> unit() {
    return UnaryOperator<>.identity();
  }
  
  public static UnaryOperator<Map<String, Accessible<Object>>> comp(
    UnaryOperator<Map<String, Accessible<Object>>> f,
    UnaryOperator<Map<String, Accessible<Object>>> g,
  ) {
    return state -> f(g(state));
  }
  
  // Function<Function<UnaryOperator<Map<String, Accessible<Object>>>>, Function<Map<String, Accessible<Object>>, UnaryOperator<Map<String, Accessible<Object>>>>>
  public static Function<UnaryOperator<Map<String, Accessible<Object>>>> bind(
    Function<Map<String, Accessible<Object>>, UnaryOperator<Map<String, Accessible<Object>>>> f
  ) {
    return state -> null() // TODO
  }
}
