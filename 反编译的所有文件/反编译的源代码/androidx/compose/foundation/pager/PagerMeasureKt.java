package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m960measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        int i11;
        int i12;
        int i13;
        MeasuredPage measuredPage;
        int i14;
        long j3;
        int i15;
        List<MeasuredPage> list2;
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        if (i3 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m5789getMinWidthimpl(j)), Integer.valueOf(Constraints.m5788getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        final long jConstraints$default = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.m5787getMaxWidthimpl(j) : i8, 0, orientation != Orientation.Vertical ? Constraints.m5786getMaxHeightimpl(j) : i8, 5, null);
        int i16 = i6;
        int i17 = i7;
        while (i16 > 0 && i17 > 0) {
            i16--;
            i17 -= iCoerceAtLeast;
        }
        int i18 = i17 * (-1);
        if (i16 >= i) {
            i16 = i - 1;
            i18 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i19 = -i3;
        int i20 = (i5 < 0 ? i5 : 0) + i19;
        int i21 = i18 + i20;
        int iMax = 0;
        while (i21 < 0 && i16 > 0) {
            int i22 = i16 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            int i23 = iCoerceAtLeast;
            MeasuredPage measuredPageM959getAndMeasureSGf7dI0 = m959getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i22, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            arrayDeque2.add(0, measuredPageM959getAndMeasureSGf7dI0);
            iMax = Math.max(iMax, measuredPageM959getAndMeasureSGf7dI0.getCrossAxisSize());
            i21 += i23;
            i16 = i22;
            i20 = i20;
            arrayDeque = arrayDeque2;
            iCoerceAtLeast = i23;
            i19 = i19;
        }
        int i24 = i21;
        int i25 = i19;
        int i26 = i20;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i27 = iCoerceAtLeast;
        int i28 = (i24 < i26 ? i26 : i24) - i26;
        int i29 = i2 + i4;
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i29, 0);
        int i30 = -i28;
        int i31 = i16;
        int i32 = 0;
        boolean z2 = false;
        while (i32 < arrayDeque3.size()) {
            if (i30 >= iCoerceAtLeast2) {
                arrayDeque3.remove(i32);
                z2 = true;
            } else {
                i31++;
                i30 += i27;
                i32++;
            }
        }
        int i33 = i16;
        int i34 = i28;
        boolean z3 = z2;
        int i35 = i31;
        int i36 = i30;
        while (i35 < i && (i36 < iCoerceAtLeast2 || i36 <= 0 || arrayDeque3.isEmpty())) {
            int i37 = i29;
            int i38 = i35;
            int i39 = i33;
            int i40 = iCoerceAtLeast2;
            int i41 = i36;
            int i42 = i27;
            MeasuredPage measuredPageM959getAndMeasureSGf7dI02 = m959getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i35, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            int i43 = i - 1;
            i36 = (i38 == i43 ? i8 : i42) + i41;
            if (i36 > i26 || i38 == i43) {
                iMax = Math.max(iMax, measuredPageM959getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque3.add(measuredPageM959getAndMeasureSGf7dI02);
                i33 = i39;
            } else {
                i34 -= i42;
                i33 = i38 + 1;
                z3 = true;
            }
            i35 = i38 + 1;
            i29 = i37;
            i27 = i42;
            iCoerceAtLeast2 = i40;
        }
        int i44 = i33;
        int i45 = i29;
        int i46 = i35;
        int i47 = i36;
        int i48 = i27;
        if (i47 < i2) {
            int i49 = i2 - i47;
            int i50 = i34 - i49;
            int i51 = i49 + i47;
            int i52 = i3;
            i13 = i44;
            int i53 = i48;
            int i54 = i50;
            while (i54 < i52 && i13 > 0) {
                i13--;
                int i55 = i53;
                MeasuredPage measuredPageM959getAndMeasureSGf7dI03 = m959getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i13, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                arrayDeque3.add(0, measuredPageM959getAndMeasureSGf7dI03);
                iMax = Math.max(iMax, measuredPageM959getAndMeasureSGf7dI03.getCrossAxisSize());
                i54 += i55;
                i52 = i3;
                i53 = i55;
            }
            i10 = i53;
            if (i54 < 0) {
                i11 = i51 + i54;
                i12 = 0;
            } else {
                i12 = i54;
                i11 = i51;
            }
        } else {
            i10 = i48;
            i11 = i47;
            i12 = i34;
            i13 = i44;
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
        }
        int i56 = -i12;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            int i57 = i12;
            int i58 = 0;
            while (i58 < size && i57 != 0 && i10 <= i57 && i58 != CollectionsKt.getLastIndex(arrayDeque3)) {
                i57 -= i10;
                i58++;
                measuredPage2 = (MeasuredPage) arrayDeque3.get(i58);
            }
            measuredPage = measuredPage2;
            i14 = i57;
        } else {
            i14 = i12;
            measuredPage = measuredPage2;
        }
        MeasuredPage measuredPage3 = measuredPage;
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(i13, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i59) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m959getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i59, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
            }
        });
        int size2 = listCreatePagesBeforeList.size();
        for (int i59 = 0; i59 < size2; i59++) {
            iMax = Math.max(iMax, listCreatePagesBeforeList.get(i59).getCrossAxisSize());
        }
        int i60 = iMax;
        int i61 = i10;
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque3.last()).getIndex(), i, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i62) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m959getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i62, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
            }
        });
        int size3 = listCreatePagesAfterList.size();
        int iMax2 = i60;
        for (int i62 = 0; i62 < size3; i62++) {
            iMax2 = Math.max(iMax2, listCreatePagesAfterList.get(i62).getCrossAxisSize());
        }
        boolean z4 = Intrinsics.areEqual(measuredPage3, arrayDeque3.first()) && listCreatePagesBeforeList.isEmpty() && listCreatePagesAfterList.isEmpty();
        if (orientation == Orientation.Vertical) {
            j3 = j;
            i15 = iMax2;
        } else {
            j3 = j;
            i15 = i11;
        }
        int iM5804constrainWidthK40F9xA = ConstraintsKt.m5804constrainWidthK40F9xA(j3, i15);
        if (orientation == Orientation.Vertical) {
            iMax2 = i11;
        }
        int iM5803constrainHeightK40F9xA = ConstraintsKt.m5803constrainHeightK40F9xA(j3, iMax2);
        final List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque3, listCreatePagesBeforeList, listCreatePagesAfterList, iM5804constrainWidthK40F9xA, iM5803constrainHeightK40F9xA, i11, i2, i56, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z4) {
            list2 = listCalculatePagesOffsets;
        } else {
            ArrayList arrayList = new ArrayList(listCalculatePagesOffsets.size());
            int size4 = listCalculatePagesOffsets.size();
            for (int i63 = 0; i63 < size4; i63++) {
                MeasuredPage measuredPage4 = listCalculatePagesOffsets.get(i63);
                MeasuredPage measuredPage5 = measuredPage4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque3.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList.add(measuredPage4);
                }
            }
            list2 = arrayList;
        }
        if (listCreatePagesBeforeList.isEmpty()) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(listCalculatePagesOffsets.size());
            int size5 = listCalculatePagesOffsets.size();
            for (int i64 = 0; i64 < size5; i64++) {
                MeasuredPage measuredPage6 = listCalculatePagesOffsets.get(i64);
                if (measuredPage6.getIndex() < ((MeasuredPage) arrayDeque3.first()).getIndex()) {
                    arrayList2.add(measuredPage6);
                }
            }
            arrayListEmptyList = arrayList2;
        }
        List list3 = arrayListEmptyList;
        if (listCreatePagesAfterList.isEmpty()) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(listCalculatePagesOffsets.size());
            int size6 = listCalculatePagesOffsets.size();
            for (int i65 = 0; i65 < size6; i65++) {
                MeasuredPage measuredPage7 = listCalculatePagesOffsets.get(i65);
                if (measuredPage7.getIndex() > ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList3.add(measuredPage7);
                }
            }
            arrayListEmptyList2 = arrayList3;
        }
        List list4 = arrayListEmptyList2;
        int i66 = i11;
        MeasuredPage measuredPageCalculateNewCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? iM5803constrainHeightK40F9xA : iM5804constrainWidthK40F9xA, list2, i3, i4, i61, snapPosition, i);
        return new PagerMeasureResult(list2, i8, i5, i4, orientation, i25, i45, z, i9, measuredPage3, measuredPageCalculateNewCurrentPage, i61 == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(i2, i8, i3, i4, measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getIndex() : 0, i) - (measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getOffset() : 0)) / i61, -0.5f, 0.5f), i14, i46 < i || i66 > i2, snapPosition, function3.invoke(Integer.valueOf(iM5804constrainWidthK40F9xA), Integer.valueOf(iM5803constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                List<MeasuredPage> list5 = listCalculatePagesOffsets;
                int size7 = list5.size();
                for (int i67 = 0; i67 < size7; i67++) {
                    list5.get(i67).place(placementScope);
                }
                ObservableScopeInvalidator.m892attachToScopeimpl(mutableState);
            }
        }), z3, list3, list4, coroutineScope);
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMin = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == iMin) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = list.get(i5).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = list.get(i4).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m959getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo881measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i5;
        int i11 = i7 + i6;
        if (orientation == Orientation.Vertical) {
            i8 = i4;
            i9 = i2;
        } else {
            i8 = i4;
            i9 = i;
        }
        boolean z2 = i3 < Math.min(i9, i8);
        if (z2 && i10 != 0) {
            throw new IllegalStateException(("non-zero pagesScrollOffset=" + i10).toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = i7;
            }
            int[] iArr2 = new int[size];
            for (int i13 = 0; i13 < size; i13++) {
                iArr2[i13] = 0;
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM590spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m590spacedBy0680j_4(lazyLayoutMeasureScope.mo394toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                horizontalOrVerticalM590spacedBy0680j_4.arrange(density, i9, iArr, iArr2);
            } else {
                horizontalOrVerticalM590spacedBy0680j_4.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size2 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        size2 = (i9 - size2) - measuredPage.getSize();
                    }
                    measuredPage.position(size2, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int i14 = i10;
            for (int i15 = 0; i15 < size3; i15++) {
                MeasuredPage measuredPage2 = list2.get(i15);
                i14 -= i11;
                measuredPage2.position(i14, i, i2);
                arrayList.add(measuredPage2);
            }
            int size4 = list.size();
            for (int i16 = 0; i16 < size4; i16++) {
                MeasuredPage measuredPage3 = list.get(i16);
                measuredPage3.position(i10, i, i2);
                arrayList.add(measuredPage3);
                i10 += i11;
            }
            int size5 = list3.size();
            for (int i17 = 0; i17 < size5; i17++) {
                MeasuredPage measuredPage4 = list3.get(i17);
                measuredPage4.position(i10, i, i2);
                arrayList.add(measuredPage4);
                i10 += i11;
            }
        }
        return arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        measuredPage2 = measuredPage4;
                        f = f2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}