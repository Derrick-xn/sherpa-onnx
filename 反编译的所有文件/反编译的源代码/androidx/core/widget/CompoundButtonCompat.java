package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        Api21Impl.setButtonTintList(compoundButton, colorStateList);
    }

    public static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        return Api21Impl.getButtonTintList(compoundButton);
    }

    public static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        Api21Impl.setButtonTintMode(compoundButton, mode);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        return Api21Impl.getButtonTintMode(compoundButton);
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getButtonDrawable(compoundButton);
        }
        if (!sButtonDrawableFieldFetched) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
            }
            sButtonDrawableFieldFetched = true;
        }
        Field field = sButtonDrawableField;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i(TAG, "Failed to get button drawable via reflection", e2);
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }

        static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable getButtonDrawable(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }
}