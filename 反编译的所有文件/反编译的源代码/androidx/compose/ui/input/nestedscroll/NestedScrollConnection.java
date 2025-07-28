package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: NestedScrollModifier.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY */
    Object mo506onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M */
    long mo507onPostScrollDzOQY0M(long consumed, long available, int source);

    /* renamed from: onPreFling-QWom1Mo */
    Object mo508onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk */
    long mo509onPreScrollOzD1aCk(long available, int source);

    /* compiled from: NestedScrollModifier.kt */
    /* renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollConnection$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m4413$default$onPreScrollOzD1aCk(NestedScrollConnection _this, long j, int i) {
            return Offset.INSTANCE.m3060getZeroF1C5BW0();
        }

        /* renamed from: $default$onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m4411$default$onPostScrollDzOQY0M(NestedScrollConnection _this, long j, long j2, int i) {
            return Offset.INSTANCE.m3060getZeroF1C5BW0();
        }

        /* renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
        public static /* synthetic */ Object m4419onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
            return Velocity.m6076boximpl(Velocity.INSTANCE.m6096getZero9UxMQ8M());
        }

        /* renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
        public static /* synthetic */ Object m4418onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
            return Velocity.m6076boximpl(Velocity.INSTANCE.m6096getZero9UxMQ8M());
        }
    }

    /* compiled from: NestedScrollModifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m4423onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j, int i) {
            return CC.m4413$default$onPreScrollOzD1aCk(nestedScrollConnection, j, i);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m4421onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return CC.m4411$default$onPostScrollDzOQY0M(nestedScrollConnection, j, j2, i);
        }

        @Deprecated
        /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m4422onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
            return CC.m4419onPreFlingQWom1Mo$suspendImpl(nestedScrollConnection, j, continuation);
        }

        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m4420onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
            return CC.m4418onPostFlingRZ2iAVY$suspendImpl(nestedScrollConnection, j, j2, continuation);
        }
    }
}