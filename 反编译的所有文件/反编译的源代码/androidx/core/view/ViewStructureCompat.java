package androidx.core.view;

import android.os.Build;
import android.view.ViewStructure;
import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;

/* loaded from: classes2.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    public static ViewStructureCompat toViewStructureCompat(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public ViewStructure toViewStructure() {
        return Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj);
    }

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    public void setText(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setText(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), charSequence);
        }
    }

    public void setClassName(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setClassName(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), str);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setContentDescription(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), charSequence);
        }
    }

    public void setDimens(int i, int i2, int i3, int i4, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setDimens(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), i, i2, i3, i4, i5, i6);
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static void setDimens(ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
            viewStructure.setDimens(i, i2, i3, i4, i5, i6);
        }

        static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }
    }
}