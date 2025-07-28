package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH¦@¢\u0006\u0002\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "<anonymous parameter 0>", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents$annotations", "()V", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PointerInputScope extends Density {
    <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation);

    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    long mo388getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* renamed from: getSize-YbymL2g */
    long mo389getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean z);

    /* compiled from: SuspendingPointerInputFilter.kt */
    /* renamed from: androidx.compose.ui.input.pointer.PointerInputScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getInterceptOutOfBoundsChildEvents(PointerInputScope _this) {
            return false;
        }

        public static void $default$setInterceptOutOfBoundsChildEvents(PointerInputScope _this, boolean z) {
        }

        /* renamed from: $default$getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m4574$default$getExtendedTouchPaddingNHjbRc(PointerInputScope _this) {
            return Size.INSTANCE.m3122getZeroNHjbRc();
        }
    }

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4589roundToPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return Density.CC.m5808$default$roundToPxR2X_6o(pointerInputScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4590roundToPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return Density.CC.m5809$default$roundToPx0680j_4(pointerInputScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4591toDpGaN1DYA(PointerInputScope pointerInputScope, long j) {
            return FontScaling.CC.m5953$default$toDpGaN1DYA(pointerInputScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4592toDpu2uoSUM(PointerInputScope pointerInputScope, float f) {
            return Density.CC.m5810$default$toDpu2uoSUM(pointerInputScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4593toDpu2uoSUM(PointerInputScope pointerInputScope, int i) {
            return Density.CC.m5811$default$toDpu2uoSUM((Density) pointerInputScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4594toDpSizekrfVVM(PointerInputScope pointerInputScope, long j) {
            return Density.CC.m5812$default$toDpSizekrfVVM(pointerInputScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4595toPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return Density.CC.m5813$default$toPxR2X_6o(pointerInputScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4596toPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return Density.CC.m5814$default$toPx0680j_4(pointerInputScope, f);
        }

        @Deprecated
        public static Rect toRect(PointerInputScope pointerInputScope, DpRect dpRect) {
            return Density.CC.$default$toRect(pointerInputScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4597toSizeXkaWNTQ(PointerInputScope pointerInputScope, long j) {
            return Density.CC.m5815$default$toSizeXkaWNTQ(pointerInputScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4598toSp0xMU5do(PointerInputScope pointerInputScope, float f) {
            return FontScaling.CC.m5954$default$toSp0xMU5do(pointerInputScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4599toSpkPz2Gy4(PointerInputScope pointerInputScope, float f) {
            return Density.CC.m5816$default$toSpkPz2Gy4(pointerInputScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4600toSpkPz2Gy4(PointerInputScope pointerInputScope, int i) {
            return Density.CC.m5817$default$toSpkPz2Gy4((Density) pointerInputScope, i);
        }

        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m4588getExtendedTouchPaddingNHjbRc(PointerInputScope pointerInputScope) {
            return CC.m4574$default$getExtendedTouchPaddingNHjbRc(pointerInputScope);
        }

        @Deprecated
        public static boolean getInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope) {
            return CC.$default$getInterceptOutOfBoundsChildEvents(pointerInputScope);
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope, boolean z) {
            CC.$default$setInterceptOutOfBoundsChildEvents(pointerInputScope, z);
        }
    }
}