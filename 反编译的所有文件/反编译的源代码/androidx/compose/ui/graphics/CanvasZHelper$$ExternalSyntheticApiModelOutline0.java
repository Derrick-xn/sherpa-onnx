package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import android.view.translation.ViewTranslationCallback;
import java.util.function.DoubleUnaryOperator;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class CanvasZHelper$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ ColorSpace.Rgb.TransferParameters m(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return new ColorSpace.Rgb.TransferParameters(d, d2, d3, d4, d5, d6, d7);
    }

    public static /* bridge */ /* synthetic */ ColorSpace.Rgb m(Object obj) {
        return (ColorSpace.Rgb) obj;
    }

    public static /* synthetic */ ColorSpace.Rgb m(String str, float[] fArr, float[] fArr2, ColorSpace.Rgb.TransferParameters transferParameters) {
        return new ColorSpace.Rgb(str, fArr, fArr2, transferParameters);
    }

    public static /* synthetic */ ColorSpace.Rgb m(String str, float[] fArr, float[] fArr2, DoubleUnaryOperator doubleUnaryOperator, DoubleUnaryOperator doubleUnaryOperator2, float f, float f2) {
        return new ColorSpace.Rgb(str, fArr, fArr2, doubleUnaryOperator, doubleUnaryOperator2, f, f2);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ColorSpace m3292m(Object obj) {
        return (ColorSpace) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ViewTranslationCallback m3293m(Object obj) {
        return (ViewTranslationCallback) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m3297m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m3301m(Object obj) {
        return obj instanceof ColorSpace.Rgb;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m3303m$1() {
    }
}