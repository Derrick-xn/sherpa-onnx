package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes2.dex */
public interface MenuHost {
    void addMenuProvider(MenuProvider menuProvider);

    void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner);

    void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state);

    void invalidateMenu();

    void removeMenuProvider(MenuProvider menuProvider);
}