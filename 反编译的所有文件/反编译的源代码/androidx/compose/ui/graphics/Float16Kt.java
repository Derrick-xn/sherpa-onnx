package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;

/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\r\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0080\b\u001a\u0011\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\u0080\b\u001a\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001f\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0017H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Fp16Combined", "", "Fp16ExponentBias", "Fp16ExponentMask", "Fp16ExponentMax", "Fp16ExponentShift", "Fp16SignMask", "Fp16SignShift", "Fp16SignificandMask", "Fp32DenormalFloat", "", "Fp32DenormalMagic", "Fp32ExponentBias", "Fp32ExponentMask", "Fp32ExponentShift", "Fp32QNaNMask", "Fp32SignShift", "Fp32SignificandMask", "NegativeOne", "Landroidx/compose/ui/graphics/Float16;", "S", "One", "floatToHalf", "", "f", "halfToFloat", "h", "max", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "toCompareValue", "value", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final short One = Float16.m3433constructorimpl(1.0f);
    private static final short NegativeOne = Float16.m3433constructorimpl(-1.0f);
    private static final int Fp32DenormalMagic = 1056964608;
    private static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);

    private static final int toCompareValue(short s) {
        return (s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE;
    }

    public static final short floatToHalf(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = iFloatToRawIntBits >>> 31;
        int i3 = (iFloatToRawIntBits >>> 23) & 255;
        int i4 = Fp32SignificandMask & iFloatToRawIntBits;
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
                    return (short) i;
                }
                i5 = i7;
            }
        } else if (i4 != 0) {
            i6 = 512;
        }
        i = (i2 << 15) | (i5 << 10) | i6;
        return (short) i;
    }

    /* renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m3472minAoSsdG0(short s, short s2) {
        if (Float16.m3444isNaNimpl(s) || Float16.m3444isNaNimpl(s2)) {
            return Float16.INSTANCE.m3466getNaNslo4al4();
        }
        return Float16.m3431compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }

    /* renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m3471maxAoSsdG0(short s, short s2) {
        if (Float16.m3444isNaNimpl(s) || Float16.m3444isNaNimpl(s2)) {
            return Float16.INSTANCE.m3466getNaNslo4al4();
        }
        return Float16.m3431compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    public static final float halfToFloat(short s) {
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
                float fIntBitsToFloat = Float.intBitsToFloat(i5 + Fp32DenormalMagic) - Fp32DenormalFloat;
                return i3 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i2 = 0;
            i = 0;
        }
        return Float.intBitsToFloat((i2 << 23) | (i3 << 16) | i);
    }
}