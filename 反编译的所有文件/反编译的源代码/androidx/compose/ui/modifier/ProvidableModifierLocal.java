package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ModifierLocal.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProvidableModifierLocal<T> extends ModifierLocal<T> {
    public static final int $stable = 0;

    public ProvidableModifierLocal(Function0<? extends T> function0) {
        super(function0, null);
    }
}