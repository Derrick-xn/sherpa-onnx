package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes2.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
    private final TextPaint mTextPaint;

    DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 23 && i3 > Build.VERSION.SDK_INT) {
            return false;
        }
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.setLength(0);
        while (i < i2) {
            stringBuilder.append(charSequence.charAt(i));
            i++;
        }
        return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> threadLocal = sStringBuilder;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }
}