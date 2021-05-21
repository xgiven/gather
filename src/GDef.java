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
  
  public static UnaryOperator<UnaryOperator<Map<String, Accessible<Object>>>> bind(
    Function<Map<String, Accessible<Object>>, Map.Entry<String, Accessible<Object>>> f
  ) {
    return curr_action -> (
      state -> curr_action.apply(
        this.bindEntryInternal(f, state)
      )
    );
  }
  
  public static Map<String, Accessible<Object>> bindEntryInternal(
    Function<Map<String, Accessible<Object>>, Map.Entry<String, Accessible<Object>>> f,
    Map<String, Accessible<Object>> state
  ) {
    Map.Entry<String, Accessible<Object>>> new_entry = f.apply(state);
    Map<String, Accessible<Object>> new_state = state.clone();
    new_state.put(new_entry.getKey(), new_entry.getValue());
    return new_state;
  }
}
