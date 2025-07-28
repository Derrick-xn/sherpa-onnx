package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/TooltipSync;", "", "()V", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "getMutatorMutex", "()Landroidx/compose/foundation/MutatorMutex;", "mutexOwner", "Landroidx/compose/material3/TooltipState;", "getMutexOwner", "()Landroidx/compose/material3/TooltipState;", "setMutexOwner", "(Landroidx/compose/material3/TooltipState;)V", "dismissCurrentTooltip", "", "state", "(Landroidx/compose/material3/TooltipState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "persistent", "", "(Landroidx/compose/material3/TooltipState;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TooltipSync {
    public static final TooltipSync INSTANCE = new TooltipSync();
    private static final MutatorMutex mutatorMutex = new MutatorMutex();
    private static TooltipState mutexOwner;

    private TooltipSync() {
    }

    public final MutatorMutex getMutatorMutex() {
        return mutatorMutex;
    }

    public final TooltipState getMutexOwner() {
        return mutexOwner;
    }

    public final void setMutexOwner(TooltipState tooltipState) {
        mutexOwner = tooltipState;
    }

    public final Object show(final TooltipState tooltipState, boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass4 anonymousClass4;
        Function0<Unit> function0;
        if (tooltipState instanceof PlainTooltipState) {
            anonymousClass4 = new C04872(tooltipState, null);
            function0 = new Function0<Unit>() { // from class: androidx.compose.material3.TooltipSync.show.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((PlainTooltipState) tooltipState).setVisible$material3_release(false);
                }
            };
        } else if (tooltipState instanceof RichTooltipState) {
            anonymousClass4 = new AnonymousClass4(z, tooltipState, null);
            function0 = new Function0<Unit>() { // from class: androidx.compose.material3.TooltipSync.show.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((RichTooltipState) tooltipState).setVisible$material3_release(false);
                }
            };
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object objMutate = mutatorMutex.mutate(MutatePriority.Default, new AnonymousClass6(tooltipState, anonymousClass4, function0, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$2", f = "Tooltip.kt", i = {}, l = {623}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TooltipSync$show$2, reason: invalid class name and case insensitive filesystem */
    static final class C04872 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TooltipState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04872(TooltipState tooltipState, Continuation<? super C04872> continuation) {
            super(1, continuation);
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04872(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04872) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ((PlainTooltipState) this.$state).setVisible$material3_release(true);
                this.label = 1;
                if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$4", f = "Tooltip.kt", i = {}, l = {771, 642}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TooltipSync$show$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $persistent;
        final /* synthetic */ TooltipState $state;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(boolean z, TooltipState tooltipState, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$persistent = z;
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.$persistent, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$persistent) {
                    TooltipState tooltipState = this.$state;
                    this.L$0 = tooltipState;
                    this.label = 1;
                    AnonymousClass4 anonymousClass4 = this;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass4), 1);
                    cancellableContinuationImpl.initCancellability();
                    ((RichTooltipState) tooltipState).setVisible$material3_release(true);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(anonymousClass4);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ((RichTooltipState) this.$state).setVisible$material3_release(true);
                    this.label = 2;
                    if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$6", f = "Tooltip.kt", i = {}, l = {655}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TooltipSync$show$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $cleanUp;
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $runBlock;
        final /* synthetic */ TooltipState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(TooltipState tooltipState, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function0<Unit> function0, Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
            this.$state = tooltipState;
            this.$runBlock = function1;
            this.$cleanUp = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass6(this.$state, this.$runBlock, this.$cleanUp, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TooltipSync.INSTANCE.setMutexOwner(this.$state);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$runBlock;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                TooltipSync.INSTANCE.setMutexOwner(null);
                this.$cleanUp.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                TooltipSync.INSTANCE.setMutexOwner(null);
                this.$cleanUp.invoke();
                throw th;
            }
        }
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.TooltipSync$dismissCurrentTooltip$2", f = "Tooltip.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TooltipSync$dismissCurrentTooltip$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public final Object dismissCurrentTooltip(TooltipState tooltipState, Continuation<? super Unit> continuation) {
        if (Intrinsics.areEqual(tooltipState, mutexOwner)) {
            Object objMutate = mutatorMutex.mutate(MutatePriority.UserInput, new AnonymousClass2(null), continuation);
            return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}