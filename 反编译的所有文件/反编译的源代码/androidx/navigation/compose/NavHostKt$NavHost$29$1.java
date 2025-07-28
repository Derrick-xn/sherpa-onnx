package androidx.navigation.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1", f = "NavHost.kt", i = {}, l = {619, 626}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class NavHostKt$NavHost$29$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ Transition<NavBackStackEntry> $transition;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$29$1(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, Transition<NavBackStackEntry> transition, Continuation<? super NavHostKt$NavHost$29$1> continuation) {
        super(2, continuation);
        this.$transitionState = seekableTransitionState;
        this.$backStackEntry = navBackStackEntry;
        this.$transition = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this.$transitionState, this.$backStackEntry, this.$transition, continuation);
        navHostKt$NavHost$29$1.L$0 = obj;
        return navHostKt$NavHost$29$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$29$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (!Intrinsics.areEqual(this.$transitionState.getCurrentState(), this.$backStackEntry)) {
                this.label = 1;
                if (SeekableTransitionState.animateTo$default(this.$transitionState, this.$backStackEntry, null, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                long totalDurationNanos = this.$transition.getTotalDurationNanos() / DurationKt.NANOS_IN_MILLIS;
                float fraction = this.$transitionState.getFraction();
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default((int) (this.$transitionState.getFraction() * totalDurationNanos), 0, null, 6, null);
                final SeekableTransitionState<NavBackStackEntry> seekableTransitionState = this.$transitionState;
                final NavBackStackEntry navBackStackEntry = this.$backStackEntry;
                this.label = 2;
                if (SuspendAnimationKt.animate$default(fraction, 0.0f, 0.0f, tweenSpecTween$default, new Function2<Float, Float, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$29$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                        invoke(f.floatValue(), f2.floatValue());
                        return Unit.INSTANCE;
                    }

                    /* compiled from: NavHost.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1", f = "NavHost.kt", i = {}, l = {634, 638}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ NavBackStackEntry $backStackEntry;
                        final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
                        final /* synthetic */ float $value;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C01151(float f, SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, Continuation<? super C01151> continuation) {
                            super(2, continuation);
                            this.$value = f;
                            this.$transitionState = seekableTransitionState;
                            this.$backStackEntry = navBackStackEntry;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C01151(this.$value, this.$transitionState, this.$backStackEntry, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C01151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                float f = this.$value;
                                if (f > 0.0f) {
                                    this.label = 1;
                                    if (SeekableTransitionState.seekTo$default(this.$transitionState, f, null, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            if (this.$value == 0.0f) {
                                this.label = 2;
                                if (this.$transitionState.snapTo(this.$backStackEntry, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public final void invoke(float f, float f2) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01151(f, seekableTransitionState, navBackStackEntry, null), 3, null);
                    }
                }, this, 4, null) == coroutine_suspended) {
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