package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TransformScope {
    /* renamed from: transformBy-d-4ec7I */
    void mo428transformByd4ec7I(float zoomChange, long panChange, float rotationChange);

    /* compiled from: TransformableState.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* compiled from: TransformableState.kt */
    /* renamed from: androidx.compose.foundation.gestures.TransformScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: transformBy-d-4ec7I$default, reason: not valid java name */
        public static /* synthetic */ void m535transformByd4ec7I$default(TransformScope transformScope, float f, long j, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
            }
            if ((i & 1) != 0) {
                f = 1.0f;
            }
            if ((i & 2) != 0) {
                j = Offset.INSTANCE.m3060getZeroF1C5BW0();
            }
            if ((i & 4) != 0) {
                f2 = 0.0f;
            }
            transformScope.mo428transformByd4ec7I(f, j, f2);
        }
    }
}