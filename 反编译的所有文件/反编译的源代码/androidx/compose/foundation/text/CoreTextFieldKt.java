package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010#\u001a0\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\u0010-\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u000200H\u0002\u001a \u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002\u001a0\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002\u001a \u00107\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0013H\u0002\u001a2\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0080@¢\u0006\u0002\u0010@\u001a\u001c\u0010A\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u0010%\u001a\u00020&H\u0002¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06ae A[PHI: r4 r37 r42
      0x06ae: PHI (r4v27 androidx.compose.ui.text.input.ImeOptions) = (r4v22 androidx.compose.ui.text.input.ImeOptions), (r4v28 androidx.compose.ui.text.input.ImeOptions) binds: [B:309:0x06ac, B:306:0x069d] A[DONT_GENERATE, DONT_INLINE]
      0x06ae: PHI (r37v4 int) = (r37v1 int), (r37v6 int) binds: [B:309:0x06ac, B:306:0x069d] A[DONT_GENERATE, DONT_INLINE]
      0x06ae: PHI (r42v4 int) = (r42v2 int), (r42v5 int) binds: [B:309:0x06ac, B:306:0x069d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x074e  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0833  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0878  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x08a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08fd  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x096b  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x099a  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x09c4  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x09e0  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x09ec  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0a16  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a19  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0a68  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0ad6  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0ada  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0ae3  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0b4a  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0b6f  */
    /* JADX WARN: Removed duplicated region for block: B:475:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CoreTextField(final androidx.compose.ui.text.input.TextFieldValue r52, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r53, androidx.compose.ui.Modifier r54, androidx.compose.ui.text.TextStyle r55, androidx.compose.ui.text.input.VisualTransformation r56, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r57, androidx.compose.foundation.interaction.MutableInteractionSource r58, androidx.compose.ui.graphics.Brush r59, boolean r60, int r61, int r62, androidx.compose.ui.text.input.ImeOptions r63, androidx.compose.foundation.text.KeyboardActions r64, boolean r65, boolean r66, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, androidx.compose.runtime.Composer r68, final int r69, final int r70, final int r71) {
        /*
            Method dump skipped, instructions count: 2956
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextFieldRootBox)P(2,1)802@36846L95:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2777constructorimpl = Updater.m2777constructorimpl(composerStartRestartGroup);
            Updater.m2784setimpl(composerM2777constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2784setimpl(composerM2777constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM2777constructorimpl.getInserting() || !Intrinsics.areEqual(composerM2777constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2777constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2777constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m2784setimpl(composerM2777constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1183915871, "C803@36902L33:CoreTextField.kt#423gt5");
            int i3 = i2 >> 3;
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i3 & 112) | (i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextFieldRootBox.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    CoreTextFieldKt.CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1031invokeZmokQxo(keyEvent.m4391unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1031invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1033cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1432deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m5295getMaximpl(textFieldValue.getSelection()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else if (iOriginalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(iOriginalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m6017getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1286242594);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    if (!(textFieldSelectionManager.getState() != null ? r5.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(-1285984396);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1285984395);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (!TextRange.m5292getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(-1680616096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5298getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5293getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                        if (state2 != null && state2.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(-1680216289);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1158@51449L203");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679975078);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 != null && state3.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(-1679895904);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1165@51772L202");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679655654);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679637798);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                    if (state4 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state4.setShowFloatingToolbar(false);
                        }
                        if (state4.getHasFocus()) {
                            if (state4.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(651305535);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.SelectionToolbarAndHandles.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation_release;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state != null && state.getShowCursorHandle() && (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) != null && transformedText$foundation_release.length() > 0) {
                composerStartRestartGroup.startReplaceGroup(-285446808);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1191@52866L50,1192@52979L7,1194@53039L12,1196@53125L601,1208@53754L309,1193@52996L1077");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -424850346, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long jM1438getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m1438getCursorPositiontuRUvjQ$foundation_release((Density) objConsume);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -424844848, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(jM1438getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (OffsetProvider) new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1008provideF1C5BW0() {
                            return jM1438getCursorPositiontuRUvjQ$foundation_release;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -424841507, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new CoreTextFieldKt$TextFieldCursorHandle$2$1(textDragObserver, textFieldSelectionManager, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -424821671, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(jM1438getCursorPositiontuRUvjQ$foundation_release);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, jM1438getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidCursorHandle_androidKt.m1004CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue4, 1, null), 0L, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-284257090);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}