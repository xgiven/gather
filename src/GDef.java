public class GDef<Reality extends Map<String, Accessible<Object>>> {
  public static UnaryOperator<Reality> unit() {
    return UnaryOperator<>.identity();
  }
  
  public static UnaryOperator<Reality> comp(
    UnaryOperator<Reality> f, UnaryOperator<Reality> g,
  ) {
    return state -> f.apply(g.apply(state));
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
