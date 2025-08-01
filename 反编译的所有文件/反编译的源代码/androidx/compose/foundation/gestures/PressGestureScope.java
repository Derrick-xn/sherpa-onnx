package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    /* renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    /* compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m492roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m5808$default$roundToPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m493roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m5809$default$roundToPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m494toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return FontScaling.CC.m5953$default$toDpGaN1DYA(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m495toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m5810$default$toDpu2uoSUM(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m496toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m5811$default$toDpu2uoSUM((Density) pressGestureScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m497toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m5812$default$toDpSizekrfVVM(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m498toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m5813$default$toPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m499toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m5814$default$toPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            return Density.CC.$default$toRect(pressGestureScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m500toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m5815$default$toSizeXkaWNTQ(pressGestureScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m501toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return FontScaling.CC.m5954$default$toSp0xMU5do(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m502toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m5816$default$toSpkPz2Gy4(pressGestureScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m503toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m5817$default$toSpkPz2Gy4((Density) pressGestureScope, i);
        }
    }
}