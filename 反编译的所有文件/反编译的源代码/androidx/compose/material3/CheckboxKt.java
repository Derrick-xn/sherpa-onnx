package androidx.compose.material3;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m5844constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Checkbox(final boolean r29, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.CheckboxColors r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TriStateCheckbox(final androidx.compose.ui.state.ToggleableState r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.material3.CheckboxColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bd A[LOOP:0: B:107:0x02bb->B:108:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CheckboxImpl(final boolean r35, final androidx.compose.ui.state.ToggleableState r36, final androidx.compose.ui.Modifier r37, final androidx.compose.material3.CheckboxColors r38, androidx.compose.runtime.Composer r39, final int r40) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material3.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m1517drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float fM3113getWidthimpl = Size.m3113getWidthimpl(drawScope.mo3806getSizeNHjbRc());
        if (Color.m3325equalsimpl0(j, j2)) {
            DrawScope.CC.m3893drawRoundRectuAw5IA$default(drawScope, j, 0L, SizeKt.Size(fM3113getWidthimpl, fM3113getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f4 = fM3113getWidthimpl - (2 * f2);
        DrawScope.CC.m3893drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f2, f2), SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = fM3113getWidthimpl - f2;
        DrawScope.CC.m3893drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f3, f3), SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m1518drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m3688getSquareKaPHkGw(), 0, null, 26, null);
        float fM3113getWidthimpl = Size.m3113getWidthimpl(drawScope.mo3806getSizeNHjbRc());
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fM3113getWidthimpl, fLerp3 * fM3113getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fM3113getWidthimpl, fLerp2 * fM3113getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fM3113getWidthimpl, fM3113getWidthimpl * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.CC.m3887drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m5844constructorimpl(f);
        StrokeWidth = Dp.m5844constructorimpl(f);
        RadiusSize = Dp.m5844constructorimpl(f);
    }
}