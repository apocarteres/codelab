import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeqUrlShortenerTest {
  @Test
  void name() {
    var seqUrlShortener = new SeqUrlShortener(5);
    assertEquals("https://short.com/1", seqUrlShortener.generate(""));
    assertEquals("https://short.com/2", seqUrlShortener.generate(""));
  }
}
