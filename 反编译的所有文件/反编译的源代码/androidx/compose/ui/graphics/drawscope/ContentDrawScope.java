package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ContentDrawScope.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* compiled from: ContentDrawScope.kt */
    /* renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    /* compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m3838drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            DrawScope.CC.m3880drawImageAZ2fEMs$default(contentDrawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, 0, 512, null);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3839getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m3855$default$getCenterF1C5BW0(contentDrawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3840getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m3856$default$getSizeNHjbRc(contentDrawScope);
        }

        @Deprecated
        /* renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m3841recordJVtK1S4(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, long j, Function1<? super DrawScope, Unit> function1) {
            DrawScope.CC.m3857$default$recordJVtK1S4(contentDrawScope, graphicsLayer, j, function1);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3842roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m5808$default$roundToPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3843roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m5809$default$roundToPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3844toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return FontScaling.CC.m5953$default$toDpGaN1DYA(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3845toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m5810$default$toDpu2uoSUM(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3846toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m5811$default$toDpu2uoSUM((Density) contentDrawScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3847toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m5812$default$toDpSizekrfVVM(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3848toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m5813$default$toPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3849toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m5814$default$toPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            return Density.CC.$default$toRect(contentDrawScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3850toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m5815$default$toSizeXkaWNTQ(contentDrawScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3851toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return FontScaling.CC.m5954$default$toSp0xMU5do(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3852toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m5816$default$toSpkPz2Gy4(contentDrawScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3853toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m5817$default$toSpkPz2Gy4((Density) contentDrawScope, i);
        }
    }
}