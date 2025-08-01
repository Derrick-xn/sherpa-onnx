package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/node/CanFocusChecker;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "value", "", "canFocus", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "canFocusValue", "Ljava/lang/Boolean;", "isCanFocusSet", "reset", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    private static Boolean canFocusValue;

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getDown() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getEnd() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ Function1 getEnter() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m2983invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m2983invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ Function1 getExit() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m2984invoke3ESFkO8(focusDirection.getValue());
            }

            /* renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m2984invoke3ESFkO8(int i) {
                return FocusRequester.INSTANCE.getDefault();
            }
        };
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getLeft() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getNext() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getPrevious() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getRight() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getStart() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ FocusRequester getUp() {
        return FocusRequester.INSTANCE.getDefault();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setDown(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setDown(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setEnd(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setEnd(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setEnter(Function1 function1) {
        FocusProperties.CC.$default$setEnter(this, function1);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setExit(Function1 function1) {
        FocusProperties.CC.$default$setExit(this, function1);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setLeft(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setLeft(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setNext(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setNext(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setPrevious(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setPrevious(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setRight(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setRight(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setStart(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setStart(this, focusRequester);
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public /* synthetic */ void setUp(FocusRequester focusRequester) {
        FocusProperties.CC.$default$setUp(this, focusRequester);
    }

    private CanFocusChecker() {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
            throw new KotlinNothingValueException();
        }
        return bool.booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }
}