package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.CanvasZHelper$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewTranslationCallbackS;", "", "()V", "clearViewTranslationCallback", "", "view", "Landroid/view/View;", "setViewTranslationCallback", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewTranslationCallbackS {
    public static final int $stable = 0;
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    private AndroidComposeViewTranslationCallbackS() {
    }

    public final void setViewTranslationCallback(View view) {
        view.setViewTranslationCallback(CanvasZHelper$$ExternalSyntheticApiModelOutline0.m3293m((Object) AndroidComposeViewTranslationCallback.INSTANCE));
    }

    public final void clearViewTranslationCallback(View view) {
        view.clearViewTranslationCallback();
    }
}