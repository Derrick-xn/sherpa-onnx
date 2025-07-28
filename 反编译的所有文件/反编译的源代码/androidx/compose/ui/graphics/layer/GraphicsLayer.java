package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ¶\u00012\u00020\u0001:\u0002¶\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0085\u0001\u001a\u0002082\u0007\u0010\u0086\u0001\u001a\u00020\u0000H\u0002J\t\u0010\u0087\u0001\u001a\u000208H\u0002J\t\u0010\u0088\u0001\u001a\u000208H\u0002J\u000f\u0010\u0089\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u008a\u0001J$\u0010\u008b\u0001\u001a\u0002082\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u0002082\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0000¢\u0006\u0003\b\u0091\u0001J\u000f\u0010\u0092\u0001\u001a\u000208H\u0001¢\u0006\u0003\b\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0095\u0001\u001a\u000208H\u0002J\t\u0010\u0096\u0001\u001a\u000208H\u0002JE\u0010\u0097\u0001\u001a\u0002082\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010r\u001a\u00020q2\u0018\u0010\u0098\u0001\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\t\u0010\u009b\u0001\u001a\u000208H\u0002J\t\u0010\u009c\u0001\u001a\u000208H\u0002J\u000f\u0010\u009d\u0001\u001a\u000208H\u0000¢\u0006\u0003\b\u009e\u0001J\t\u0010\u009f\u0001\u001a\u000208H\u0002J5\u0010 \u0001\u001a\u0003H¡\u0001\"\u0005\b\u0000\u0010¡\u00012\u001b\u0010\u0098\u0001\u001a\u0016\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020f\u0012\u0005\u0012\u0003H¡\u00010¢\u0001H\u0082\b¢\u0006\u0003\u0010£\u0001J\u0010\u0010¤\u0001\u001a\u0002082\u0007\u0010¥\u0001\u001a\u00020JJ%\u0010¦\u0001\u001a\u0002082\u0006\u0010{\u001a\u00020z2\u0006\u0010r\u001a\u00020qH\u0002ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J'\u0010©\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020fø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010¨\u0001J2\u0010«\u0001\u001a\u0002082\b\b\u0002\u0010{\u001a\u00020O2\b\b\u0002\u0010r\u001a\u00020f2\t\b\u0002\u0010¬\u0001\u001a\u00020\bø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0011\u0010¯\u0001\u001a\u00030°\u0001H\u0086@¢\u0006\u0003\u0010±\u0001J\u0013\u0010²\u0001\u001a\u0002082\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0012\u0010µ\u0001\u001a\u00020\u00152\u0007\u0010¥\u0001\u001a\u00020JH\u0002R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020!8F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0007\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020/8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u00105\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010E\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bL\u0010\u0011R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010P\u001a\u00020O2\u0006\u0010\u0007\u001a\u00020O@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R(\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0007\u001a\u0004\u0018\u00010T8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u000b\"\u0004\b\\\u0010\rR$\u0010]\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u000b\"\u0004\b_\u0010\rR$\u0010`\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u000b\"\u0004\bb\u0010\rR\u0010\u0010c\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR\u0016\u0010g\u001a\u00020OX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010SR$\u0010h\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR$\u0010n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000b\"\u0004\bp\u0010\rR,\u0010r\u001a\u00020q2\u0006\u0010\u0007\u001a\u00020q@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bs\u0010\u0011\"\u0004\bt\u0010\u0013R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010w\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010\u0013R,\u0010{\u001a\u00020z2\u0006\u0010\u0007\u001a\u00020z@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\b|\u0010\u0011\"\u0004\b}\u0010\u0013R%\u0010~\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u000b\"\u0005\b\u0080\u0001\u0010\rR'\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010\u000b\"\u0005\b\u0083\u0001\u0010\rR\u000f\u0010\u0084\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006·\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;Landroidx/compose/ui/graphics/layer/LayerManager;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "androidOutline", "Landroid/graphics/Outline;", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "clip", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "<set-?>", "isReleased", "layerId", "", "getLayerId", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "outlineDirty", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "ownerViewId", "getOwnerViewId", "parentLayerUsages", "", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "J", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "roundRectClipPath", "roundRectCornerRadius", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectOutlineTopLeft", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "setTopLeft--gyyYBs", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "usePathForClip", "addSubLayer", "graphicsLayer", "configureOutline", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "draw$ui_graphics_release", "drawForPersistence", "drawForPersistence$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "obtainAndroidOutline", "onAddedToParentLayer", "onRemovedFromParentLayer", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "recreateDisplayListIfNeeded", "release", "release$ui_graphics_release", "resetOutlineParams", "resolveOutlinePosition", "T", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setPathOutline", "path", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "setRectOutline", "setRectOutline-tz77jQw", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "updatePathOutline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private final LayerManager layerManager;
    private Path outlinePath;
    private int parentLayerUsages;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long size;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }
    };
    private boolean outlineDirty = true;
    private long roundRectOutlineTopLeft = Offset.INSTANCE.m3060getZeroF1C5BW0();
    private long roundRectOutlineSize = Size.INSTANCE.m3121getUnspecifiedNHjbRc();
    private final ChildLayerDependenciesTracker childDependenciesTracker = new ChildLayerDependenciesTracker();

    /* compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {847}, m = "toImageBitmap", n = {}, s = {})
    /* renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphicsLayer.this.toImageBitmap(this);
        }
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, LayerManager layerManager) {
        this.impl = graphicsLayerImpl;
        this.layerManager = layerManager;
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m5986getZeronOccac();
        this.size = IntSize.INSTANCE.m6023getZeroYbymL2g();
        this.pivotOffset = Offset.INSTANCE.m3059getUnspecifiedF1C5BW0();
    }

    /* renamed from: getImpl$ui_graphics_release, reason: from getter */
    public final GraphicsLayerImpl getImpl() {
        return this.impl;
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m3983getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m3991setCompositingStrategyWpw9cng(int i) {
        if (CompositingStrategy.m3970equalsimpl0(this.impl.getCompositingStrategy(), i)) {
            return;
        }
        this.impl.mo4004setCompositingStrategyWpw9cng(i);
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m3996setTopLeftgyyYBs(long j) {
        if (IntOffset.m5975equalsimpl0(this.topLeft, j)) {
            return;
        }
        this.topLeft = j;
        m3977setPositionVbeCjmY(j, this.size);
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m3980setSizeozmzZPI(long j) {
        if (IntSize.m6016equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        m3977setPositionVbeCjmY(this.topLeft, j);
        if (this.roundRectOutlineSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() == f) {
            return;
        }
        this.impl.setAlpha(f);
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m3982getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m3990setBlendModes9anfk8(int i) {
        if (BlendMode.m3219equalsimpl0(this.impl.getBlendMode(), i)) {
            return;
        }
        this.impl.mo4003setBlendModes9anfk8(i);
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (Intrinsics.areEqual(this.impl.getColorFilter(), colorFilter)) {
            return;
        }
        this.impl.setColorFilter(colorFilter);
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m3992setPivotOffsetk4lQ0M(long j) {
        if (Offset.m3041equalsimpl0(this.pivotOffset, j)) {
            return;
        }
        this.pivotOffset = j;
        this.impl.mo4005setPivotOffsetk4lQ0M(j);
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() == f) {
            return;
        }
        this.impl.setScaleX(f);
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() == f) {
            return;
        }
        this.impl.setScaleY(f);
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() == f) {
            return;
        }
        this.impl.setTranslationX(f);
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() == f) {
            return;
        }
        this.impl.setTranslationY(f);
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() == f) {
            return;
        }
        this.impl.setShadowElevation(f);
        this.impl.setClip(getClip() || f > 0.0f);
        this.outlineDirty = true;
        configureOutline();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() == f) {
            return;
        }
        this.impl.setRotationX(f);
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() == f) {
            return;
        }
        this.impl.setRotationY(f);
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() == f) {
            return;
        }
        this.impl.setRotationZ(f);
    }

    /* renamed from: setRoundRectOutline-TNW_H78$default, reason: not valid java name */
    public static /* synthetic */ void m3979setRoundRectOutlineTNW_H78$default(GraphicsLayer graphicsLayer, long j, long j2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m3060getZeroF1C5BW0();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = Size.INSTANCE.m3121getUnspecifiedNHjbRc();
        }
        graphicsLayer.m3994setRoundRectOutlineTNW_H78(j3, j2, (i & 4) != 0 ? 0.0f : f);
    }

    /* renamed from: setRectOutline-tz77jQw$default, reason: not valid java name */
    public static /* synthetic */ void m3978setRectOutlinetz77jQw$default(GraphicsLayer graphicsLayer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m3060getZeroF1C5BW0();
        }
        if ((i & 2) != 0) {
            j2 = Size.INSTANCE.m3121getUnspecifiedNHjbRc();
        }
        graphicsLayer.m3993setRectOutlinetz77jQw(j, j2);
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() == f) {
            return;
        }
        this.impl.setCameraDistance(f);
    }

    public final boolean getClip() {
        return this.impl.getClip();
    }

    public final void setClip(boolean z) {
        if (this.impl.getClip() != z) {
            this.impl.setClip(z);
            this.outlineDirty = true;
            configureOutline();
        }
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.impl.getRenderEffect(), renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m3977setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo4006setPositionH0pRuoY(IntOffset.m5976getXimpl(topLeft), IntOffset.m5977getYimpl(topLeft), size);
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m3988recordmLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        m3980setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void recordInternal() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r1 = r0.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r1)
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependency$p(r1, r2)
            androidx.collection.MutableScatterSet r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r1)
            if (r2 == 0) goto L2d
            boolean r3 = r2.isNotEmpty()
            if (r3 == 0) goto L2d
            androidx.collection.MutableScatterSet r3 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r1)
            if (r3 != 0) goto L24
            androidx.collection.MutableScatterSet r3 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(r1, r3)
        L24:
            r4 = r2
            androidx.collection.ScatterSet r4 = (androidx.collection.ScatterSet) r4
            r3.addAll(r4)
            r2.clear()
        L2d:
            r2 = 1
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r1, r2)
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r2 = r0.impl
            androidx.compose.ui.unit.Density r3 = r0.density
            androidx.compose.ui.unit.LayoutDirection r4 = r0.layoutDirection
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r5 = r0.drawBlock
            r2.record(r3, r4, r0, r5)
            r2 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r1, r2)
            androidx.compose.ui.graphics.layer.GraphicsLayer r3 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependency$p(r1)
            if (r3 == 0) goto L49
            r3.onRemovedFromParentLayer()
        L49:
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r1)
            if (r1 == 0) goto L9f
            boolean r3 = r1.isNotEmpty()
            if (r3 == 0) goto L9f
            r3 = r1
            androidx.collection.ScatterSet r3 = (androidx.collection.ScatterSet) r3
            java.lang.Object[] r4 = r3.elements
            long[] r3 = r3.metadata
            int r5 = r3.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L9c
            r6 = 0
        L62:
            r7 = r3[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L97
            int r9 = r6 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L7c:
            if (r11 >= r9) goto L95
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.32E-322)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L91
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r4[r12]
            androidx.compose.ui.graphics.layer.GraphicsLayer r12 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r12
            r12.onRemovedFromParentLayer()
        L91:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L7c
        L95:
            if (r9 != r10) goto L9c
        L97:
            if (r6 == r5) goto L9c
            int r6 = r6 + 1
            goto L62
        L9c:
            r1.clear()
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.recordInternal():void");
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        float fM5976getXimpl = IntOffset.m5976getXimpl(this.topLeft);
        float fM5977getYimpl = IntOffset.m5977getYimpl(this.topLeft);
        float fM5976getXimpl2 = IntOffset.m5976getXimpl(this.topLeft) + IntSize.m6018getWidthimpl(this.size);
        float fM5977getYimpl2 = IntOffset.m5977getYimpl(this.topLeft) + IntSize.m6017getHeightimpl(this.size);
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int iM3982getBlendMode0nO6VwU = m3982getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m3219equalsimpl0(iM3982getBlendMode0nO6VwU, BlendMode.INSTANCE.m3250getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m3970equalsimpl0(m3983getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m3976getOffscreenke2Ky5w())) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(alpha);
            Paint.mo3164setBlendModes9anfk8(iM3982getBlendMode0nO6VwU);
            Paint.setColorFilter(colorFilter);
            androidCanvas.saveLayer(fM5976getXimpl, fM5977getYimpl, fM5976getXimpl2, fM5977getYimpl2, Paint.getInternalPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas.translate(fM5976getXimpl, fM5977getYimpl);
        androidCanvas.concat(this.impl.calculateMatrix());
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        if (this.isReleased) {
            return;
        }
        recreateDisplayListIfNeeded();
        configureOutline();
        boolean z = true;
        boolean z2 = getShadowElevation() > 0.0f;
        if (z2) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean z3 = !nativeCanvas.isHardwareAccelerated();
        if (z3) {
            nativeCanvas.save();
            transformCanvas(nativeCanvas);
        }
        if (!this.usePathForClip && (!z3 || !getClip())) {
            z = false;
        }
        if (z) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof Outline.Rectangle) {
                Canvas.CC.m3282clipRectmtrdDE$default(canvas, outline.getRect(), 0, 2, null);
            } else if (outline instanceof Outline.Rounded) {
                Path Path = this.roundRectClipPath;
                if (Path != null) {
                    Path.rewind();
                } else {
                    Path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = Path;
                }
                Path.CC.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                Canvas.CC.m3280clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            } else if (outline instanceof Outline.Generic) {
                Canvas.CC.m3280clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        this.impl.draw(canvas);
        if (z) {
            canvas.restore();
        }
        if (z2) {
            canvas.disableZ();
        }
        if (z3) {
            nativeCanvas.restore();
        }
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void configureOutline() {
        if (this.outlineDirty) {
            if (!getClip() && getShadowElevation() <= 0.0f) {
                this.impl.setOutline(null);
            } else {
                Path path = this.outlinePath;
                if (path != null) {
                    android.graphics.Outline outlineUpdatePathOutline = updatePathOutline(path);
                    outlineUpdatePathOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineUpdatePathOutline);
                } else {
                    android.graphics.Outline outlineObtainAndroidOutline = obtainAndroidOutline();
                    long jM6030toSizeozmzZPI = IntSizeKt.m6030toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        jM6030toSizeozmzZPI = j2;
                    }
                    outlineObtainAndroidOutline.setRoundRect(Math.round(Offset.m3044getXimpl(j)), Math.round(Offset.m3045getYimpl(j)), Math.round(Offset.m3044getXimpl(j) + Size.m3113getWidthimpl(jM6030toSizeozmzZPI)), Math.round(Offset.m3045getYimpl(j) + Size.m3110getHeightimpl(jM6030toSizeozmzZPI)), this.roundRectCornerRadius);
                    outlineObtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.setOutline(outlineObtainAndroidOutline);
                }
            }
        }
        this.outlineDirty = false;
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> block) {
        long jM6030toSizeozmzZPI = IntSizeKt.m6030toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM6030toSizeozmzZPI = j2;
        }
        return block.invoke(Offset.m3033boximpl(j), Size.m3101boximpl(jM6030toSizeozmzZPI));
    }

    private final android.graphics.Outline updatePathOutline(Path path) {
        android.graphics.Outline outlineObtainAndroidOutline = obtainAndroidOutline();
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            if (Build.VERSION.SDK_INT > 30) {
                OutlineVerificationHelper.INSTANCE.setPath(outlineObtainAndroidOutline, path);
            } else if (path instanceof AndroidPath) {
                outlineObtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            this.usePathForClip = !outlineObtainAndroidOutline.canClip();
        } else {
            android.graphics.Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
        }
        this.outlinePath = path;
        return outlineObtainAndroidOutline;
    }

    private final android.graphics.Outline obtainAndroidOutline() {
        android.graphics.Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        android.graphics.Outline outline2 = new android.graphics.Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            LayerManager layerManager = this.layerManager;
            if (layerManager != null) {
                layerManager.release(this);
            } else {
                discardDisplayList$ui_graphics_release();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void discardDisplayList$ui_graphics_release() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r1 = r0.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r1)
            if (r2 == 0) goto L11
            r2.onRemovedFromParentLayer()
            r2 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setDependency$p(r1, r2)
        L11:
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r1)
            if (r1 == 0) goto L62
            r2 = r1
            androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
            java.lang.Object[] r3 = r2.elements
            long[] r2 = r2.metadata
            int r4 = r2.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L5f
            r5 = 0
            r6 = 0
        L25:
            r7 = r2[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L5a
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L3f:
            if (r11 >= r9) goto L58
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.32E-322)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L54
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            androidx.compose.ui.graphics.layer.GraphicsLayer r12 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r12
            r12.onRemovedFromParentLayer()
        L54:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L3f
        L58:
            if (r9 != r10) goto L5f
        L5a:
            if (r6 == r4) goto L5f
            int r6 = r6 + 1
            goto L25
        L5f:
            r1.clear()
        L62:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r1 = r0.impl
            r1.discardDisplayList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.discardDisplayList$ui_graphics_release():void");
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path != null) {
            Outline.Generic generic = new Outline.Generic(path);
            this.internalOutline = generic;
            return generic;
        }
        long jM6030toSizeozmzZPI = IntSizeKt.m6030toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM6030toSizeozmzZPI = j2;
        }
        float fM3044getXimpl = Offset.m3044getXimpl(j);
        float fM3045getYimpl = Offset.m3045getYimpl(j);
        float fM3113getWidthimpl = fM3044getXimpl + Size.m3113getWidthimpl(jM6030toSizeozmzZPI);
        float fM3110getHeightimpl = fM3045getYimpl + Size.m3110getHeightimpl(jM6030toSizeozmzZPI);
        float f = this.roundRectCornerRadius;
        if (f > 0.0f) {
            rectangle = new Outline.Rounded(RoundRectKt.m3098RoundRectgG7oq9Y(fM3044getXimpl, fM3045getYimpl, fM3113getWidthimpl, fM3110getHeightimpl, CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null)));
        } else {
            rectangle = new Outline.Rectangle(new Rect(fM3044getXimpl, fM3045getYimpl, fM3113getWidthimpl, fM3110getHeightimpl));
        }
        this.internalOutline = rectangle;
        return rectangle;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m3121getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m3060getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutline();
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m3994setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m3041equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m3109equalsimpl0(this.roundRectOutlineSize, size) && this.roundRectCornerRadius == cornerRadius && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutline();
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m3993setRectOutlinetz77jQw(long topLeft, long size) {
        m3994setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m3981getAmbientShadowColor0d7_KjU() {
        return this.impl.getAmbientShadowColor();
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m3989setAmbientShadowColor8_81llA(long j) {
        if (Color.m3325equalsimpl0(j, this.impl.getAmbientShadowColor())) {
            return;
        }
        this.impl.mo4002setAmbientShadowColor8_81llA(j);
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m3986getSpotShadowColor0d7_KjU() {
        return this.impl.getSpotShadowColor();
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m3995setSpotShadowColor8_81llA(long j) {
        if (Color.m3325equalsimpl0(j, this.impl.getSpotShadowColor())) {
            return;
        }
        this.impl.mo4007setSpotShadowColor8_81llA(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object toImageBitmap(kotlin.coroutines.Continuation<? super androidx.compose.ui.graphics.ImageBitmap> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r5 = androidx.compose.ui.graphics.layer.GraphicsLayer.SnapshotImpl
            r0.label = r3
            java.lang.Object r5 = r5.toBitmap(r4, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            androidx.compose.ui.graphics.ImageBitmap r5 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.asImageBitmap(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.toImageBitmap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        LayerSnapshotV21 layerSnapshotV21;
        if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotV21 = LayerSnapshotV28.INSTANCE;
        } else if (Build.VERSION.SDK_INT >= 22 && SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotV21 = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotV21 = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotV21;
    }
}