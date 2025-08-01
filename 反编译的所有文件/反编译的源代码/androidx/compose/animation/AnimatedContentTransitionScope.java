package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#JO\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJO\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020 *\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H¦\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0001$ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {
    Alignment getContentAlignment();

    ExitTransition getKeepUntilTransitionsFinished(ExitTransition.Companion companion);

    /* renamed from: slideIntoContainer-mOhB8PU, reason: not valid java name */
    EnterTransition mo62slideIntoContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffset);

    /* renamed from: slideOutOfContainer-mOhB8PU, reason: not valid java name */
    ExitTransition mo63slideOutOfContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffset);

    ContentTransform using(ContentTransform contentTransform, SizeTransform sizeTransform);

    /* compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class SlideDirection {
        private final int value;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Left = m67constructorimpl(0);
        private static final int Right = m67constructorimpl(1);
        private static final int Up = m67constructorimpl(2);
        private static final int Down = m67constructorimpl(3);
        private static final int Start = m67constructorimpl(4);
        private static final int End = m67constructorimpl(5);

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SlideDirection m66boximpl(int i) {
            return new SlideDirection(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m67constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m68equalsimpl(int i, Object obj) {
            return (obj instanceof SlideDirection) && i == ((SlideDirection) obj).getValue();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m69equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m70hashCodeimpl(int i) {
            return i;
        }

        public boolean equals(Object obj) {
            return m68equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m70hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* compiled from: AnimatedContent.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "()V", "Down", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getDown-DKzdypw", "()I", "I", "End", "getEnd-DKzdypw", "Left", "getLeft-DKzdypw", "Right", "getRight-DKzdypw", "Start", "getStart-DKzdypw", "Up", "getUp-DKzdypw", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getLeft-DKzdypw, reason: not valid java name */
            public final int m75getLeftDKzdypw() {
                return SlideDirection.Left;
            }

            /* renamed from: getRight-DKzdypw, reason: not valid java name */
            public final int m76getRightDKzdypw() {
                return SlideDirection.Right;
            }

            /* renamed from: getUp-DKzdypw, reason: not valid java name */
            public final int m78getUpDKzdypw() {
                return SlideDirection.Up;
            }

            /* renamed from: getDown-DKzdypw, reason: not valid java name */
            public final int m73getDownDKzdypw() {
                return SlideDirection.Down;
            }

            /* renamed from: getStart-DKzdypw, reason: not valid java name */
            public final int m77getStartDKzdypw() {
                return SlideDirection.Start;
            }

            /* renamed from: getEnd-DKzdypw, reason: not valid java name */
            public final int m74getEndDKzdypw() {
                return SlideDirection.End;
            }
        }

        private /* synthetic */ SlideDirection(int i) {
            this.value = i;
        }

        public String toString() {
            return m71toStringimpl(this.value);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m71toStringimpl(int i) {
            return m69equalsimpl0(i, Left) ? "Left" : m69equalsimpl0(i, Right) ? "Right" : m69equalsimpl0(i, Up) ? "Up" : m69equalsimpl0(i, Down) ? "Down" : m69equalsimpl0(i, Start) ? "Start" : m69equalsimpl0(i, End) ? "End" : "Invalid";
        }
    }

    /* compiled from: AnimatedContent.kt */
    /* renamed from: androidx.compose.animation.AnimatedContentTransitionScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: slideIntoContainer-mOhB8PU$default, reason: not valid java name */
        public static /* synthetic */ EnterTransition m64slideIntoContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
            }
            if ((i2 & 2) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
            }
            if ((i2 & 4) != 0) {
                function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScope$slideIntoContainer$1
                    public final Integer invoke(int i3) {
                        return Integer.valueOf(i3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
            }
            return animatedContentTransitionScope.mo62slideIntoContainermOhB8PU(i, finiteAnimationSpec, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: slideOutOfContainer-mOhB8PU$default, reason: not valid java name */
        public static /* synthetic */ ExitTransition m65slideOutOfContainermOhB8PU$default(AnimatedContentTransitionScope animatedContentTransitionScope, int i, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
            }
            if ((i2 & 2) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5967boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
            }
            if ((i2 & 4) != 0) {
                function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScope$slideOutOfContainer$1
                    public final Integer invoke(int i3) {
                        return Integer.valueOf(i3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
            }
            return animatedContentTransitionScope.mo63slideOutOfContainermOhB8PU(i, finiteAnimationSpec, function1);
        }
    }
}