public class Var<T> implements Accessible<T> {
  T underlying;
  
  public T get() { return underlying; }
  public void set(T new_value) { underlying = new_value; }
}
