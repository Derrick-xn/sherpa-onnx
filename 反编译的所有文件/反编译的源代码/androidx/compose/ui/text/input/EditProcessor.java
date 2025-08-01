package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: EditProcessor.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\f\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditProcessor {
    public static final int $stable = 8;
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.INSTANCE.m5303getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.getSelection(), (DefaultConstructorMarker) (0 == true ? 1 : 0));

    /* renamed from: getMBufferState$ui_text_release, reason: from getter */
    public final TextFieldValue getMBufferState() {
        return this.mBufferState;
    }

    /* renamed from: getMBuffer$ui_text_release, reason: from getter */
    public final EditingBuffer getMBuffer() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue value, TextInputSession textInputSession) {
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual(value.getComposition(), this.mBuffer.m5478getCompositionMzsxiRA$ui_text_release());
        boolean z3 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString(), value.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(value.getAnnotatedString(), value.getSelection(), (DefaultConstructorMarker) null);
        } else if (TextRange.m5291equalsimpl0(this.mBufferState.getSelection(), value.getSelection())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m5296getMinimpl(value.getSelection()), TextRange.m5295getMaximpl(value.getSelection()));
            z = false;
            z3 = true;
        }
        if (value.getComposition() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m5292getCollapsedimpl(value.getComposition().getPackedValue())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m5296getMinimpl(value.getComposition().getPackedValue()), TextRange.m5295getMaximpl(value.getComposition().getPackedValue()));
        }
        if (z || (!z3 && z2)) {
            this.mBuffer.commitComposition$ui_text_release();
            value = TextFieldValue.m5561copy3r_uNRQ$default(value, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue = this.mBufferState;
        this.mBufferState = value;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue, value);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    private final String generateBatchErrorMessage(List<? extends EditCommand> editCommands, final EditCommand failedCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m5478getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m5301toStringimpl(this.mBuffer.m5479getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CollectionsKt.joinTo(editCommands, sb, (60 & 2) != 0 ? ", " : "\n", (60 & 4) != 0 ? "" : null, (60 & 8) != 0 ? "" : null, (60 & 16) != 0 ? -1 : 0, (60 & 32) != 0 ? "..." : null, (60 & 64) != 0 ? null : new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditCommand editCommand) {
                return (failedCommand == editCommand ? " > " : "   ") + this.toStringForLog(editCommand);
            }
        });
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        }
        if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof BackspaceCommand) && !(editCommand instanceof MoveCursorCommand) && !(editCommand instanceof DeleteAllCommand)) {
            StringBuilder sb3 = new StringBuilder("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            sb3.append(simpleName);
            return sb3.toString();
        }
        return editCommand.toString();
    }

    public final TextFieldValue apply(List<? extends EditCommand> editCommands) {
        EditCommand editCommand;
        Exception e;
        try {
            int size = editCommands.size();
            int i = 0;
            editCommand = null;
            while (i < size) {
                try {
                    EditCommand editCommand2 = editCommands.get(i);
                    try {
                        editCommand2.applyTo(this.mBuffer);
                        i++;
                        editCommand = editCommand2;
                    } catch (Exception e2) {
                        e = e2;
                        editCommand = editCommand2;
                        throw new RuntimeException(generateBatchErrorMessage(editCommands, editCommand), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            AnnotatedString annotatedString$ui_text_release = this.mBuffer.toAnnotatedString$ui_text_release();
            long jM5479getSelectiond9O1mEE$ui_text_release = this.mBuffer.m5479getSelectiond9O1mEE$ui_text_release();
            TextRange textRangeM5286boximpl = TextRange.m5286boximpl(jM5479getSelectiond9O1mEE$ui_text_release);
            textRangeM5286boximpl.getPackedValue();
            TextRange textRange = TextRange.m5297getReversedimpl(this.mBufferState.getSelection()) ? null : textRangeM5286boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text_release, textRange != null ? textRange.getPackedValue() : TextRangeKt.TextRange(TextRange.m5295getMaximpl(jM5479getSelectiond9O1mEE$ui_text_release), TextRange.m5296getMinimpl(jM5479getSelectiond9O1mEE$ui_text_release)), this.mBuffer.m5478getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e4) {
            editCommand = null;
            e = e4;
        }
    }
}