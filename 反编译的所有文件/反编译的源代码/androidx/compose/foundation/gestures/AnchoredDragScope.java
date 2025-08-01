package androidx.compose.foundation.gestures;

import kotlin.Metadata;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDragScope;", "", "dragTo", "", "newOffset", "", "lastKnownVelocity", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AnchoredDragScope {
    void dragTo(float newOffset, float lastKnownVelocity);

    /* compiled from: AnchoredDraggable.kt */
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDragScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void dragTo$default(AnchoredDragScope anchoredDragScope, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            anchoredDragScope.dragTo(f, f2);
        }
    }
}