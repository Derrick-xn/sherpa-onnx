package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* renamed from: roundToPx--R2X_6o */
    int mo390roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4 */
    int mo391roundToPx0680j_4(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo393toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo394toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM */
    long mo395toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o */
    float mo396toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4 */
    float mo397toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ */
    long mo398toSizeXkaWNTQ(long j);

    /* renamed from: toSp-kPz2Gy4 */
    long mo400toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4 */
    long mo401toSpkPz2Gy4(int i);

    /* compiled from: Density.kt */
    /* renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m5814$default$toPx0680j_4(Density _this, float f) {
            return f * _this.getDensity();
        }

        /* renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m5809$default$roundToPx0680j_4(Density _this, float f) {
            float fMo397toPx0680j_4 = _this.mo397toPx0680j_4(f);
            if (Float.isInfinite(fMo397toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return Math.round(fMo397toPx0680j_4);
        }

        /* renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m5813$default$toPxR2X_6o(Density _this, long j) {
            if (!TextUnitType.m6069equalsimpl0(TextUnit.m6040getTypeUIouoOA(j), TextUnitType.INSTANCE.m6074getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return _this.mo397toPx0680j_4(_this.mo392toDpGaN1DYA(j));
        }

        /* renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m5808$default$roundToPxR2X_6o(Density _this, long j) {
            return Math.round(_this.mo396toPxR2X_6o(j));
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m5811$default$toDpu2uoSUM(Density _this, int i) {
            return Dp.m5844constructorimpl(i / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m5817$default$toSpkPz2Gy4(Density _this, int i) {
            return _this.mo399toSp0xMU5do(_this.mo394toDpu2uoSUM(i));
        }

        /* renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m5810$default$toDpu2uoSUM(Density _this, float f) {
            return Dp.m5844constructorimpl(f / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m5816$default$toSpkPz2Gy4(Density _this, float f) {
            return _this.mo399toSp0xMU5do(_this.mo393toDpu2uoSUM(f));
        }

        public static Rect $default$toRect(Density _this, DpRect dpRect) {
            return new Rect(_this.mo397toPx0680j_4(dpRect.m5927getLeftD9Ej5fM()), _this.mo397toPx0680j_4(dpRect.m5929getTopD9Ej5fM()), _this.mo397toPx0680j_4(dpRect.m5928getRightD9Ej5fM()), _this.mo397toPx0680j_4(dpRect.m5926getBottomD9Ej5fM()));
        }

        /* renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m5815$default$toSizeXkaWNTQ(Density _this, long j) {
            return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? SizeKt.Size(_this.mo397toPx0680j_4(DpSize.m5942getWidthD9Ej5fM(j)), _this.mo397toPx0680j_4(DpSize.m5940getHeightD9Ej5fM(j))) : Size.INSTANCE.m3121getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5812$default$toDpSizekrfVVM(Density _this, long j) {
            return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? DpKt.m5866DpSizeYgX7TsA(_this.mo393toDpu2uoSUM(Size.m3113getWidthimpl(j)), _this.mo393toDpu2uoSUM(Size.m3110getHeightimpl(j))) : DpSize.INSTANCE.m5951getUnspecifiedMYxV2XQ();
        }
    }

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5832toDpGaN1DYA(Density density, long j) {
            return FontScaling.CC.m5953$default$toDpGaN1DYA(density, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5839toSp0xMU5do(Density density, float f) {
            return FontScaling.CC.m5954$default$toSp0xMU5do(density, f);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5837toPx0680j_4(Density density, float f) {
            return CC.m5814$default$toPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5831roundToPx0680j_4(Density density, float f) {
            return CC.m5809$default$roundToPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5836toPxR2X_6o(Density density, long j) {
            return CC.m5813$default$toPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5830roundToPxR2X_6o(Density density, long j) {
            return CC.m5808$default$roundToPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5834toDpu2uoSUM(Density density, int i) {
            return CC.m5811$default$toDpu2uoSUM(density, i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5841toSpkPz2Gy4(Density density, int i) {
            return CC.m5817$default$toSpkPz2Gy4(density, i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5833toDpu2uoSUM(Density density, float f) {
            return CC.m5810$default$toDpu2uoSUM(density, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5840toSpkPz2Gy4(Density density, float f) {
            return CC.m5816$default$toSpkPz2Gy4(density, f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return CC.$default$toRect(density, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5838toSizeXkaWNTQ(Density density, long j) {
            return CC.m5815$default$toSizeXkaWNTQ(density, j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5835toDpSizekrfVVM(Density density, long j) {
            return CC.m5812$default$toDpSizekrfVVM(density, j);
        }
    }
}