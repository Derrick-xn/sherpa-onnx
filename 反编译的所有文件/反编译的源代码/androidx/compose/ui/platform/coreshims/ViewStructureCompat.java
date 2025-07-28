package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewStructure;
import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;

/* loaded from: classes.dex */
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

    public void setId(int i, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setId(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), i, str, str2, str3);
        }
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

    public void setTextStyle(float f, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setTextStyle(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj), f, i, i2, i3);
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

    public Bundle getExtras() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getExtras(Paint29$$ExternalSyntheticApiModelOutline0.m5349m(this.mWrappedObj));
        }
        return null;
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static void setId(ViewStructure viewStructure, int i, String str, String str2, String str3) {
            viewStructure.setId(i, str, str2, str3);
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

        static void setTextStyle(ViewStructure viewStructure, float f, int i, int i2, int i3) {
            viewStructure.setTextStyle(f, i, i2, i3);
        }

        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }
}