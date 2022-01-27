import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class DictionaryBasedUrlShortener implements UrlShortener {

  private static final String DOMAIN = "https://short.com";
  private static final long MAX_SEO_LENGTH = 4;
  private final List<Integer> dictionary;
  private final Function<Integer, Integer> fn;

  public DictionaryBasedUrlShortener(Function<Integer, Integer> fn) {
    this.fn = fn;
    this.dictionary = makeDictionary();
  }

  private static List<Integer> makeDictionary() {
    var result = new ArrayList<Integer>();
    for (int i = 'a'; i < 'z'; ++i) {
      result.add(i);
    }
    for (int i = 'A'; i < 'Z'; ++i) {
      result.add(i);
    }
    for (int i = '0'; i <= '9'; ++i) {
      result.add((char) i - 48);
    }
    return result;
  }

  @Override
  public String generate(String url) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < MAX_SEO_LENGTH; i++) {
      int code = dictionary.get(fn.apply(dictionary.size()));
      builder.append((char) code);
    }
    return builder.toString();
  }

}
