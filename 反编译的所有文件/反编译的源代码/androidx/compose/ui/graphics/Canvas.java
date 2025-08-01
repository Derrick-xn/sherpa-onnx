package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Canvas.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0003H&J0\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016JH\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J0\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b0\u00101JJ\u00102\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b9\u0010:J*\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010@\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H&J0\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020(0F2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ*\u0010I\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020J2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0018\u0010M\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010M\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J@\u0010N\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J*\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020\u0003H&J\b\u0010Y\u001a\u00020\u0003H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0010H&J\b\u0010\\\u001a\u00020\u0003H&J\u0018\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H&J\u001a\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\b\b\u0002\u0010a\u001a\u00020\u0010H&J\u0018\u0010b\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u0010H&J\u0018\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u0010H\u0016J\u0018\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u0010H&ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006iÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/Canvas;", "", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "scale", "sx", "sy", "skew", "skewRad", "sxRad", "syRad", "translate", "dx", "dy", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Canvas {
    /* renamed from: clipPath-mtrdD-E */
    void mo3138clipPathmtrdDE(Path path, int clipOp);

    /* renamed from: clipRect-N_I0leg */
    void mo3139clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* renamed from: clipRect-mtrdD-E */
    void mo3140clipRectmtrdDE(Rect rect, int clipOp);

    /* renamed from: concat-58bKbWc */
    void mo3141concat58bKbWc(float[] matrix);

    void disableZ();

    void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint);

    void drawArc(Rect rect, float startAngle, float sweepAngle, boolean useCenter, Paint paint);

    void drawArcRad(Rect rect, float startAngleRad, float sweepAngleRad, boolean useCenter, Paint paint);

    /* renamed from: drawCircle-9KIMszo */
    void mo3142drawCircle9KIMszo(long center, float radius, Paint paint);

    /* renamed from: drawImage-d-4ec7I */
    void mo3143drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint);

    /* renamed from: drawImageRect-HPBpro0 */
    void mo3144drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint);

    /* renamed from: drawLine-Wko1d7g */
    void mo3145drawLineWko1d7g(long p1, long p2, Paint paint);

    void drawOval(float left, float top, float right, float bottom, Paint paint);

    void drawOval(Rect rect, Paint paint);

    void drawPath(Path path, Paint paint);

    /* renamed from: drawPoints-O7TthRY */
    void mo3146drawPointsO7TthRY(int pointMode, List<Offset> points, Paint paint);

    /* renamed from: drawRawPoints-O7TthRY */
    void mo3147drawRawPointsO7TthRY(int pointMode, float[] points, Paint paint);

    void drawRect(float left, float top, float right, float bottom, Paint paint);

    void drawRect(Rect rect, Paint paint);

    void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint);

    /* renamed from: drawVertices-TPEHhCM */
    void mo3148drawVerticesTPEHhCM(Vertices vertices, int blendMode, Paint paint);

    void enableZ();

    void restore();

    void rotate(float degrees);

    void save();

    void saveLayer(Rect bounds, Paint paint);

    void scale(float sx, float sy);

    void skew(float sx, float sy);

    void skewRad(float sxRad, float syRad);

    void translate(float dx, float dy);

    /* compiled from: Canvas.kt */
    /* renamed from: androidx.compose.ui.graphics.Canvas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void scale$default(Canvas canvas, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
            }
            if ((i & 2) != 0) {
                f2 = f;
            }
            canvas.scale(f, f2);
        }

        public static void $default$skewRad(Canvas _this, float f, float f2) {
            _this.skew(DegreesKt.degrees(f), DegreesKt.degrees(f2));
        }

        /* renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m3282clipRectmtrdDE$default(Canvas canvas, Rect rect, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
            }
            if ((i2 & 2) != 0) {
                i = ClipOp.INSTANCE.m3313getIntersectrtfAjoo();
            }
            canvas.mo3140clipRectmtrdDE(rect, i);
        }

        /* renamed from: $default$clipRect-mtrdD-E, reason: not valid java name */
        public static void m3278$default$clipRectmtrdDE(Canvas _this, Rect rect, int i) {
            _this.mo3139clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i);
        }

        /* renamed from: clipRect-N_I0leg$default, reason: not valid java name */
        public static /* synthetic */ void m3281clipRectN_I0leg$default(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
            }
            if ((i2 & 16) != 0) {
                i = ClipOp.INSTANCE.m3313getIntersectrtfAjoo();
            }
            canvas.mo3139clipRectN_I0leg(f, f2, f3, f4, i);
        }

        /* renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
        public static /* synthetic */ void m3280clipPathmtrdDE$default(Canvas canvas, Path path, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
            }
            if ((i2 & 2) != 0) {
                i = ClipOp.INSTANCE.m3313getIntersectrtfAjoo();
            }
            canvas.mo3138clipPathmtrdDE(path, i);
        }

        public static void $default$drawRect(Canvas _this, Rect rect, Paint paint) {
            _this.drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
        }

        public static void $default$drawOval(Canvas _this, Rect rect, Paint paint) {
            _this.drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
        }

        public static void $default$drawArc(Canvas _this, Rect rect, float f, float f2, boolean z, Paint paint) {
            _this.drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2, z, paint);
        }

        public static void $default$drawArcRad(Canvas _this, Rect rect, float f, float f2, boolean z, Paint paint) {
            _this.drawArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2), z, paint);
        }

        /* renamed from: drawImageRect-HPBpro0$default, reason: not valid java name */
        public static /* synthetic */ void m3283drawImageRectHPBpro0$default(Canvas canvas, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
            }
            long jM5986getZeronOccac = (i & 2) != 0 ? IntOffset.INSTANCE.m5986getZeronOccac() : j;
            long jIntSize = (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
            canvas.mo3144drawImageRectHPBpro0(imageBitmap, jM5986getZeronOccac, jIntSize, (i & 8) != 0 ? IntOffset.INSTANCE.m5986getZeronOccac() : j3, (i & 16) != 0 ? jIntSize : j4, paint);
        }
    }

    /* compiled from: Canvas.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void skewRad(Canvas canvas, float f, float f2) {
            CC.$default$skewRad(canvas, f, f2);
        }

        @Deprecated
        /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m3286clipRectmtrdDE(Canvas canvas, Rect rect, int i) {
            CC.m3278$default$clipRectmtrdDE(canvas, rect, i);
        }

        @Deprecated
        public static void drawRect(Canvas canvas, Rect rect, Paint paint) {
            CC.$default$drawRect(canvas, rect, paint);
        }

        @Deprecated
        public static void drawOval(Canvas canvas, Rect rect, Paint paint) {
            CC.$default$drawOval(canvas, rect, paint);
        }

        @Deprecated
        public static void drawArc(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
            CC.$default$drawArc(canvas, rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawArcRad(Canvas canvas, Rect rect, float f, float f2, boolean z, Paint paint) {
            CC.$default$drawArcRad(canvas, rect, f, f2, z, paint);
        }
    }
}