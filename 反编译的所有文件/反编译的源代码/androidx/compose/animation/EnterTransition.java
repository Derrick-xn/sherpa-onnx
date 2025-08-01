package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0087\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/EnterTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "enter", "toString", "", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EnterTransition {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EnterTransition None = new EnterTransitionImpl(new TransitionData(null, null, null, null, false, null, 63, null));

    public /* synthetic */ EnterTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: getData$animation_release */
    public abstract TransitionData getData();

    private EnterTransition() {
    }

    public final EnterTransition plus(EnterTransition enter) {
        Fade fade = enter.getData().getFade();
        if (fade == null) {
            fade = getData().getFade();
        }
        Fade fade2 = fade;
        Slide slide = enter.getData().getSlide();
        if (slide == null) {
            slide = getData().getSlide();
        }
        Slide slide2 = slide;
        ChangeSize changeSize = enter.getData().getChangeSize();
        if (changeSize == null) {
            changeSize = getData().getChangeSize();
        }
        ChangeSize changeSize2 = changeSize;
        Scale scale = enter.getData().getScale();
        if (scale == null) {
            scale = getData().getScale();
        }
        return new EnterTransitionImpl(new TransitionData(fade2, slide2, changeSize2, scale, false, MapsKt.plus(getData().getEffectsMap(), enter.getData().getEffectsMap()), 16, null));
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None)) {
            return "EnterTransition.None";
        }
        TransitionData data$animation_release = getData();
        StringBuilder sb = new StringBuilder("EnterTransition: \nFade - ");
        Fade fade = data$animation_release.getFade();
        sb.append(fade != null ? fade.toString() : null);
        sb.append(",\nSlide - ");
        Slide slide = data$animation_release.getSlide();
        sb.append(slide != null ? slide.toString() : null);
        sb.append(",\nShrink - ");
        ChangeSize changeSize = data$animation_release.getChangeSize();
        sb.append(changeSize != null ? changeSize.toString() : null);
        sb.append(",\nScale - ");
        Scale scale = data$animation_release.getScale();
        sb.append(scale != null ? scale.toString() : null);
        return sb.toString();
    }

    public boolean equals(Object other) {
        return (other instanceof EnterTransition) && Intrinsics.areEqual(((EnterTransition) other).getData(), getData());
    }

    public int hashCode() {
        return getData().hashCode();
    }

    /* compiled from: EnterExitTransition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/EnterTransition$Companion;", "", "()V", "None", "Landroidx/compose/animation/EnterTransition;", "getNone", "()Landroidx/compose/animation/EnterTransition;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnterTransition getNone() {
            return EnterTransition.None;
        }
    }
}