package androidx.compose.ui.graphics;

import androidx.core.internal.view.SupportMenu;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0081@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001b\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0013\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0013\u0010M\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u0018\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0088\u0001\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final short Epsilon = m3434constructorimpl((short) 5120);
    private static final short LowestValue = m3434constructorimpl((short) -1025);
    private static final short MaxValue = m3434constructorimpl((short) 31743);
    private static final short MinNormal = m3434constructorimpl((short) 1024);
    private static final short MinValue = m3434constructorimpl((short) 1);
    private static final short NaN = m3434constructorimpl((short) 32256);
    private static final short NegativeInfinity = m3434constructorimpl((short) -1024);
    private static final short NegativeZero = m3434constructorimpl(ShortCompanionObject.MIN_VALUE);
    private static final short PositiveInfinity = m3434constructorimpl((short) 31744);
    private static final short PositiveZero = m3434constructorimpl((short) 0);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m3429boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3434constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3435equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m3460unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3436equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: getExponent-impl, reason: not valid java name */
    public static final int m3438getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m3440getSignificandimpl(short s) {
        return s & 1023;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3441hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m3442isFiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) != 31744;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m3443isInfiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) == 31744;
    }

    /* renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m3444isNaNimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) > 31744;
    }

    /* renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m3445isNormalizedimpl(short s) {
        int i = s & 31744;
        return (i == 0 || i == 31744) ? false : true;
    }

    /* renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m3454toRawBitsimpl(short s) {
        return s & UShort.MAX_VALUE;
    }

    public boolean equals(Object obj) {
        return m3435equalsimpl(this.halfValue, obj);
    }

    public int hashCode() {
        return m3441hashCodeimpl(this.halfValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m3460unboximpl() {
        return this.halfValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m3459compareTo41bOqos(float16.m3460unboximpl());
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3432constructorimpl(double d) {
        return m3433constructorimpl((float) d);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    public static final byte m3448toByteimpl(short s) {
        return (byte) m3450toFloatimpl(s);
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    public static final short m3455toShortimpl(short s) {
        return (short) m3450toFloatimpl(s);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m3452toIntimpl(short s) {
        return (int) m3450toFloatimpl(s);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m3453toLongimpl(short s) {
        return (long) m3450toFloatimpl(s);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m3449toDoubleimpl(short s) {
        return m3450toFloatimpl(s);
    }

    /* renamed from: toBits-impl, reason: not valid java name */
    public static final int m3447toBitsimpl(short s) {
        return m3444isNaNimpl(s) ? NaN : s & UShort.MAX_VALUE;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3456toStringimpl(short s) {
        return String.valueOf(m3450toFloatimpl(s));
    }

    public String toString() {
        return m3456toStringimpl(this.halfValue);
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m3459compareTo41bOqos(short s) {
        return m3431compareTo41bOqos(this.halfValue, s);
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m3431compareTo41bOqos(short s, short s2) {
        if (m3444isNaNimpl(s)) {
            return !m3444isNaNimpl(s2) ? 1 : 0;
        }
        if (m3444isNaNimpl(s2)) {
            return -1;
        }
        return Intrinsics.compare((s & 32768) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE, (s2 & 32768) != 0 ? 32768 - (s2 & UShort.MAX_VALUE) : s2 & UShort.MAX_VALUE);
    }

    /* renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m3439getSignslo4al4(short s) {
        if (m3444isNaNimpl(s)) {
            return NaN;
        }
        if (m3431compareTo41bOqos(s, NegativeZero) < 0) {
            return Float16Kt.NegativeOne;
        }
        return m3431compareTo41bOqos(s, PositiveZero) > 0 ? Float16Kt.One : s;
    }

    /* renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m3458withSignqCeQghg(short s, short s2) {
        return m3434constructorimpl((short) ((s & ShortCompanionObject.MAX_VALUE) | (s2 & ShortCompanionObject.MIN_VALUE)));
    }

    /* renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m3428absoluteValueslo4al4(short s) {
        return m3434constructorimpl((short) (s & ShortCompanionObject.MAX_VALUE));
    }

    /* renamed from: round-slo4al4, reason: not valid java name */
    public static final short m3446roundslo4al4(short s) {
        int i = SupportMenu.USER_MASK;
        int i2 = s & UShort.MAX_VALUE;
        int i3 = s & ShortCompanionObject.MAX_VALUE;
        if (i3 < 15360) {
            int i4 = s & ShortCompanionObject.MIN_VALUE;
            if (i3 < 14336) {
                i = 0;
            }
            i2 = i4 | (i & 15360);
        } else if (i3 < 25600) {
            int i5 = i3 >> 10;
            i2 = (i2 + (1 << (24 - i5))) & (~((1 << (25 - i5)) - 1));
        }
        return m3434constructorimpl((short) i2);
    }

    /* renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m3430ceilslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = ((-((~(i >> 15)) & (i2 == 0 ? 0 : 1))) & 15360) | (s & ShortCompanionObject.MIN_VALUE);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i3)) & (~i3);
        }
        return m3434constructorimpl((short) i);
    }

    /* renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m3437floorslo4al4(short s) {
        int i = SupportMenu.USER_MASK;
        int i2 = s & UShort.MAX_VALUE;
        int i3 = s & ShortCompanionObject.MAX_VALUE;
        if (i3 < 15360) {
            int i4 = s & ShortCompanionObject.MIN_VALUE;
            if (i2 <= 32768) {
                i = 0;
            }
            i2 = i4 | (i & 15360);
        } else if (i3 < 25600) {
            int i5 = (1 << (25 - (i3 >> 10))) - 1;
            i2 = (i2 + ((-(i2 >> 15)) & i5)) & (~i5);
        }
        return m3434constructorimpl((short) i2);
    }

    /* renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m3457truncslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = 32768 & s;
        } else if (i2 < 25600) {
            i &= ~((1 << (25 - (i2 >> 10))) - 1);
        }
        return m3434constructorimpl((short) i);
    }

    /* renamed from: toHexString-impl, reason: not valid java name */
    public static final String m3451toHexStringimpl(short s) {
        StringBuilder sb = new StringBuilder();
        int i = 65535 & s;
        int i2 = i >>> 15;
        int i3 = (i >>> 10) & 31;
        int i4 = s & 1023;
        if (i3 != 31) {
            if (i2 == 1) {
                sb.append('-');
            }
            if (i3 != 0) {
                sb.append("0x1.");
                String string = Integer.toString(i4, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(string, ""));
                sb.append('p');
                sb.append(String.valueOf(i3 - 15));
            } else if (i4 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String string2 = Integer.toString(i4, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(string2, ""));
                sb.append("p-14");
            }
        } else if (i4 == 0) {
            if (i2 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        return sb.toString();
    }

    /* compiled from: Float16.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0014\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001c\u0010\u0006R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m3461getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m3462getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m3463getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m3464getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m3465getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m3466getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m3467getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m3468getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m3469getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m3470getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3433constructorimpl(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = iFloatToRawIntBits >>> 31;
        int i3 = (iFloatToRawIntBits >>> 23) & 255;
        int i4 = 8388607 & iFloatToRawIntBits;
        int i5 = 31;
        int i6 = 0;
        if (i3 != 255) {
            int i7 = i3 - 112;
            if (i7 >= 31) {
                i5 = 49;
            } else if (i7 <= 0) {
                if (i7 >= -10) {
                    int i8 = (8388608 | i4) >> (1 - i7);
                    if ((i8 & 4096) != 0) {
                        i8 += 8192;
                    }
                    i6 = i8 >> 13;
                }
                i5 = 0;
            } else {
                i6 = i4 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i7 << 10) | i6) + 1) | (i2 << 15);
                    return m3434constructorimpl((short) i);
                }
                i5 = i7;
            }
        } else if (i4 != 0) {
            i6 = 512;
        }
        i = (i2 << 15) | (i5 << 10) | i6;
        return m3434constructorimpl((short) i);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m3450toFloatimpl(short s) {
        int i;
        int i2;
        int i3 = 32768 & s;
        int i4 = ((65535 & s) >>> 10) & 31;
        int i5 = s & 1023;
        if (i4 != 0) {
            int i6 = i5 << 13;
            if (i4 == 31) {
                if (i6 != 0) {
                    i6 |= 4194304;
                }
                i = i6;
                i2 = 255;
            } else {
                int i7 = i4 + 112;
                i = i6;
                i2 = i7;
            }
        } else {
            if (i5 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i5 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i3 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i2 = 0;
            i = 0;
        }
        return Float.intBitsToFloat((i2 << 23) | (i3 << 16) | i);
    }
}