package androidx.navigation.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: RouteDecoder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0001J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/serialization/Decoder;", "", "store", "Landroidx/navigation/serialization/ArgStore;", "(Landroidx/navigation/serialization/ArgStore;)V", "elementIndex", "", "elementName", "", "computeNextElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeValue", "isCurrentElementNull", "", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class Decoder {
    private int elementIndex;
    private String elementName;
    private final ArgStore store;

    public Decoder(ArgStore store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
        this.elementIndex = -1;
        this.elementName = "";
    }

    public final int computeNextElementIndex(SerialDescriptor descriptor) {
        String elementName;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = this.elementIndex;
        do {
            i++;
            if (i >= descriptor.getElementsCount()) {
                return -1;
            }
            elementName = descriptor.getElementName(i);
        } while (!this.store.contains(elementName));
        this.elementIndex = i;
        this.elementName = elementName;
        return i;
    }

    public final Object decodeValue() {
        Object obj = this.store.get(this.elementName);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Unexpected null value for non-nullable argument " + this.elementName).toString());
    }

    public final boolean isCurrentElementNull() {
        return this.store.get(this.elementName) == null;
    }
}