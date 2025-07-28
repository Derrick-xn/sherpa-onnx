package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÊ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ef  */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2045TransitionDTcfvLk(final androidx.compose.material3.InputPhase r25, final long r26, final long r28, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r30, final boolean r31, final kotlin.jvm.functions.Function7<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.m2045TransitionDTcfvLk(androidx.compose.material3.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> state) {
        return state.getValue().m3334unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m3334unboximpl();
    }
}