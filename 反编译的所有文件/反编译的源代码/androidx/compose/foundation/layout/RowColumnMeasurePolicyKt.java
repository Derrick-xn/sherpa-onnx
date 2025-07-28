package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.RowColumnMeasurePolicy;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurePolicy.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) throws Throwable {
        int[] iArr2;
        int[] iArr3;
        float f;
        String str;
        long j;
        String str2;
        String str3;
        long j2;
        String str4;
        String str5;
        int i9;
        RowColumnMeasurePolicy rowColumnMeasurePolicy2;
        int i10;
        int iCoerceIn;
        int i11;
        float f2;
        String str6;
        String str7;
        long j3;
        long j4;
        float f3;
        String str8;
        String str9;
        String str10;
        int i12;
        String str11;
        String str12;
        int i13;
        String str13;
        String str14;
        long j5;
        FlowLayoutData flowLayoutData;
        String str15;
        Integer numValueOf;
        int i14;
        Integer num;
        int i15;
        float f4;
        float f5;
        String str16;
        String str17;
        String str18;
        long j6;
        String str19;
        int i16;
        float f6;
        String str20;
        int iMax;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        long j7;
        int[] iArr4;
        int i22;
        int i23;
        float f7;
        int[] iArr5;
        FlowLayoutData flowLayoutData2;
        List<? extends Measurable> list2 = list;
        int i24 = i7;
        int i25 = i24 - i6;
        int[] iArr6 = new int[i25];
        int i26 = i6;
        long j8 = i5;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        float f8 = 0.0f;
        boolean z = false;
        while (true) {
            Integer numValueOf2 = null;
            iArr2 = iArr6;
            if (i26 >= i24) {
                break;
            }
            int i31 = i30;
            Measurable measurable = list2.get(i26);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            z = z || RowColumnImplKt.isRelative(rowColumnParentData);
            if (weight > 0.0f) {
                float f9 = f8 + weight;
                i29++;
                i20 = i26;
                j7 = j8;
                iArr5 = iArr2;
                i23 = i25;
                f7 = f9;
            } else {
                if (i4 != Integer.MAX_VALUE && rowColumnParentData != null && (flowLayoutData2 = rowColumnParentData.getFlowLayoutData()) != null) {
                    numValueOf2 = Integer.valueOf(Math.round(flowLayoutData2.getFillCrossAxisFraction() * i4));
                }
                int i32 = i3 - i28;
                Placeable placeableMo4680measureBRTryo0 = placeableArr[i26];
                if (placeableMo4680measureBRTryo0 == null) {
                    i18 = i28;
                    i19 = i29;
                    int iIntValue = numValueOf2 != null ? numValueOf2.intValue() : 0;
                    i20 = i26;
                    i21 = i32;
                    iArr4 = iArr2;
                    j7 = j8;
                    i22 = i31;
                    i23 = i25;
                    f7 = f8;
                    placeableMo4680measureBRTryo0 = measurable.mo4680measureBRTryo0(RowColumnMeasurePolicy.CC.m736createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy, 0, iIntValue, i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(i32, 0), numValueOf2 != null ? numValueOf2.intValue() : i4, false, 16, null));
                } else {
                    i18 = i28;
                    i19 = i29;
                    i20 = i26;
                    i21 = i32;
                    j7 = j8;
                    iArr4 = iArr2;
                    i22 = i31;
                    i23 = i25;
                    f7 = f8;
                }
                int iMainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeableMo4680measureBRTryo0);
                int iCrossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeableMo4680measureBRTryo0);
                iArr5 = iArr4;
                iArr5[i20 - i6] = iMainAxisSize;
                int iMin = Math.min(i5, RangesKt.coerceAtLeast(i21 - iMainAxisSize, 0));
                i28 = iMainAxisSize + iMin + i18;
                int iMax2 = Math.max(i22, iCrossAxisSize);
                placeableArr[i20] = placeableMo4680measureBRTryo0;
                i31 = iMax2;
                i27 = iMin;
                i29 = i19;
            }
            i26 = i20 + 1;
            iArr6 = iArr5;
            f8 = f7;
            i25 = i23;
            i30 = i31;
            j8 = j7;
        }
        int i33 = i28;
        int i34 = i29;
        int i35 = i30;
        long j9 = j8;
        int i36 = i25;
        float f10 = f8;
        if (i34 == 0) {
            i10 = i33 - i27;
            iArr3 = iArr2;
            i9 = i;
            i11 = i35;
            iCoerceIn = 0;
            rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
        } else {
            int i37 = i3 != Integer.MAX_VALUE ? i3 : i;
            iArr3 = iArr2;
            long j10 = j9 * (i34 - 1);
            long jCoerceAtLeast = RangesKt.coerceAtLeast((i37 - i33) - j10, 0L);
            float f11 = jCoerceAtLeast / f10;
            int i38 = i6;
            long jRound = jCoerceAtLeast;
            while (true) {
                f = f10;
                str = "arrangementSpacingTotal ";
                j = jCoerceAtLeast;
                str2 = "fixedSpace ";
                str3 = "weightChildrenCount ";
                j2 = j10;
                str4 = "targetSpace ";
                str5 = "mainAxisMin ";
                if (i38 >= i24) {
                    break;
                }
                float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list2.get(i38)));
                float f12 = f11 * weight2;
                try {
                    jRound -= Math.round(f12);
                    i38++;
                    list2 = list;
                    i24 = i7;
                    f10 = f;
                    jCoerceAtLeast = j;
                    j10 = j2;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i3 + "mainAxisMin " + i + "targetSpace " + i37 + "arrangementSpacingPx " + j9 + "weightChildrenCount " + i34 + "fixedSpace " + i33 + "arrangementSpacingTotal " + j2 + "remainingToTarget " + j + "totalWeight " + f + "weightUnitSpace " + f11 + "itemWeight " + weight2 + "weightedSize " + f12).initCause(e);
                }
            }
            i9 = i;
            String str21 = "weightedSize ";
            String str22 = "weightUnitSpace ";
            float f13 = f;
            String str23 = "totalWeight ";
            long j11 = j;
            String str24 = "remainingToTarget ";
            long j12 = j2;
            long j13 = j9;
            int iMax3 = i35;
            int i39 = 0;
            int i40 = i6;
            int i41 = i7;
            while (i40 < i41) {
                if (placeableArr[i40] == null) {
                    Measurable measurable2 = list.get(i40);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    String str25 = str4;
                    String str26 = str21;
                    if (i4 == Integer.MAX_VALUE || rowColumnParentData2 == null || (flowLayoutData = rowColumnParentData2.getFlowLayoutData()) == null) {
                        str15 = str5;
                        numValueOf = null;
                    } else {
                        str15 = str5;
                        numValueOf = Integer.valueOf(Math.round(flowLayoutData.getFillCrossAxisFraction() * i4));
                    }
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int sign = MathKt.getSign(jRound);
                    int i42 = i34;
                    int i43 = i33;
                    jRound -= sign;
                    float f14 = f11 * weight3;
                    float f15 = f11;
                    int iMax4 = Math.max(0, Math.round(f14) + sign);
                    try {
                        int i44 = (!RowColumnImplKt.getFill(rowColumnParentData2) || iMax4 == Integer.MAX_VALUE) ? 0 : iMax4;
                        int iIntValue2 = numValueOf != null ? numValueOf.intValue() : 0;
                        int iIntValue3 = numValueOf != null ? numValueOf.intValue() : i4;
                        f6 = f15;
                        i14 = sign;
                        str18 = str25;
                        j6 = j12;
                        int i45 = i44;
                        num = numValueOf;
                        str19 = str15;
                        int i46 = iIntValue2;
                        i15 = iMax4;
                        i16 = i42;
                        f4 = f14;
                        i12 = i43;
                        f5 = weight3;
                        str17 = str3;
                        str20 = str;
                        str16 = str2;
                        j5 = j13;
                        try {
                            Placeable placeableMo4680measureBRTryo02 = measurable2.mo4680measureBRTryo0(rowColumnMeasurePolicy.mo625createConstraintsxF2OJ5Q(i45, i46, iMax4, iIntValue3, true));
                            int iMainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(placeableMo4680measureBRTryo02);
                            int iCrossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(placeableMo4680measureBRTryo02);
                            iArr3[i40 - i6] = iMainAxisSize2;
                            i39 += iMainAxisSize2;
                            iMax3 = Math.max(iMax3, iCrossAxisSize2);
                            placeableArr[i40] = placeableMo4680measureBRTryo02;
                            str13 = str16;
                            str6 = str17;
                            str14 = str20;
                            j4 = j11;
                            f3 = f13;
                            str8 = str22;
                            str9 = str23;
                            str10 = str24;
                            str7 = str26;
                            f2 = f6;
                            j3 = j6;
                            str11 = str18;
                            str12 = str19;
                            i13 = i16;
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i3 + str19 + i9 + str18 + i37 + "arrangementSpacingPx " + j5 + str17 + i16 + str16 + i12 + str20 + j6 + str24 + j11 + str23 + f13 + str22 + f6 + "weight " + f5 + str26 + f4 + "crossAxisDesiredSize " + num + "remainderUnit " + i14 + "childMainAxisSize " + i15).initCause(e);
                        }
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        i14 = sign;
                        num = numValueOf;
                        i15 = iMax4;
                        f4 = f14;
                        f5 = weight3;
                        str16 = str2;
                        str17 = str3;
                        str18 = str25;
                        j6 = j12;
                        str19 = str15;
                        i12 = i43;
                        i16 = i42;
                        f6 = f15;
                        j5 = j13;
                        str20 = str;
                    }
                } else {
                    f2 = f11;
                    str6 = str3;
                    str7 = str21;
                    j3 = j12;
                    j4 = j11;
                    f3 = f13;
                    str8 = str22;
                    str9 = str23;
                    str10 = str24;
                    i12 = i33;
                    str11 = str4;
                    int i47 = i34;
                    str12 = str5;
                    String str27 = str;
                    i13 = i47;
                    long j14 = j13;
                    str13 = str2;
                    str14 = str27;
                    j5 = j14;
                }
                i40++;
                f13 = f3;
                str5 = str12;
                str4 = str11;
                i34 = i13;
                i33 = i12;
                f11 = f2;
                str21 = str7;
                str22 = str8;
                j12 = j3;
                j11 = j4;
                str23 = str9;
                str24 = str10;
                str = str14;
                String str28 = str6;
                i41 = i7;
                long j15 = j5;
                str3 = str28;
                str2 = str13;
                j13 = j15;
            }
            rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
            i10 = i33;
            iCoerceIn = RangesKt.coerceIn((int) (i39 + j12), 0, i3 - i10);
            i11 = iMax3;
        }
        if (z) {
            int iMax5 = 0;
            iMax = 0;
            for (int i48 = i6; i48 < i7; i48++) {
                Placeable placeable = placeableArr[i48];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable));
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    int iIntValue4 = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    int iCrossAxisSize3 = rowColumnMeasurePolicy2.crossAxisSize(placeable);
                    iMax5 = Math.max(iMax5, iIntValue4 != Integer.MIN_VALUE ? numCalculateAlignmentLinePosition$foundation_layout_release.intValue() : 0);
                    if (iIntValue4 == Integer.MIN_VALUE) {
                        iIntValue4 = iCrossAxisSize3;
                    }
                    iMax = Math.max(iMax, iCrossAxisSize3 - iIntValue4);
                }
            }
            i17 = iMax5;
        } else {
            iMax = 0;
            i17 = 0;
        }
        int iMax6 = Math.max(RangesKt.coerceAtLeast(i10 + iCoerceIn, 0), i9);
        int iMax7 = Math.max(i11, Math.max(i2, iMax + i17));
        int[] iArr7 = new int[i36];
        for (int i49 = 0; i49 < i36; i49++) {
            iArr7[i49] = 0;
        }
        rowColumnMeasurePolicy2.populateMainAxisPositions(iMax6, iArr3, iArr7, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, i17, iArr7, iMax6, iMax7, iArr, i8, i6, i7);
    }
}