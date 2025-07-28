package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TimePickerState$update$2", f = "TimePicker.kt", i = {}, l = {571, 573}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TimePickerState$update$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromTap;
    final /* synthetic */ float $value;
    int label;
    final /* synthetic */ TimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimePickerState$update$2(TimePickerState timePickerState, float f, boolean z, Continuation<? super TimePickerState$update$2> continuation) {
        super(1, continuation);
        this.this$0 = timePickerState;
        this.$value = f;
        this.$fromTap = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimePickerState$update$2(this.this$0, this.$value, this.$fromTap, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimePickerState$update$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Selection.m1869equalsimpl0(this.this$0.m2087getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1873getHourJiIwxys())) {
                this.this$0.setHourAngle$material3_release((r8.toHour(this.$value) % 12) * 0.5235988f);
            } else if (this.$fromTap) {
                this.this$0.setMinuteAngle$material3_release((r8.toMinute(this.$value) - (this.this$0.toMinute(this.$value) % 5)) * 0.10471976f);
            } else {
                this.this$0.setMinuteAngle$material3_release(r8.toMinute(this.$value) * 0.10471976f);
            }
            if (!this.$fromTap) {
                this.label = 2;
                if (this.this$0.getCurrentAngle$material3_release().snapTo(Boxing.boxFloat(this.this$0.offsetHour(this.$value)), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 1;
                if (this.this$0.getCurrentAngle$material3_release().snapTo(Boxing.boxFloat(this.this$0.getMinuteAngle$material3_release()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}