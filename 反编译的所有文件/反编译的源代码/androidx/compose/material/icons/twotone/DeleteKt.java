package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Delete.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_delete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Delete", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDelete", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeleteKt {
    private static ImageVector _delete;

    public static final ImageVector getDelete(Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _delete;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Delete", Dp.m5844constructorimpl(24.0f), Dp.m5844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        DefaultConstructorMarker defaultConstructorMarker = null;
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3350getBlack0d7_KjU(), defaultConstructorMarker);
        int iM3686getButtKaPHkGw = StrokeCap.INSTANCE.m3686getButtKaPHkGw();
        int iM3696getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3696getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(8.0f, 9.0f);
        pathBuilder.horizontalLineToRelative(8.0f);
        pathBuilder.verticalLineToRelative(10.0f);
        pathBuilder.horizontalLineTo(8.0f);
        pathBuilder.close();
        ImageVector.Builder.m4028addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM3686getButtKaPHkGw, iM3696getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m3350getBlack0d7_KjU(), defaultConstructorMarker);
        int iM3686getButtKaPHkGw2 = StrokeCap.INSTANCE.m3686getButtKaPHkGw();
        int iM3696getBevelLxFBmk82 = StrokeJoin.INSTANCE.m3696getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(15.5f, 4.0f);
        pathBuilder2.lineToRelative(-1.0f, -1.0f);
        pathBuilder2.horizontalLineToRelative(-5.0f);
        pathBuilder2.lineToRelative(-1.0f, 1.0f);
        pathBuilder2.horizontalLineTo(5.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.horizontalLineToRelative(14.0f);
        pathBuilder2.verticalLineTo(4.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(6.0f, 19.0f);
        pathBuilder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder2.horizontalLineToRelative(8.0f);
        pathBuilder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.verticalLineTo(7.0f);
        pathBuilder2.horizontalLineTo(6.0f);
        pathBuilder2.verticalLineToRelative(12.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(8.0f, 9.0f);
        pathBuilder2.horizontalLineToRelative(8.0f);
        pathBuilder2.verticalLineToRelative(10.0f);
        pathBuilder2.horizontalLineTo(8.0f);
        pathBuilder2.verticalLineTo(9.0f);
        pathBuilder2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m4028addPathoIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM3686getButtKaPHkGw2, iM3696getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _delete = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}