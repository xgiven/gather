public class GDef {
  public static UnaryOperator<Map<String, Accessible<Object>>> unit() {
    return x -> x;
  }
}
