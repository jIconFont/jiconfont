package jiconfont;

import java.util.*;

/**
 * Copyright (c) 2016 jIconFont <BR>
 * <BR>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:<BR>
 * <BR>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.<BR>
 * <BR>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class AbstractIconCodeGenerator {

  private Map<String, String> icons = new HashMap<>();
  private String prefix;

  public AbstractIconCodeGenerator(String prefix) {
    this.prefix = prefix;
  }

  public void registerIcon(String name, String unicode) {
    if (Character.isDigit(name.charAt(0))) {
      name = prefix + name;
    }
    this.icons.put(name, unicode);
  }

  public List<SimpleIconCode> buildIconCodeList() {
    List<SimpleIconCode> list = new ArrayList<>();
    for (Map.Entry<String, String> entry : this.icons.entrySet()) {
      list.add(new SimpleIconCode(entry.getKey(), entry.getValue()));
    }
    Collections.sort(list, new Comparator<SimpleIconCode>() {
      @Override
      public int compare(SimpleIconCode o1, SimpleIconCode o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
    return list;
  }

  public String generateIconCodes() {
    StringBuilder sb = new StringBuilder();
    List<SimpleIconCode> list = buildIconCodeList();
    for (int i = 0; i < list.size(); i++) {
      SimpleIconCode simpleIconCode = list.get(i);
      sb.append(simpleIconCode.getName());
      sb.append("('\\u");
      sb.append(simpleIconCode.getUnicode());
      sb.append("')");
      if (i < list.size() - 1) {
        sb.append(",");
      }
      else {
        sb.append(";");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static class SimpleIconCode {
    private String name;
    private String unicode;

    public SimpleIconCode(String name, String unicode) {
      this.name = name;
      this.unicode = unicode;
    }

    public String getUnicode() {
      return unicode;
    }

    public String getName() {
      return name;
    }
  }

}
