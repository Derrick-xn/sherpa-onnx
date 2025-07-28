package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class WindowInsetsCompat$Impl28$$ExternalSyntheticApiModelOutline0 {
    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WindowInsets.Builder m6213m() {
        return new WindowInsets.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WindowInsets.Builder m6214m(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* synthetic */ WindowInsetsAnimation.Bounds m(Insets insets, Insets insets2) {
        return new WindowInsetsAnimation.Bounds(insets, insets2);
    }

    public static /* synthetic */ WindowInsetsAnimation m(int i, Interpolator interpolator, long j) {
        return new WindowInsetsAnimation(i, interpolator, j);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimation m(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsController.OnControllableInsetsChangedListener m6217m(Object obj) {
        return (WindowInsetsController.OnControllableInsetsChangedListener) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m6224m() {
    }
}