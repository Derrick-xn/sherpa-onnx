package androidx.compose.ui.res;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* compiled from: ColorResources.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"colorResource", "Landroidx/compose/ui/graphics/Color;", "id", "", "(ILandroidx/compose/runtime/Composer;I)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorResources_androidKt {
    public static final long colorResource(int i, Composer composer, int i2) {
        long jColor;
        ComposerKt.sourceInformationMarkerStart(composer, -1777644873, "C(colorResource)37@1238L7:ColorResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1777644873, i2, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:36)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        if (Build.VERSION.SDK_INT >= 23) {
            jColor = ColorResourceHelper.INSTANCE.m5091getColorWaAFU9c(context, i);
        } else {
            jColor = ColorKt.Color(context.getResources().getColor(i));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jColor;
    }
}