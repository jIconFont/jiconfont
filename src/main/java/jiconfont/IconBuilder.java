package jiconfont;

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
public abstract class IconBuilder<FONT extends IconBuilder, COLOR, SIZE> {

  private SIZE size;
  private COLOR color;
  private IconCode icon;

  protected IconBuilder(IconCode icon) {
    this.icon = icon;
  }

  public final FONT setSize(SIZE size) {
    this.size = size;
    return getIconFontClass().cast(this);
  }

  public final SIZE getSize() {
    return size;
  }

  public final FONT setColor(COLOR color) {
    this.color = color;
    return getIconFontClass().cast(this);
  }

  public final COLOR getColor() {
    return color;
  }

  public final IconCode getIcon() {
    return icon;
  }

  protected abstract Class<FONT> getIconFontClass();

}
