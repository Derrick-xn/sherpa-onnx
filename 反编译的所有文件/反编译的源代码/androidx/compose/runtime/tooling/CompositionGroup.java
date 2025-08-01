package androidx.compose.runtime.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import kotlin.Metadata;

/* compiled from: CompositionData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/tooling/CompositionData;", "data", "", "", "getData", "()Ljava/lang/Iterable;", "groupSize", "", "getGroupSize", "()I", "identity", "getIdentity", "()Ljava/lang/Object;", "key", "getKey", "node", "getNode", "slotsSize", "getSlotsSize", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CompositionGroup extends CompositionData {
    Iterable<Object> getData();

    int getGroupSize();

    Object getIdentity();

    Object getKey();

    Object getNode();

    int getSlotsSize();

    String getSourceInfo();

    /* compiled from: CompositionData.kt */
    /* renamed from: androidx.compose.runtime.tooling.CompositionGroup$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getGroupSize(CompositionGroup _this) {
            return 0;
        }

        public static Object $default$getIdentity(CompositionGroup _this) {
            return null;
        }

        public static int $default$getSlotsSize(CompositionGroup _this) {
            return 0;
        }
    }

    /* compiled from: CompositionData.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CompositionGroup find(CompositionGroup compositionGroup, Object obj) {
            return CompositionData.CC.$default$find(compositionGroup, obj);
        }

        @Deprecated
        public static Object getIdentity(CompositionGroup compositionGroup) {
            return CC.$default$getIdentity(compositionGroup);
        }

        @Deprecated
        public static int getGroupSize(CompositionGroup compositionGroup) {
            return CC.$default$getGroupSize(compositionGroup);
        }

        @Deprecated
        public static int getSlotsSize(CompositionGroup compositionGroup) {
            return CC.$default$getSlotsSize(compositionGroup);
        }
    }
}