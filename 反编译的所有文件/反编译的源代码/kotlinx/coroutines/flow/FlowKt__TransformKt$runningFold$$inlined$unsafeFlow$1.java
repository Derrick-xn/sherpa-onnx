package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0}, l = {115, 116}, m = "collect", n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super R> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L68
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.Object r2 = r6.$initial$inlined
            r8.element = r2
            T r2 = r8.element
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r2 = r7.emit(r2, r0)
            if (r2 != r1) goto L65
            return r1
        L65:
            r4 = r6
            r2 = r7
            r7 = r8
        L68:
            kotlinx.coroutines.flow.Flow r8 = r4.$this_runningFold$inlined
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r5 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1
            kotlin.jvm.functions.Function3 r4 = r4.$operation$inlined
            r5.<init>(r7, r4, r2)
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r7 = r8.collect(r5, r0)
            if (r7 != r1) goto L83
            return r1
        L83:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = function3;
    }
}