package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListItemProvider.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemProviderImpl;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "intervalContent", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListIntervalContent;Landroidx/compose/foundation/lazy/LazyItemScopeImpl;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "headerIndexes", "", "", "getHeaderIndexes", "()Ljava/util/List;", "itemCount", "getItemCount", "()I", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getContentType", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LazyListItemProviderImpl implements LazyListItemProvider {
    private final LazyListIntervalContent intervalContent;
    private final LazyItemScopeImpl itemScope;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final LazyListState state;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, LazyItemScopeImpl lazyItemScopeImpl, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.state = lazyListState;
        this.intervalContent = lazyListIntervalContent;
        this.itemScope = lazyItemScopeImpl;
        this.keyIndexMap = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(final int i, final Object obj, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-462424778);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Item)76@3005L150,76@2951L204:LazyListItemProvider.kt#428nma");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-462424778, i3, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)");
            }
            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(obj, i, this.state.getPinnedItems(), ComposableLambdaKt.rememberComposableLambda(-824725566, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C*78@3104L27:LazyListItemProvider.kt#428nma");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-824725566, i4, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:77)");
                        }
                        LazyListIntervalContent lazyListIntervalContent = LazyListItemProviderImpl.this.intervalContent;
                        int i5 = i;
                        LazyListItemProviderImpl lazyListItemProviderImpl = LazyListItemProviderImpl.this;
                        IntervalList.Interval<LazyListInterval> interval = lazyListIntervalContent.getIntervals().get(i5);
                        interval.getValue().getItem().invoke(lazyListItemProviderImpl.getItemScope(), Integer.valueOf(i5 - interval.getStartIndex()), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LazyListItemProviderImpl.this.Item(i, obj, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int index) {
        Object key = getKeyIndexMap().getKey(index);
        return key == null ? this.intervalContent.getKey(index) : key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getContentType(int index) {
        return this.intervalContent.getContentType(index);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    public List<Integer> getHeaderIndexes() {
        return this.intervalContent.getHeaderIndexes();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getIndex(Object key) {
        return getKeyIndexMap().getIndex(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LazyListItemProviderImpl) {
            return Intrinsics.areEqual(this.intervalContent, ((LazyListItemProviderImpl) other).intervalContent);
        }
        return false;
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}