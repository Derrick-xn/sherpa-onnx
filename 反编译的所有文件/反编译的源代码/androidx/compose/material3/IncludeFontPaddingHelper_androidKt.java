package androidx.compose.material3;

import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncludeFontPaddingHelper.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"copyAndSetFontPadding", "Landroidx/compose/ui/text/TextStyle;", "style", "includeFontPadding", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IncludeFontPaddingHelper_androidKt {
    public static final TextStyle copyAndSetFontPadding(TextStyle style, boolean z) {
        Intrinsics.checkNotNullParameter(style, "style");
        return style.m5319copyCXVQc50((3932159 & 1) != 0 ? style.spanStyle.m5248getColor0d7_KjU() : 0L, (3932159 & 2) != 0 ? style.spanStyle.getFontSize() : 0L, (3932159 & 4) != 0 ? style.spanStyle.getFontWeight() : null, (3932159 & 8) != 0 ? style.spanStyle.getFontStyle() : null, (3932159 & 16) != 0 ? style.spanStyle.getFontSynthesis() : null, (3932159 & 32) != 0 ? style.spanStyle.getFontFamily() : null, (3932159 & 64) != 0 ? style.spanStyle.getFontFeatureSettings() : null, (3932159 & 128) != 0 ? style.spanStyle.getLetterSpacing() : 0L, (3932159 & 256) != 0 ? style.spanStyle.getBaselineShift() : null, (3932159 & 512) != 0 ? style.spanStyle.getTextGeometricTransform() : null, (3932159 & 1024) != 0 ? style.spanStyle.getLocaleList() : null, (3932159 & 2048) != 0 ? style.spanStyle.getBackground() : 0L, (3932159 & 4096) != 0 ? style.spanStyle.getTextDecoration() : null, (3932159 & 8192) != 0 ? style.spanStyle.getShadow() : null, (3932159 & 16384) != 0 ? TextAlign.m5716boximpl(style.paragraphStyle.getTextAlign()) : null, (3932159 & 32768) != 0 ? TextDirection.m5730boximpl(style.paragraphStyle.getTextDirection()) : null, (3932159 & 65536) != 0 ? style.paragraphStyle.getLineHeight() : 0L, (3932159 & 131072) != 0 ? style.paragraphStyle.getTextIndent() : null, (3932159 & 262144) != 0 ? style.platformStyle : new PlatformTextStyle(z), (3932159 & 524288) != 0 ? style.paragraphStyle.getLineHeightStyle() : null, (3932159 & 1048576) != 0 ? LineBreak.m5636boximpl(style.paragraphStyle.getLineBreak()) : null, (3932159 & 2097152) != 0 ? Hyphens.m5626boximpl(style.paragraphStyle.getHyphens()) : null);
    }
}