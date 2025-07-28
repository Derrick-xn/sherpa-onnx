package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u000e*\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "Landroidx/compose/ui/geometry/Offset;", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "", "addPointerInputChange-GcwITfU", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "reset", "", "crossAxis", "crossAxis-k-4lQ0M", "(J)F", "mainAxis", "mainAxis-k-4lQ0M", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange;

    public TouchSlopDetector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TouchSlopDetector(Orientation orientation) {
        this.orientation = orientation;
        this.totalPositionChange = Offset.INSTANCE.m3060getZeroF1C5BW0();
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m532mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3044getXimpl(j) : Offset.m3045getYimpl(j);
    }

    /* renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m531crossAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3045getYimpl(j) : Offset.m3044getXimpl(j);
    }

    /* renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m530addPointerInputChangeGcwITfU(PointerInputChange dragEvent, float touchSlop) {
        float fAbs;
        long jM3049plusMKHz9U = Offset.m3049plusMKHz9U(this.totalPositionChange, Offset.m3048minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = jM3049plusMKHz9U;
        if (this.orientation == null) {
            fAbs = Offset.m3042getDistanceimpl(jM3049plusMKHz9U);
        } else {
            fAbs = Math.abs(m532mainAxisk4lQ0M(jM3049plusMKHz9U));
        }
        if (fAbs >= touchSlop) {
            return Offset.m3033boximpl(m529calculatePostSlopOffsettuRUvjQ(touchSlop));
        }
        return null;
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m3060getZeroF1C5BW0();
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m529calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m3048minusMKHz9U(this.totalPositionChange, Offset.m3051timestuRUvjQ(Offset.m3039divtuRUvjQ(j, Offset.m3042getDistanceimpl(j)), touchSlop));
        }
        float fM532mainAxisk4lQ0M = m532mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m532mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float fM531crossAxisk4lQ0M = m531crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(fM532mainAxisk4lQ0M, fM531crossAxisk4lQ0M);
        }
        return OffsetKt.Offset(fM531crossAxisk4lQ0M, fM532mainAxisk4lQ0M);
    }
}