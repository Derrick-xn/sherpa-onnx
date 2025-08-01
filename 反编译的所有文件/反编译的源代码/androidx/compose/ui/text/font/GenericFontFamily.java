package androidx.compose.ui.text.font;

import androidx.autofill.HintConstants;
import kotlin.Metadata;

/* compiled from: FontFamily.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/font/GenericFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", HintConstants.AUTOFILL_HINT_NAME, "", "fontFamilyName", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public static final int $stable = 0;
    private final String fontFamilyName;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public GenericFontFamily(String str, String str2) {
        super(null);
        this.name = str;
        this.fontFamilyName = str2;
    }

    /* renamed from: toString, reason: from getter */
    public String getFontFamilyName() {
        return this.fontFamilyName;
    }
}