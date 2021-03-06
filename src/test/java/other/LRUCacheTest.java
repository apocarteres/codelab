package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
  @Test
  void test0() {
    var cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    assertEquals(-1, cache.get(1));
    assertEquals(2, cache.get(2));
    assertEquals(3, cache.get(3));
  }

  @Test
  void test0a() {
    var cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(2, cache.get(2));
    assertEquals(2, cache.get(2));
    assertEquals(1, cache.get(1));
    assertEquals(1, cache.get(1));
  }

  @Test
  void test0b() {
    var cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    assertEquals(2, cache.get(2));
    assertEquals(2, cache.get(2));
    assertEquals(-1, cache.get(1));
    assertEquals(2, cache.get(2));
  }

  @Test
  void test1() {
    var cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));
    cache.put(3, 3);
    assertEquals(-1, cache.get(2));
    cache.put(4, 4);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(3));
    assertEquals(4, cache.get(4));
  }

  @Test
  void test2() {
    var cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    assertEquals(1, cache.get(2));
    cache.put(4, 1);
    assertEquals(-1, cache.get(1));
    assertEquals(1, cache.get(2));
  }

  @Test
  void test3() {
    var cache = new LRUCache(2);
    assertEquals(-1, cache.get(2));
    cache.put(2, 6);
    assertEquals(-1, cache.get(1));
    cache.put(1, 5);
    cache.put(1, 2);
    assertEquals(2, cache.get(1));
    assertEquals(6, cache.get(2));
  }

  @Test
  void test4() {
    var cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(2));
  }

  @Test
  void test5() {
    var cache = new LRUCache(10);
    cache.put(10, 13);
    cache.put(3, 17);
    cache.put(6, 11);
    cache.put(10, 5);
    cache.put(9, 10);
    assertEquals(-1, cache.get(13));

    cache.put(2, 19);
    assertEquals(19, cache.get(2));
    assertEquals(17, cache.get(3));

    cache.put(5, 25);
    assertEquals(-1, cache.get(8));

    cache.put(9, 22);
    cache.put(5, 5);
    cache.put(1, 30);
    assertEquals(-1, cache.get(11));

    cache.put(9, 12);
    assertEquals(-1, cache.get(7));
    assertEquals(5, cache.get(5));
    assertEquals(-1, cache.get(8));
    assertEquals(12, cache.get(9));

    cache.put(4, 30);
    cache.put(9, 3);
    assertEquals(3, cache.get(9));
    assertEquals(5, cache.get(10));
    assertEquals(5, cache.get(10));

    cache.put(6, 14);
    cache.put(3, 1);
    assertEquals(1, cache.get(3));

    cache.put(10, 11);
    assertEquals(-1, cache.get(8));

    cache.put(2, 14);
    assertEquals(30, cache.get(1));
    assertEquals(5, cache.get(5));
    assertEquals(30, cache.get(4));

    cache.put(11, 4);
    cache.put(12, 24);
    cache.put(5, 18);
    assertEquals(-1, cache.get(13));

    cache.put(7, 23);
    assertEquals(-1, cache.get(8));
    assertEquals(24, cache.get(12));

    cache.put(3, 27);
    cache.put(2, 12);
    assertEquals(18, cache.get(5));

    cache.put(2, 9);
    cache.put(13, 4);
    cache.put(8, 18);
    cache.put(1, 7);
    assertEquals(-1, cache.get(6));
  }
}
