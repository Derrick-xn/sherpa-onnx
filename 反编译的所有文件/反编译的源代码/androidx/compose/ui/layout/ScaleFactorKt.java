package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ScaleFactor.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\fH\u0002\u001a%\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaleFactorKt {
    /* renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4784isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4786isUnspecifiedFK8aYYs$annotations(long j) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f) {
        float f2 = 10;
        float f3 = f * f2;
        int i = (int) f3;
        if (f3 - i >= 0.5f) {
            i++;
        }
        return i / f2;
    }

    /* renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4783isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.INSTANCE.m4781getUnspecified_hLwfpc();
    }

    /* renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4785isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.INSTANCE.m4781getUnspecified_hLwfpc();
    }

    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m4789timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m3113getWidthimpl(j) * ScaleFactor.m4774getScaleXimpl(j2), Size.m3110getHeightimpl(j) * ScaleFactor.m4775getScaleYimpl(j2));
    }

    /* renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m4790timesmw2e94(long j, long j2) {
        return m4789timesUQTWf7w(j2, j);
    }

    /* renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m4782divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m3113getWidthimpl(j) / ScaleFactor.m4774getScaleXimpl(j2), Size.m3110getHeightimpl(j) / ScaleFactor.m4775getScaleYimpl(j2));
    }

    /* renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m4787lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m4774getScaleXimpl(j), ScaleFactor.m4774getScaleXimpl(j2), f), MathHelpersKt.lerp(ScaleFactor.m4775getScaleYimpl(j), ScaleFactor.m4775getScaleYimpl(j2), f));
    }

    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m4768constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m4788takeOrElseoyDd2qo(long j, Function0<ScaleFactor> function0) {
        return j != ScaleFactor.INSTANCE.m4781getUnspecified_hLwfpc() ? j : function0.invoke().getPackedValue();
    }
}