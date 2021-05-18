public class GDef {
  public static UnaryOperator<Map<String, Accessible<Object>>> unit() {
    return UnaryOperator<>.identity();
  }
  
  public static UnaryOperator<UnaryOperator<Map<String, Accessible<Object>>>> bind(
    Function<Map<String, Accessible<Object>>, UnaryOperator<Map<String, Accessible<Object>>>> f
  ) {
    return curr_action -> (
      state -> curr_action.apply(
        f.apply(state).apply(state)
      )
    );
  }
}
