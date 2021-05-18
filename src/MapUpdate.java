public static class MapUpdate<K, V> extends Object implements Map.Entry<K, V>, UnaryOperator<? extends Map<K, V>> {
  final K key;
  final V value;
  final Map.Entry<? extends K, ? extends V> entry;
  
  public MapUpdate(K key, V value) {
    this.key = key;
    this.value = value;
    this.entry = null;
  }
  
  public MapUpdate(Map.Entry<? extends K, ? extends V> entry) {
    this.key = entry.getKey();
    this.value = entry.getValue();
    this.entry = entry;
  }
  
  public K getKey() { return (
    (this.entry)? this.entry.getKey() : this.key
  ); }
  public V getValue() { return (
    (this.entry)? this.entry.getValue() : this.value
  ); }
  
  public int hashCode() { return Objects.hash(this.key, this.value); }
  public boolean equals(Object o) {
    if (o instanceof MapUpdate<? extends K, ? extends V>) {
      return this.key.equals(o.key) && this.value.equals(o.value); 
    } else if (o instanceof MapUpdate<? super K, ? extends V>) {
      return o.key.equals(this.key) && this.value.equals(o.value);
    } else if (o instanceof MapUpdate<? extends K, ? super V>) {
      return this.key.equals(o.key) && o.value.equals(this.value);
    } else if (o instanceof MapUpdate<? super K, ? super V>) {
      return o.key.equals(this.key) && o.value.equals(this.value);
    } else { return false; }
  }
  
  public V setValue(V value) {
    if (!this.entry) {
      throw new UnsupportedOperationException("Cannot mutate a MapUpdate<K, V>");
      return null;
    } else {
      return this.entry.setValue(value);
    }
  }
  
  public <T extends Map<K, V>> T apply(T given) {
    given.put(this.getKey(), this.getValue());
    return given;
  }
}
