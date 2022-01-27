package other;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

final class LruValue {
  private int value;
  private int lastUsed;

  LruValue(int value, int lastUsed) {
    this.value = value;
    this.lastUsed = lastUsed;
  }

  int value() {
    return value;
  }

  public void update(int value) {
    this.value = value;
  }

  public int lastUsed() {
    return this.lastUsed;
  }

  public void hit(int value) {
    this.lastUsed = value;
  }
}

public class LRUCache {
  private final Map<Integer, LruValue> map;
  private final int capacity;
  private int currentTime = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    var lruValue = map.get(key);
    if (lruValue == null) {
      return -1;
    }
    if(lruValue.lastUsed() <= currentTime - capacity) {
      map.remove(key);
      return -1;
    }
    lruValue.hit(currentTime);
    return lruValue.value();
  }

  public void put(int key, int value) {
    var existLru = map.get(key);
    if (nonNull(existLru)) {
      existLru.update(value);
//      existLru.updatedLastUsed(currentTime);
      return;
    }
    map.put(key, new LruValue(value, currentTime++));
  }

}
