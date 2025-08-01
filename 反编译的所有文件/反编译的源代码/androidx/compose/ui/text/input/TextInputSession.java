package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputService.kt */
@Deprecated(message = "Use PlatformTextInputModifierNode instead.")
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0017\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0082\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016JB\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0\u001f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/input/TextInputSession;", "", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "isOpen", "", "()Z", "dispose", "", "ensureOpenSession", "block", "Lkotlin/Function0;", "hideSoftwareKeyboard", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "showSoftwareKeyboard", "updateState", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextInputSession {
    public static final int $stable = 8;
    private final PlatformTextInputService platformTextInputService;
    private final TextInputService textInputService;

    public TextInputSession(TextInputService textInputService, PlatformTextInputService platformTextInputService) {
        this.textInputService = textInputService;
        this.platformTextInputService = platformTextInputService;
    }

    public final boolean isOpen() {
        return Intrinsics.areEqual(this.textInputService.getCurrentInputSession$ui_text_release(), this);
    }

    public final void dispose() {
        this.textInputService.stopInput(this);
    }

    private final boolean ensureOpenSession(Function0<Unit> block) {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            block.invoke();
        }
        return zIsOpen;
    }

    public final boolean notifyFocusedRect(Rect rect) {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.notifyFocusedRect(rect);
        }
        return zIsOpen;
    }

    public final boolean updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1<? super Matrix, Unit> textFieldToRootTransform, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, textFieldToRootTransform, innerTextFieldBounds, decorationBoxBounds);
        }
        return zIsOpen;
    }

    public final boolean updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.updateState(oldValue, newValue);
        }
        return zIsOpen;
    }

    public final boolean showSoftwareKeyboard() {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
        return zIsOpen;
    }

    public final boolean hideSoftwareKeyboard() {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.hideSoftwareKeyboard();
        }
        return zIsOpen;
    }
}