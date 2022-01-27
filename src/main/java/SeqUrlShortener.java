public final class SeqUrlShortener implements UrlShortener {

  private static final String DOMAIN = "https://short.com";
  private final int n;
  private int i = 1;

  public SeqUrlShortener(int n) {
    this.n = n;
  }

  public String generate(String url) {
    StringBuilder builder = new StringBuilder(DOMAIN).append("/");
    builder.append(i++);
    return builder.toString();
  }
}
