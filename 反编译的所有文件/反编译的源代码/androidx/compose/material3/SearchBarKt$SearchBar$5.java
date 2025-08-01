package androidx.compose.material3;

import androidx.compose.ui.focus.FocusManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: SearchBar.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$SearchBar$5", f = "SearchBar.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class SearchBarKt$SearchBar$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ FocusManager $focusManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBarKt$SearchBar$5(boolean z, FocusManager focusManager, Continuation<? super SearchBarKt$SearchBar$5> continuation) {
        super(2, continuation);
        this.$active = z;
        this.$focusManager = focusManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBarKt$SearchBar$5(this.$active, this.$focusManager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBarKt$SearchBar$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$active) {
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FocusManager.CC.clearFocus$default(this.$focusManager, false, 1, null);
        return Unit.INSTANCE;
    }
}