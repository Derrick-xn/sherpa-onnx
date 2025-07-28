package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&J\f\u0010\u0012\u001a\u00020\t*\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "menuAnchor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ExposedDropdownMenuBoxScope {
    void ExposedDropdownMenu(boolean z, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2);

    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    Modifier menuAnchor(Modifier modifier);

    /* compiled from: ExposedDropdownMenu.kt */
    /* renamed from: androidx.compose.material3.ExposedDropdownMenuBoxScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0181  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01db  */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void $default$ExposedDropdownMenu(final androidx.compose.material3.ExposedDropdownMenuBoxScope r23, final boolean r24, final kotlin.jvm.functions.Function0 r25, androidx.compose.ui.Modifier r26, final kotlin.jvm.functions.Function3 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
            /*
                Method dump skipped, instructions count: 499
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.CC.$default$ExposedDropdownMenu(androidx.compose.material3.ExposedDropdownMenuBoxScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
        }
    }
}