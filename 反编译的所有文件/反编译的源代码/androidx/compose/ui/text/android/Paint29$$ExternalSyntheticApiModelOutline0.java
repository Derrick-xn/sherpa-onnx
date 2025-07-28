package androidx.compose.ui.text.android;

import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.graphics.text.LineBreakConfig;
import android.text.BoringLayout;
import android.text.GraphemeClusterSegmentFinder;
import android.text.Layout;
import android.text.SegmentFinder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Paint29$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* synthetic */ Typeface.Builder m(File file) {
        return new Typeface.Builder(file);
    }

    public static /* synthetic */ FontVariationAxis m(String str, float f) {
        return new FontVariationAxis(str, f);
    }

    public static /* synthetic */ LineBreakConfig.Builder m() {
        return new LineBreakConfig.Builder();
    }

    public static /* synthetic */ BoringLayout m(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2, boolean z2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }

    public static /* synthetic */ GraphemeClusterSegmentFinder m(CharSequence charSequence, TextPaint textPaint) {
        return new GraphemeClusterSegmentFinder(charSequence, textPaint);
    }

    public static /* bridge */ /* synthetic */ SegmentFinder m(Object obj) {
        return (SegmentFinder) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ScrollCaptureCallback m5347m(Object obj) {
        return (ScrollCaptureCallback) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ScrollCaptureSession m5348m(Object obj) {
        return (ScrollCaptureSession) obj;
    }

    public static /* synthetic */ ScrollCaptureTarget m(View view, Rect rect, Point point, ScrollCaptureCallback scrollCaptureCallback) {
        return new ScrollCaptureTarget(view, rect, point, scrollCaptureCallback);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ViewStructure m5349m(Object obj) {
        return (ViewStructure) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AutofillId m5350m(Object obj) {
        return (AutofillId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ContentCaptureSession m5351m(Object obj) {
        return (ContentCaptureSession) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m5352m() {
    }
}