package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo114measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM607findSizeToXhtMw = m607findSizeToXhtMw(j);
        if (!IntSize.m6016equalsimpl0(jM607findSizeToXhtMw, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m5797fixedJhjzzOo(IntSize.m6018getWidthimpl(jM607findSizeToXhtMw), IntSize.m6017getHeightimpl(jM607findSizeToXhtMw));
        }
        final Placeable placeableMo4680measureBRTryo0 = measurable.mo4680measureBRTryo0(j);
        return MeasureScope.CC.layout$default(measureScope, placeableMo4680measureBRTryo0.getWidth(), placeableMo4680measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo4680measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m607findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM611tryMaxWidthJN0ABg$default = m611tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM611tryMaxWidthJN0ABg$default, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM611tryMaxWidthJN0ABg$default;
            }
            long jM609tryMaxHeightJN0ABg$default = m609tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM609tryMaxHeightJN0ABg$default, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM609tryMaxHeightJN0ABg$default;
            }
            long jM615tryMinWidthJN0ABg$default = m615tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM615tryMinWidthJN0ABg$default, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM615tryMinWidthJN0ABg$default;
            }
            long jM613tryMinHeightJN0ABg$default = m613tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM613tryMinHeightJN0ABg$default, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM613tryMinHeightJN0ABg$default;
            }
            long jM610tryMaxWidthJN0ABg = m610tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM610tryMaxWidthJN0ABg, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM610tryMaxWidthJN0ABg;
            }
            long jM608tryMaxHeightJN0ABg = m608tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM608tryMaxHeightJN0ABg, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM608tryMaxHeightJN0ABg;
            }
            long jM614tryMinWidthJN0ABg = m614tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM614tryMinWidthJN0ABg, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM614tryMinWidthJN0ABg;
            }
            long jM612tryMinHeightJN0ABg = m612tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM612tryMinHeightJN0ABg, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM612tryMinHeightJN0ABg;
            }
        } else {
            long jM609tryMaxHeightJN0ABg$default2 = m609tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM609tryMaxHeightJN0ABg$default2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM609tryMaxHeightJN0ABg$default2;
            }
            long jM611tryMaxWidthJN0ABg$default2 = m611tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM611tryMaxWidthJN0ABg$default2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM611tryMaxWidthJN0ABg$default2;
            }
            long jM613tryMinHeightJN0ABg$default2 = m613tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM613tryMinHeightJN0ABg$default2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM613tryMinHeightJN0ABg$default2;
            }
            long jM615tryMinWidthJN0ABg$default2 = m615tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m6016equalsimpl0(jM615tryMinWidthJN0ABg$default2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM615tryMinWidthJN0ABg$default2;
            }
            long jM608tryMaxHeightJN0ABg2 = m608tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM608tryMaxHeightJN0ABg2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM608tryMaxHeightJN0ABg2;
            }
            long jM610tryMaxWidthJN0ABg2 = m610tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM610tryMaxWidthJN0ABg2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM610tryMaxWidthJN0ABg2;
            }
            long jM612tryMinHeightJN0ABg2 = m612tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM612tryMinHeightJN0ABg2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM612tryMinHeightJN0ABg2;
            }
            long jM614tryMinWidthJN0ABg2 = m614tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6016equalsimpl0(jM614tryMinWidthJN0ABg2, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
                return jM614tryMinWidthJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m6023getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m611tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m610tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m610tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM5787getMaxWidthimpl = Constraints.m5787getMaxWidthimpl(j);
        if (iM5787getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM5787getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM5787getMaxWidthimpl, iRound);
            if (!z || ConstraintsKt.m5805isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m6023getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m609tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m608tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m608tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM5786getMaxHeightimpl = Constraints.m5786getMaxHeightimpl(j);
        if (iM5786getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM5786getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM5786getMaxHeightimpl);
            if (!z || ConstraintsKt.m5805isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m6023getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m615tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m614tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m614tryMinWidthJN0ABg(long j, boolean z) {
        int iM5789getMinWidthimpl = Constraints.m5789getMinWidthimpl(j);
        int iRound = Math.round(iM5789getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM5789getMinWidthimpl, iRound);
            if (!z || ConstraintsKt.m5805isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m6023getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m613tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m612tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m612tryMinHeightJN0ABg(long j, boolean z) {
        int iM5788getMinHeightimpl = Constraints.m5788getMinHeightimpl(j);
        int iRound = Math.round(iM5788getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM5788getMinHeightimpl);
            if (!z || ConstraintsKt.m5805isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m6023getZeroYbymL2g();
    }
}