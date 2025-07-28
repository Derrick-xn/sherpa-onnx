package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u001a\u0016\u0010 \u001a\u00020\u0006*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m5143toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m5719equalsimpl0(i, TextAlign.INSTANCE.m5726getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m5719equalsimpl0(i, TextAlign.INSTANCE.m5727getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m5719equalsimpl0(i, TextAlign.INSTANCE.m5723getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m5719equalsimpl0(i, TextAlign.INSTANCE.m5728getStarte0LSkKk()) && TextAlign.m5719equalsimpl0(i, TextAlign.INSTANCE.m5724getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m5145toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m5629equalsimpl0(i, Hyphens.INSTANCE.m5633getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m5629equalsimpl0(i, Hyphens.INSTANCE.m5634getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m5144toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m5660equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5666getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m5660equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5665getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m5660equalsimpl0(i, LineBreak.Strategy.INSTANCE.m5664getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m5146toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m5671equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5675getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m5671equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5676getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m5671equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5677getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m5671equalsimpl0(i, LineBreak.Strictness.INSTANCE.m5678getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m5147toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return (!LineBreak.WordBreak.m5683equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m5687getDefaultjp8hJ3c()) && LineBreak.WordBreak.m5683equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m5688getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return (!z || TextUnit.m6038equalsimpl0(textStyle.m5334getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m6038equalsimpl0(textStyle.m5334getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m6052getUnspecifiedXSAIIZE()) || TextAlign.m5719equalsimpl0(textStyle.m5339getTextAligne0LSkKk(), TextAlign.INSTANCE.m5729getUnspecifiede0LSkKk()) || TextAlign.m5719equalsimpl0(textStyle.m5339getTextAligne0LSkKk(), TextAlign.INSTANCE.m5728getStarte0LSkKk()) || TextAlign.m5719equalsimpl0(textStyle.m5339getTextAligne0LSkKk(), TextAlign.INSTANCE.m5725getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m5148toLayoutTextGranularityduNsdkg(int i) {
        return (!TextGranularity.m5258equalsimpl0(i, TextGranularity.INSTANCE.m5262getCharacterDRrd7Zo()) && TextGranularity.m5258equalsimpl0(i, TextGranularity.INSTANCE.m5263getWordDRrd7Zo())) ? 1 : 0;
    }
}