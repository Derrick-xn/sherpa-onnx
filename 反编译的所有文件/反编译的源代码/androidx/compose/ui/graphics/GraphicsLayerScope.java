package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* compiled from: GraphicsLayerScope.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\u00020\u00128fX¦\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R\u0018\u00105\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0005\"\u0004\b7\u0010\u0007R\u0018\u00108\u001a\u000209X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b@\u0010\u000bR*\u0010A\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR\u001e\u0010D\u001a\u00020EX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u0018\u0010H\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0005\"\u0004\bJ\u0010\u0007R\u0018\u0010K\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0005\"\u0004\bM\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006NÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@PlacementScopeMarker
/* loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long mo3491getAmbientShadowColor0d7_KjU();

    float getCameraDistance();

    boolean getClip();

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    int mo3492getCompositingStrategyNrFUSI();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    long mo3493getSizeNHjbRc();

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long mo3494getSpotShadowColor0d7_KjU();

    /* renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo3495getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo3496setAmbientShadowColor8_81llA(long j);

    void setCameraDistance(float f);

    void setClip(boolean z);

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo3497setCompositingStrategyaDBOjCE(int i);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo3498setSpotShadowColor8_81llA(long j);

    /* renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo3499setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* compiled from: GraphicsLayerScope.kt */
    /* renamed from: androidx.compose.ui.graphics.GraphicsLayerScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static RenderEffect $default$getRenderEffect(GraphicsLayerScope _this) {
            return null;
        }

        /* renamed from: $default$setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m3504$default$setAmbientShadowColor8_81llA(GraphicsLayerScope _this, long j) {
        }

        /* renamed from: $default$setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m3505$default$setCompositingStrategyaDBOjCE(GraphicsLayerScope _this, int i) {
        }

        public static void $default$setRenderEffect(GraphicsLayerScope _this, RenderEffect renderEffect) {
        }

        /* renamed from: $default$setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m3506$default$setSpotShadowColor8_81llA(GraphicsLayerScope _this, long j) {
        }

        /* renamed from: $default$getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3500$default$getAmbientShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* renamed from: $default$getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3503$default$getSpotShadowColor0d7_KjU(GraphicsLayerScope _this) {
            return GraphicsLayerScopeKt.getDefaultShadowColor();
        }

        /* renamed from: $default$getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m3501$default$getCompositingStrategyNrFUSI(GraphicsLayerScope _this) {
            return CompositingStrategy.INSTANCE.m3414getAutoNrFUSI();
        }

        /* renamed from: $default$getSize-NH-jbRc, reason: not valid java name */
        public static long m3502$default$getSizeNHjbRc(GraphicsLayerScope _this) {
            return Size.INSTANCE.m3121getUnspecifiedNHjbRc();
        }
    }

    /* compiled from: GraphicsLayerScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3530roundToPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return Density.CC.m5808$default$roundToPxR2X_6o(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3531roundToPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return Density.CC.m5809$default$roundToPx0680j_4(graphicsLayerScope, f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3535toDpGaN1DYA(GraphicsLayerScope graphicsLayerScope, long j) {
            return FontScaling.CC.m5953$default$toDpGaN1DYA(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3536toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, float f) {
            return Density.CC.m5810$default$toDpu2uoSUM(graphicsLayerScope, f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3537toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, int i) {
            return Density.CC.m5811$default$toDpu2uoSUM((Density) graphicsLayerScope, i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3538toDpSizekrfVVM(GraphicsLayerScope graphicsLayerScope, long j) {
            return Density.CC.m5812$default$toDpSizekrfVVM(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3539toPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return Density.CC.m5813$default$toPxR2X_6o(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3540toPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return Density.CC.m5814$default$toPx0680j_4(graphicsLayerScope, f);
        }

        @Deprecated
        public static Rect toRect(GraphicsLayerScope graphicsLayerScope, DpRect dpRect) {
            return Density.CC.$default$toRect(graphicsLayerScope, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3541toSizeXkaWNTQ(GraphicsLayerScope graphicsLayerScope, long j) {
            return Density.CC.m5815$default$toSizeXkaWNTQ(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3542toSp0xMU5do(GraphicsLayerScope graphicsLayerScope, float f) {
            return FontScaling.CC.m5954$default$toSp0xMU5do(graphicsLayerScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3543toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, float f) {
            return Density.CC.m5816$default$toSpkPz2Gy4(graphicsLayerScope, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3544toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, int i) {
            return Density.CC.m5817$default$toSpkPz2Gy4((Density) graphicsLayerScope, i);
        }

        @Deprecated
        /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3526getAmbientShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return CC.m3500$default$getAmbientShadowColor0d7_KjU(graphicsLayerScope);
        }

        @Deprecated
        /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m3532setAmbientShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            CC.m3504$default$setAmbientShadowColor8_81llA(graphicsLayerScope, j);
        }

        @Deprecated
        /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m3529getSpotShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return CC.m3503$default$getSpotShadowColor0d7_KjU(graphicsLayerScope);
        }

        @Deprecated
        /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m3534setSpotShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            CC.m3506$default$setSpotShadowColor8_81llA(graphicsLayerScope, j);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope graphicsLayerScope) {
            return CC.$default$getRenderEffect(graphicsLayerScope);
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope graphicsLayerScope, RenderEffect renderEffect) {
            CC.$default$setRenderEffect(graphicsLayerScope, renderEffect);
        }

        @Deprecated
        /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m3527getCompositingStrategyNrFUSI(GraphicsLayerScope graphicsLayerScope) {
            return CC.m3501$default$getCompositingStrategyNrFUSI(graphicsLayerScope);
        }

        @Deprecated
        /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m3533setCompositingStrategyaDBOjCE(GraphicsLayerScope graphicsLayerScope, int i) {
            CC.m3505$default$setCompositingStrategyaDBOjCE(graphicsLayerScope, i);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3528getSizeNHjbRc(GraphicsLayerScope graphicsLayerScope) {
            return CC.m3502$default$getSizeNHjbRc(graphicsLayerScope);
        }
    }
}