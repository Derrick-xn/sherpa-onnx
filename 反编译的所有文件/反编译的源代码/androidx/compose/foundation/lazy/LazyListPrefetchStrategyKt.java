package androidx.compose.foundation.lazy;

import kotlin.Metadata;

/* compiled from: LazyListPrefetchStrategy.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"LazyListPrefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "nestedPrefetchItemCount", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListPrefetchStrategyKt {
    public static /* synthetic */ LazyListPrefetchStrategy LazyListPrefetchStrategy$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return LazyListPrefetchStrategy(i);
    }

    public static final LazyListPrefetchStrategy LazyListPrefetchStrategy(int i) {
        return new DefaultLazyListPrefetchStrategy(i);
    }
}