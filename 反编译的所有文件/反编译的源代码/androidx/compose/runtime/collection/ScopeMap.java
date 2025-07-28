package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeMap.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\bJ\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "set", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScopeMap<Key, Scope> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.collection.MutableScatterSet] */
    public final void add(Key key, Scope scope) {
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        Scope scope2 = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (scope2 != null) {
            if (scope2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) scope2).add(scope);
            } else if (scope2 != scope) {
                ?? mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.add(scope2);
                mutableScatterSet.add(scope);
                scope = mutableScatterSet;
            }
            scope = scope2;
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = scope;
    }

    public final void set(Key key, Scope value) {
        this.map.set(key, value);
    }

    public final boolean contains(Key element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(Key key, Function1<? super Scope, Unit> block) {
        Object obj = getMap().get(key);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            block.invoke(obj);
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Key key, Scope scope) {
        Object obj = this.map.get(key);
        if (obj == null) {
            return false;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            boolean zRemove = mutableScatterSet.remove(scope);
            if (zRemove && mutableScatterSet.isEmpty()) {
                this.map.remove(key);
            }
            return zRemove;
        }
        if (!Intrinsics.areEqual(obj, scope)) {
            return false;
        }
        this.map.remove(key);
        return true;
    }

    public final void removeScopeIf(Function1<? super Scope, Boolean> predicate) {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        int i4;
        long j;
        boolean zBooleanValue;
        int i5;
        MutableScatterMap<Object, Object> map = getMap();
        long[] jArr3 = map.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j2 = jArr3[i6];
            char c = 7;
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                int i8 = 0;
                while (i8 < i7) {
                    if ((j2 & 255) < 128) {
                        int i9 = (i6 << 3) + i8;
                        Object obj = map.keys[i9];
                        Object obj2 = map.values[i9];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr4 = mutableScatterSet.metadata;
                            int length2 = jArr4.length - 2;
                            jArr2 = jArr3;
                            i2 = length;
                            if (length2 >= 0) {
                                int i10 = 0;
                                while (true) {
                                    long j4 = jArr4[i10];
                                    i4 = i7;
                                    long[] jArr5 = jArr4;
                                    j = -9187201950435737472L;
                                    if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                        int i12 = 0;
                                        while (i12 < i11) {
                                            if ((j4 & 255) < 128) {
                                                int i13 = (i10 << 3) + i12;
                                                i5 = i6;
                                                if (predicate.invoke(objArr[i13]).booleanValue()) {
                                                    mutableScatterSet.removeElementAt(i13);
                                                }
                                            } else {
                                                i5 = i6;
                                            }
                                            j4 >>= 8;
                                            i12++;
                                            i6 = i5;
                                        }
                                        i3 = i6;
                                        if (i11 != 8) {
                                            break;
                                        }
                                    } else {
                                        i3 = i6;
                                    }
                                    if (i10 == length2) {
                                        break;
                                    }
                                    i10++;
                                    i7 = i4;
                                    jArr4 = jArr5;
                                    i6 = i3;
                                    c = 7;
                                }
                            } else {
                                i3 = i6;
                                i4 = i7;
                                j = -9187201950435737472L;
                            }
                            zBooleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr3;
                            i2 = length;
                            i3 = i6;
                            i4 = i7;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                            zBooleanValue = predicate.invoke(obj2).booleanValue();
                        }
                        if (zBooleanValue) {
                            map.removeValueAt(i9);
                        }
                    } else {
                        jArr2 = jArr3;
                        i2 = length;
                        i3 = i6;
                        i4 = i7;
                        j = j3;
                    }
                    j2 >>= 8;
                    i8++;
                    j3 = j;
                    jArr3 = jArr2;
                    length = i2;
                    i7 = i4;
                    i6 = i3;
                    c = 7;
                }
                jArr = jArr3;
                int i14 = length;
                int i15 = i6;
                if (i7 != 8) {
                    return;
                }
                length = i14;
                i = i15;
            } else {
                jArr = jArr3;
                i = i6;
            }
            if (i == length) {
                return;
            }
            i6 = i + 1;
            jArr3 = jArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeScope(Scope r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r2 = r0.map
            r3 = r2
            androidx.collection.ScatterMap r3 = (androidx.collection.ScatterMap) r3
            long[] r3 = r3.metadata
            int r4 = r3.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L67
            r5 = 0
            r6 = 0
        L12:
            r7 = r3[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L62
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L2c:
            if (r11 >= r9) goto L60
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.32E-322)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L5c
            int r12 = r6 << 3
            int r12 = r12 + r11
            java.lang.Object[] r13 = r2.keys
            r13 = r13[r12]
            java.lang.Object[] r13 = r2.values
            r13 = r13[r12]
            boolean r14 = r13 instanceof androidx.collection.MutableScatterSet
            if (r14 == 0) goto L57
            java.lang.String r14 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)
            androidx.collection.MutableScatterSet r13 = (androidx.collection.MutableScatterSet) r13
            r13.remove(r1)
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L5c
            goto L59
        L57:
            if (r13 != r1) goto L5c
        L59:
            r2.removeValueAt(r12)
        L5c:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L2c
        L60:
            if (r9 != r10) goto L67
        L62:
            if (r6 == r4) goto L67
            int r6 = r6 + 1
            goto L12
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.removeScope(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<Key, java.util.Set<Scope>> asMap() {
        /*
            r18 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = r18
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r2 = r1.map
            androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
            java.lang.Object[] r3 = r2.keys
            java.lang.Object[] r4 = r2.values
            long[] r2 = r2.metadata
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L7a
            r6 = 0
            r7 = 0
        L18:
            r8 = r2[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L75
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L32:
            if (r12 >= r10) goto L73
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L6f
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            r15 = r0
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r11 = "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r11)
            boolean r11 = r13 instanceof androidx.collection.MutableScatterSet
            if (r11 == 0) goto L5c
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r11)
            androidx.collection.MutableScatterSet r13 = (androidx.collection.MutableScatterSet) r13
            java.util.Set r11 = r13.asSet()
            goto L6a
        L5c:
            java.lang.String r11 = "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r11)
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r11[r6] = r13
            java.util.Set r11 = kotlin.collections.SetsKt.mutableSetOf(r11)
        L6a:
            r15.put(r14, r11)
            r11 = 8
        L6f:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L32
        L73:
            if (r10 != r11) goto L7a
        L75:
            if (r7 == r5) goto L7a
            int r7 = r7 + 1
            goto L18
        L7a:
            java.util.Map r0 = (java.util.Map) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.asMap():java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean anyScopeOf(Key r18, kotlin.jvm.functions.Function1<? super Scope, java.lang.Boolean> r19) {
        /*
            r17 = this;
            r0 = r19
            androidx.collection.MutableScatterMap r1 = r17.getMap()
            r2 = r18
            java.lang.Object r1 = r1.get(r2)
            r2 = 0
            if (r1 == 0) goto L71
            boolean r3 = r1 instanceof androidx.collection.MutableScatterSet
            r4 = 1
            if (r3 == 0) goto L64
            androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            java.lang.Object[] r3 = r1.elements
            long[] r1 = r1.metadata
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L71
            r6 = 0
        L22:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L5f
            int r9 = r6 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L3c:
            if (r11 >= r9) goto L5d
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.32E-322)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L59
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            java.lang.Object r12 = r0.invoke(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L59
            return r4
        L59:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L3c
        L5d:
            if (r9 != r10) goto L71
        L5f:
            if (r6 == r5) goto L71
            int r6 = r6 + 1
            goto L22
        L64:
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L71
            return r4
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.anyScopeOf(java.lang.Object, kotlin.jvm.functions.Function1):boolean");
    }
}