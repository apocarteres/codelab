import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerTest {

  @Test
  void generate() {
    Function<Integer, Integer> fn = k -> 0;
    assertEquals("aaaa", new DictionaryBasedUrlShortener(fn).generate(""));
  }

  @Test
  void generate2() {
    AtomicInteger atomicInteger = new AtomicInteger();
    Function<Integer, Integer> fn = k -> atomicInteger.getAndIncrement();
    assertEquals("abcd", new DictionaryBasedUrlShortener(fn).generate(""));
  }

  @Test
  void seqTest1() {
    AtomicInteger atomicInteger = new AtomicInteger();
    Function<Integer, Integer> fn = k -> atomicInteger.getAndIncrement();
    assertEquals("abcd", new DictionaryBasedUrlShortener(fn).generate(""));
  }
}
