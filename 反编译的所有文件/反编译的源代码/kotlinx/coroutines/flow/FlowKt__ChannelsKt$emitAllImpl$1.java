package kotlinx.coroutines.flow;

import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Channels.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 1, 1, 1}, l = {36, MotionEventCompat.AXIS_GENERIC_6}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "consume"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
/* loaded from: classes2.dex */
final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
    }
}