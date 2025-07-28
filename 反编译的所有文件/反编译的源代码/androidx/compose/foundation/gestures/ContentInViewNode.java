package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: ContentInViewNode.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001EB'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"H\u0096@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\u0011J\u001a\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\"\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\fH\u0002J \u0010:\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001f\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001f\u0010;\u001a\u00020<*\u00020\u001a2\u0006\u0010>\u001a\u00020\u001aH\u0082\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010@J \u0010B\u001a\u00020\n*\u00020\u00132\b\b\u0002\u00102\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "trackingFocusedChild", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "requireBringIntoViewSpec", "update", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private long viewportSize = IntSize.INSTANCE.m6023getZeroYbymL2g();

    /* compiled from: ContentInViewNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
        LayoutAwareModifierNode.CC.$default$onPlaced(this, layoutCoordinates);
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = z;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* renamed from: getViewportSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getViewportSize() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        if (!(!IntSize.m6016equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6023getZeroYbymL2g()))) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m421computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
        return bringIntoViewSpec == null ? (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec()) : bringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) throws Throwable {
        Rect rectInvoke = function0.invoke();
        if (rectInvoke == null || m423isMaxVisibleO0kMr_c$default(this, rectInvoke, 0L, 1, null)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.bringIntoViewRequests.enqueue(new Request(function0, cancellableContinuationImpl)) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates newBounds) {
        this.focusedChild = newBounds;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo387onRemeasuredozmzZPI(long size) {
        Rect focusedChildBounds;
        long j = this.viewportSize;
        this.viewportSize = size;
        if (m419compareToTemP2vQ(size, j) < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m422isMaxVisibleO0kMr_c(rect, j) && !m422isMaxVisibleO0kMr_c(focusedChildBounds, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        if (!getIsAttached()) {
            return null;
        }
        LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates layoutCoordinates = this.focusedChild;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                return layoutCoordinatesRequireLayoutCoordinates.localBoundingBoxOf(layoutCoordinates, false);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        BringIntoViewSpec bringIntoViewSpecRequireBringIntoViewSpec = requireBringIntoViewSpec();
        if (!(!this.isAnimationRunning)) {
            throw new IllegalStateException("launchAnimation called when previous animation was running".toString());
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(new UpdatableAnimationState(bringIntoViewSpecRequireBringIntoViewSpec.getScrollAnimationSpec()), bringIntoViewSpecRequireBringIntoViewSpec, null), 1, null);
    }

    /* compiled from: ContentInViewNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.$bringIntoViewSpec = bringIntoViewSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ContentInViewNode.this.new AnonymousClass2(this.$animationState, this.$bringIntoViewSpec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            CancellationException cancellationException = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                        ContentInViewNode.this.isAnimationRunning = true;
                        this.label = 1;
                        if (ContentInViewNode.this.scrollingLogic.scroll(MutatePriority.Default, new AnonymousClass1(this.$animationState, ContentInViewNode.this, this.$bringIntoViewSpec, job, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                    ContentInViewNode.this.isAnimationRunning = false;
                    ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(null);
                    ContentInViewNode.this.trackingFocusedChild = false;
                    return Unit.INSTANCE;
                } catch (CancellationException e) {
                    cancellationException = e;
                    throw cancellationException;
                }
            } catch (Throwable th) {
                ContentInViewNode.this.isAnimationRunning = false;
                ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                ContentInViewNode.this.trackingFocusedChild = false;
                throw th;
            }
        }

        /* compiled from: ContentInViewNode.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", i = {}, l = {ComposerKt.providerKey}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $animationJob;
            final /* synthetic */ UpdatableAnimationState $animationState;
            final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, Job job, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$animationState = updatableAnimationState;
                this.this$0 = contentInViewNode;
                this.$bringIntoViewSpec = bringIntoViewSpec;
                this.$animationJob = job;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
                    this.$animationState.setValue(this.this$0.calculateScrollDelta(this.$bringIntoViewSpec));
                    UpdatableAnimationState updatableAnimationState = this.$animationState;
                    final ContentInViewNode contentInViewNode = this.this$0;
                    final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                    final Job job = this.$animationJob;
                    Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f) {
                            float f2 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                            ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                            float fM524toFloatk4lQ0M = f2 * scrollingLogic.m524toFloatk4lQ0M(scrollingLogic.m522reverseIfNeededMKHz9U(nestedScrollScope.mo478scrollByOzD1aCk(scrollingLogic.m522reverseIfNeededMKHz9U(scrollingLogic.m525toOffsettuRUvjQ(f2 * f)), NestedScrollSource.INSTANCE.m4443getUserInputWNlRxjI())));
                            if (Math.abs(fM524toFloatk4lQ0M) < Math.abs(f)) {
                                JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + fM524toFloatk4lQ0M + " < " + f + ')', null, 2, null);
                            }
                        }
                    };
                    final ContentInViewNode contentInViewNode2 = this.this$0;
                    final UpdatableAnimationState updatableAnimationState3 = this.$animationState;
                    final BringIntoViewSpec bringIntoViewSpec = this.$bringIntoViewSpec;
                    this.label = 1;
                    if (updatableAnimationState.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            Rect focusedChildBounds;
                            Rect rectInvoke;
                            BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode2.bringIntoViewRequests;
                            ContentInViewNode contentInViewNode3 = contentInViewNode2;
                            while (bringIntoViewRequestPriorityQueue.requests.isNotEmpty() && ((rectInvoke = ((Request) bringIntoViewRequestPriorityQueue.requests.last()).getCurrentBounds().invoke()) == null || ContentInViewNode.m423isMaxVisibleO0kMr_c$default(contentInViewNode3, rectInvoke, 0L, 1, null))) {
                                CancellableContinuation<Unit> continuation = ((Request) bringIntoViewRequestPriorityQueue.requests.removeAt(bringIntoViewRequestPriorityQueue.requests.getSize() - 1)).getContinuation();
                                Unit unit = Unit.INSTANCE;
                                Result.Companion companion = Result.INSTANCE;
                                continuation.resumeWith(Result.m6309constructorimpl(unit));
                            }
                            if (contentInViewNode2.trackingFocusedChild && (focusedChildBounds = contentInViewNode2.getFocusedChildBounds()) != null && ContentInViewNode.m423isMaxVisibleO0kMr_c$default(contentInViewNode2, focusedChildBounds, 0L, 1, null)) {
                                contentInViewNode2.trackingFocusedChild = false;
                            }
                            updatableAnimationState3.setValue(contentInViewNode2.calculateScrollDelta(bringIntoViewSpec));
                        }
                    }, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta(BringIntoViewSpec bringIntoViewSpec) {
        if (IntSize.m6016equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6023getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectFindBringIntoViewRequest = findBringIntoViewRequest();
        if (rectFindBringIntoViewRequest == null) {
            rectFindBringIntoViewRequest = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectFindBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long jM6030toSizeozmzZPI = IntSizeKt.m6030toSizeozmzZPI(this.viewportSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getTop(), rectFindBringIntoViewRequest.getBottom() - rectFindBringIntoViewRequest.getTop(), Size.m3110getHeightimpl(jM6030toSizeozmzZPI));
        }
        if (i == 2) {
            return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getLeft(), rectFindBringIntoViewRequest.getRight() - rectFindBringIntoViewRequest.getLeft(), Size.m3113getWidthimpl(jM6030toSizeozmzZPI));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector mutableVector = this.bringIntoViewRequests.requests;
        int size = mutableVector.getSize();
        Rect rect = null;
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                Rect rectInvoke = ((Request) content[i]).getCurrentBounds().invoke();
                if (rectInvoke != null) {
                    if (m420compareToiLBOSCw(rectInvoke.m3077getSizeNHjbRc(), IntSizeKt.m6030toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect == null ? rectInvoke : rect;
                    }
                    rect = rectInvoke;
                }
                i--;
            } while (i >= 0);
        }
        return rect;
    }

    /* renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m421computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m3081translatek4lQ0M(Offset.m3053unaryMinusF1C5BW0(m424relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    /* renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    static /* synthetic */ boolean m423isMaxVisibleO0kMr_c$default(ContentInViewNode contentInViewNode, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewNode.viewportSize;
        }
        return contentInViewNode.m422isMaxVisibleO0kMr_c(rect, j);
    }

    /* renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m422isMaxVisibleO0kMr_c(Rect rect, long j) {
        long jM424relocationOffsetBMxPBkI = m424relocationOffsetBMxPBkI(rect, j);
        return Math.abs(Offset.m3044getXimpl(jM424relocationOffsetBMxPBkI)) <= 0.5f && Math.abs(Offset.m3045getYimpl(jM424relocationOffsetBMxPBkI)) <= 0.5f;
    }

    /* renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m424relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long jM6030toSizeozmzZPI = IntSizeKt.m6030toSizeozmzZPI(containerSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(0.0f, requireBringIntoViewSpec().calculateScrollDistance(childBounds.getTop(), childBounds.getBottom() - childBounds.getTop(), Size.m3110getHeightimpl(jM6030toSizeozmzZPI)));
        }
        if (i == 2) {
            return OffsetKt.Offset(requireBringIntoViewSpec().calculateScrollDistance(childBounds.getLeft(), childBounds.getRight() - childBounds.getLeft(), Size.m3113getWidthimpl(jM6030toSizeozmzZPI)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m419compareToTemP2vQ(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Intrinsics.compare(IntSize.m6017getHeightimpl(j), IntSize.m6017getHeightimpl(j2));
        }
        if (i == 2) {
            return Intrinsics.compare(IntSize.m6018getWidthimpl(j), IntSize.m6018getWidthimpl(j2));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m420compareToiLBOSCw(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Float.compare(Size.m3110getHeightimpl(j), Size.m3110getHeightimpl(j2));
        }
        if (i == 2) {
            return Float.compare(Size.m3113getWidthimpl(j), Size.m3113getWidthimpl(j2));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void update(Orientation orientation, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* compiled from: ContentInViewNode.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> function0, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.currentBounds = function0;
            this.continuation = cancellableContinuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r4 = this;
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r4.continuation
                kotlin.coroutines.CoroutineContext r0 = r0.getContext()
                kotlinx.coroutines.CoroutineName$Key r1 = kotlinx.coroutines.CoroutineName.INSTANCE
                kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.CoroutineName r0 = (kotlinx.coroutines.CoroutineName) r0
                if (r0 == 0) goto L17
                java.lang.String r0 = r0.getName()
                goto L18
            L17:
                r0 = 0
            L18:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Request@"
                r1.<init>(r2)
                int r2 = r4.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.checkRadix(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(this, checkRadix(radix))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                r1.append(r2)
                if (r0 == 0) goto L4d
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "["
                r2.<init>(r3)
                r2.append(r0)
                java.lang.String r0 = "]("
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                if (r0 != 0) goto L4f
            L4d:
                java.lang.String r0 = "("
            L4f:
                r1.append(r0)
                java.lang.String r0 = "currentBounds()="
                r1.append(r0)
                kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r0 = r4.currentBounds
                java.lang.Object r0 = r0.invoke()
                r1.append(r0)
                java.lang.String r0 = ", continuation="
                r1.append(r0)
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r4.continuation
                r1.append(r0)
                r0 = 41
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode.Request.toString():java.lang.String");
        }
    }
}