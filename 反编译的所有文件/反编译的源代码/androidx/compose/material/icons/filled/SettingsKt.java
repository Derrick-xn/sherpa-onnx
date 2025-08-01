package androidx.compose.material.icons.filled;

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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Filled;", "getSettings", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SettingsKt {
    private static ImageVector _settings;

    public static final ImageVector getSettings(Icons.Filled filled) {
        Intrinsics.checkNotNullParameter(filled, "<this>");
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        String str = "Filled.Settings";
        ImageVector.Builder builder = new ImageVector.Builder(str, Dp.m5844constructorimpl(24.0f), Dp.m5844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m3350getBlack0d7_KjU(), null);
        int iM3686getButtKaPHkGw = StrokeCap.INSTANCE.m3686getButtKaPHkGw();
        int iM3696getBevelLxFBmk8 = StrokeJoin.INSTANCE.m3696getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.14f, 12.94f);
        pathBuilder.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        pathBuilder.curveToRelative(0.0f, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        pathBuilder.lineToRelative(2.03f, -1.58f);
        pathBuilder.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        pathBuilder.lineToRelative(-1.92f, -3.32f);
        pathBuilder.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        pathBuilder.lineToRelative(-2.39f, 0.96f);
        pathBuilder.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        pathBuilder.lineTo(14.4f, 2.81f);
        pathBuilder.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        pathBuilder.horizontalLineToRelative(-3.84f);
        pathBuilder.curveToRelative(-0.24f, 0.0f, -0.43f, 0.17f, -0.47f, 0.41f);
        pathBuilder.lineTo(9.25f, 5.35f);
        pathBuilder.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        pathBuilder.lineTo(5.24f, 5.33f);
        pathBuilder.curveToRelative(-0.22f, -0.08f, -0.47f, 0.0f, -0.59f, 0.22f);
        pathBuilder.lineTo(2.74f, 8.87f);
        pathBuilder.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        pathBuilder.lineToRelative(2.03f, 1.58f);
        pathBuilder.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        pathBuilder.lineToRelative(-2.03f, 1.58f);
        pathBuilder.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        pathBuilder.lineToRelative(1.92f, 3.32f);
        pathBuilder.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        pathBuilder.lineToRelative(2.39f, -0.96f);
        pathBuilder.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        pathBuilder.lineToRelative(0.36f, 2.54f);
        pathBuilder.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        pathBuilder.horizontalLineToRelative(3.84f);
        pathBuilder.curveToRelative(0.24f, 0.0f, 0.44f, -0.17f, 0.47f, -0.41f);
        pathBuilder.lineToRelative(0.36f, -2.54f);
        pathBuilder.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        pathBuilder.lineToRelative(2.39f, 0.96f);
        pathBuilder.curveToRelative(0.22f, 0.08f, 0.47f, 0.0f, 0.59f, -0.22f);
        pathBuilder.lineToRelative(1.92f, -3.32f);
        pathBuilder.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        pathBuilder.lineTo(19.14f, 12.94f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 15.6f);
        pathBuilder.curveToRelative(-1.98f, 0.0f, -3.6f, -1.62f, -3.6f, -3.6f);
        pathBuilder.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        pathBuilder.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        pathBuilder.reflectiveCurveTo(13.98f, 15.6f, 12.0f, 15.6f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m4028addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM3686getButtKaPHkGw, iM3696getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _settings = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}