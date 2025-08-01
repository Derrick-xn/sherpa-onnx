package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/RichTooltipPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltipAnchorPadding", "", "(I)V", "getTooltipAnchorPadding", "()I", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class RichTooltipPositionProvider implements PopupPositionProvider {
    private final int tooltipAnchorPadding;

    public static /* synthetic */ RichTooltipPositionProvider copy$default(RichTooltipPositionProvider richTooltipPositionProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = richTooltipPositionProvider.tooltipAnchorPadding;
        }
        return richTooltipPositionProvider.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTooltipAnchorPadding() {
        return this.tooltipAnchorPadding;
    }

    public final RichTooltipPositionProvider copy(int tooltipAnchorPadding) {
        return new RichTooltipPositionProvider(tooltipAnchorPadding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RichTooltipPositionProvider) && this.tooltipAnchorPadding == ((RichTooltipPositionProvider) other).tooltipAnchorPadding;
    }

    public int hashCode() {
        return this.tooltipAnchorPadding;
    }

    public String toString() {
        return "RichTooltipPositionProvider(tooltipAnchorPadding=" + this.tooltipAnchorPadding + ')';
    }

    public RichTooltipPositionProvider(int i) {
        this.tooltipAnchorPadding = i;
    }

    public final int getTooltipAnchorPadding() {
        return this.tooltipAnchorPadding;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo369calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int right = anchorBounds.getRight();
        if (IntSize.m6018getWidthimpl(popupContentSize) + right > IntSize.m6018getWidthimpl(windowSize) && (right = anchorBounds.getLeft() - IntSize.m6018getWidthimpl(popupContentSize)) < 0) {
            right = anchorBounds.getLeft() + ((anchorBounds.getWidth() - IntSize.m6018getWidthimpl(popupContentSize)) / 2);
        }
        int top = (anchorBounds.getTop() - IntSize.m6017getHeightimpl(popupContentSize)) - this.tooltipAnchorPadding;
        if (top < 0) {
            top = this.tooltipAnchorPadding + anchorBounds.getBottom();
        }
        return IntOffsetKt.IntOffset(right, top);
    }
}