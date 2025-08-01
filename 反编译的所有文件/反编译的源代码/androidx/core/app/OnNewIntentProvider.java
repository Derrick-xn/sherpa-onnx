package androidx.core.app;

import android.content.Intent;
import androidx.core.util.Consumer;
import kotlin.Metadata;

/* compiled from: OnNewIntentProvider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/core/app/OnNewIntentProvider;", "", "addOnNewIntentListener", "", "listener", "Landroidx/core/util/Consumer;", "Landroid/content/Intent;", "removeOnNewIntentListener", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(Consumer<Intent> listener);

    void removeOnNewIntentListener(Consumer<Intent> listener);
}