package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.IntSize;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002\u001a4\u0010 \u001a\u00020\u0001*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001a0#j\b\u0012\u0004\u0012\u00020\u001a`$2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0001H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "isSelected", "", "currentDirection", "otherDirection", "appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "localPosition", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getDirectionById", "anchorSelectableId", "currentSelectableId", "getPreviousAdjustedOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentTextLength", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: appendSelectableInfo-Parwq6A, reason: not valid java name */
    public static final void m1367appendSelectableInfoParwq6A(SelectionLayoutBuilder selectionLayoutBuilder, TextLayoutResult textLayoutResult, long j, long j2, long j3) {
        Direction directionAppendSelectableInfo_Parwq6A$otherDirection;
        Direction direction;
        Direction direction2;
        Direction direction3;
        Direction direction4;
        int previousAdjustedOffset;
        int previousAdjustedOffset2;
        Selection.AnchorInfo start;
        Selection.AnchorInfo end;
        Rect rect = new Rect(0.0f, 0.0f, IntSize.m6018getWidthimpl(textLayoutResult.getSize()), IntSize.m6017getHeightimpl(textLayoutResult.getSize()));
        Direction directionM1369getXDirection3MmeM6k = m1369getXDirection3MmeM6k(j, rect);
        Direction directionM1370getYDirection3MmeM6k = m1370getYDirection3MmeM6k(j, rect);
        if (selectionLayoutBuilder.getIsStartHandle()) {
            Selection previousSelection = selectionLayoutBuilder.getPreviousSelection();
            directionAppendSelectableInfo_Parwq6A$otherDirection = appendSelectableInfo_Parwq6A$otherDirection(directionM1369getXDirection3MmeM6k, directionM1370getYDirection3MmeM6k, selectionLayoutBuilder, j3, previousSelection != null ? previousSelection.getEnd() : null);
            direction3 = directionAppendSelectableInfo_Parwq6A$otherDirection;
            direction4 = direction3;
            direction = directionM1369getXDirection3MmeM6k;
            direction2 = directionM1370getYDirection3MmeM6k;
        } else {
            Selection previousSelection2 = selectionLayoutBuilder.getPreviousSelection();
            directionAppendSelectableInfo_Parwq6A$otherDirection = appendSelectableInfo_Parwq6A$otherDirection(directionM1369getXDirection3MmeM6k, directionM1370getYDirection3MmeM6k, selectionLayoutBuilder, j3, previousSelection2 != null ? previousSelection2.getStart() : null);
            direction = directionAppendSelectableInfo_Parwq6A$otherDirection;
            direction2 = direction;
            direction3 = directionM1369getXDirection3MmeM6k;
            direction4 = directionM1370getYDirection3MmeM6k;
        }
        if (isSelected(SelectionLayoutKt.resolve2dDirection(directionM1369getXDirection3MmeM6k, directionM1370getYDirection3MmeM6k), directionAppendSelectableInfo_Parwq6A$otherDirection)) {
            int length = textLayoutResult.getLayoutInput().getText().length();
            if (selectionLayoutBuilder.getIsStartHandle()) {
                int iM1368getOffsetForPosition3MmeM6k = m1368getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection3 = selectionLayoutBuilder.getPreviousSelection();
                previousAdjustedOffset2 = iM1368getOffsetForPosition3MmeM6k;
                previousAdjustedOffset = (previousSelection3 == null || (end = previousSelection3.getEnd()) == null) ? iM1368getOffsetForPosition3MmeM6k : getPreviousAdjustedOffset(end, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j3, length);
            } else {
                int iM1368getOffsetForPosition3MmeM6k2 = m1368getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection4 = selectionLayoutBuilder.getPreviousSelection();
                previousAdjustedOffset = iM1368getOffsetForPosition3MmeM6k2;
                previousAdjustedOffset2 = (previousSelection4 == null || (start = previousSelection4.getStart()) == null) ? iM1368getOffsetForPosition3MmeM6k2 : getPreviousAdjustedOffset(start, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j3, length);
            }
            selectionLayoutBuilder.appendInfo(j3, previousAdjustedOffset2, direction, direction2, previousAdjustedOffset, direction3, direction4, OffsetKt.m3065isUnspecifiedk4lQ0M(j2) ? -1 : m1368getOffsetForPosition3MmeM6k(j2, textLayoutResult), textLayoutResult);
        }
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction direction, Direction direction2, SelectionLayoutBuilder selectionLayoutBuilder, long j, Selection.AnchorInfo anchorInfo) {
        Direction directionById;
        return (anchorInfo == null || (directionById = getDirectionById(selectionLayoutBuilder, anchorInfo.getSelectableId(), j)) == null) ? SelectionLayoutKt.resolve2dDirection(direction, direction2) : directionById;
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo anchorInfo, Comparator<Long> comparator, long j, int i) {
        int iCompare = comparator.compare(Long.valueOf(anchorInfo.getSelectableId()), Long.valueOf(j));
        if (iCompare < 0) {
            return 0;
        }
        return iCompare > 0 ? i : anchorInfo.getOffset();
    }

    /* renamed from: getXDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m1369getXDirection3MmeM6k(long j, Rect rect) {
        return Offset.m3044getXimpl(j) < rect.getLeft() ? Direction.BEFORE : Offset.m3044getXimpl(j) > rect.getRight() ? Direction.AFTER : Direction.ON;
    }

    /* renamed from: getYDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m1370getYDirection3MmeM6k(long j, Rect rect) {
        return Offset.m3045getYimpl(j) < rect.getTop() ? Direction.BEFORE : Offset.m3045getYimpl(j) > rect.getBottom() ? Direction.AFTER : Direction.ON;
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder selectionLayoutBuilder, long j, long j2) {
        int iCompare = selectionLayoutBuilder.getSelectableIdOrderingComparator().compare(Long.valueOf(j), Long.valueOf(j2));
        if (iCompare < 0) {
            return Direction.BEFORE;
        }
        if (iCompare > 0) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final boolean isSelected(Direction direction, Direction direction2) {
        return direction == Direction.ON || direction != direction2;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    private static final int m1368getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        if (Offset.m3045getYimpl(j) <= 0.0f) {
            return 0;
        }
        return Offset.m3045getYimpl(j) >= textLayoutResult.getMultiParagraph().getHeight() ? textLayoutResult.getLayoutInput().getText().length() : textLayoutResult.m5270getOffsetForPositionk4lQ0M(j);
    }
}