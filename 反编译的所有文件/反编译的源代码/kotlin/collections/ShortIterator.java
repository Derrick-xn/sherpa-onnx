package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: PrimitiveIterators.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lkotlin/collections/ShortIterator;", "", "", "()V", "next", "()Ljava/lang/Short;", "nextShort", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ShortIterator implements Iterator<Short>, KMappedMarker {
    public abstract short nextShort();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(nextShort());
    }

    @Override // java.util.Iterator
    /* renamed from: next, reason: avoid collision after fix types in other method */
    public final Short next2() {
        return Short.valueOf(nextShort());
    }
}