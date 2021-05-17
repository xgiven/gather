# gather
A compositional approach to FRC commands

```java
GDef.comp(
  GBasis.bind("__complete__", ),
  GBasis.bind("dt/polar", new Polar2D(1, 0)),
  GBasis.on("is_blue",
    x -> new AbstractMap.SimpleEntry<? extends String, ? extends Object>("")
  ),
  GBasis.bind_new("is_blue",
    x -> x.get("color/value").close_to(255, 0, 0)
  ),
  GDef.world(new GBasis.Memory("rotations", 0))
  GDef.world(new ColorAdapter())
  GDef.world(new DrivetrainAdapter()),
)
```
