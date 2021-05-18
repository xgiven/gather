public class GDef<Reality extends Map<String, Accessible<Object>>> {
  public static UnaryOperator<Reality> unit() {
    return UnaryOperator<>.identity();
  }
  
  public static UnaryOperator<UnaryOperator<Reality>> bind(
    Function<Reality, UnaryOperator<Reality>> f
  ) {
    return curr_action -> (
      state -> curr_action.apply(
        f.apply(state).apply(state)
      )
    );
  }
}
