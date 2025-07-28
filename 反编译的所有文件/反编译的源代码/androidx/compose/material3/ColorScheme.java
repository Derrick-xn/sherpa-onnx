package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bð\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 Jµ\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016R4\u0010\u0010\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R4\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R4\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R4\u0010\u0017\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R4\u0010\u0011\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R4\u0010\u001a\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R4\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b?\u0010'\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bB\u0010'\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R4\u0010\t\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bH\u0010'\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R4\u0010\u0013\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R4\u0010\u0015\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bQ\u0010'\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R4\u0010\r\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bT\u0010'\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R4\u0010\u000f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bW\u0010'\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R4\u0010\u001d\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bZ\u0010'\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R4\u0010\u001e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b]\u0010'\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b`\u0010'\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bc\u0010'\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R4\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bf\u0010'\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R4\u0010\b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bi\u0010'\u001a\u0004\bg\u0010#\"\u0004\bh\u0010%R4\u0010\n\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bl\u0010'\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R4\u0010\u0012\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bo\u0010'\u001a\u0004\bm\u0010#\"\u0004\bn\u0010%R4\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\br\u0010'\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R4\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bu\u0010'\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R4\u0010\f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bx\u0010'\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b{\u0010'\u001a\u0004\by\u0010#\"\u0004\bz\u0010%\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material3_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material3_release", "error$delegate", "getErrorContainer-0d7_KjU", "setErrorContainer-8_81llA$material3_release", "errorContainer$delegate", "getInverseOnSurface-0d7_KjU", "setInverseOnSurface-8_81llA$material3_release", "inverseOnSurface$delegate", "getInversePrimary-0d7_KjU", "setInversePrimary-8_81llA$material3_release", "inversePrimary$delegate", "getInverseSurface-0d7_KjU", "setInverseSurface-8_81llA$material3_release", "inverseSurface$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material3_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material3_release", "onError$delegate", "getOnErrorContainer-0d7_KjU", "setOnErrorContainer-8_81llA$material3_release", "onErrorContainer$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material3_release", "onPrimary$delegate", "getOnPrimaryContainer-0d7_KjU", "setOnPrimaryContainer-8_81llA$material3_release", "onPrimaryContainer$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material3_release", "onSecondary$delegate", "getOnSecondaryContainer-0d7_KjU", "setOnSecondaryContainer-8_81llA$material3_release", "onSecondaryContainer$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material3_release", "onSurface$delegate", "getOnSurfaceVariant-0d7_KjU", "setOnSurfaceVariant-8_81llA$material3_release", "onSurfaceVariant$delegate", "getOnTertiary-0d7_KjU", "setOnTertiary-8_81llA$material3_release", "onTertiary$delegate", "getOnTertiaryContainer-0d7_KjU", "setOnTertiaryContainer-8_81llA$material3_release", "onTertiaryContainer$delegate", "getOutline-0d7_KjU", "setOutline-8_81llA$material3_release", "outline$delegate", "getOutlineVariant-0d7_KjU", "setOutlineVariant-8_81llA$material3_release", "outlineVariant$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material3_release", "primary$delegate", "getPrimaryContainer-0d7_KjU", "setPrimaryContainer-8_81llA$material3_release", "primaryContainer$delegate", "getScrim-0d7_KjU", "setScrim-8_81llA$material3_release", "scrim$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material3_release", "secondary$delegate", "getSecondaryContainer-0d7_KjU", "setSecondaryContainer-8_81llA$material3_release", "secondaryContainer$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material3_release", "surface$delegate", "getSurfaceTint-0d7_KjU", "setSurfaceTint-8_81llA$material3_release", "surfaceTint$delegate", "getSurfaceVariant-0d7_KjU", "setSurfaceVariant-8_81llA$material3_release", "surfaceVariant$delegate", "getTertiary-0d7_KjU", "setTertiary-8_81llA$material3_release", "tertiary$delegate", "getTertiaryContainer-0d7_KjU", "setTertiaryContainer-8_81llA$material3_release", "tertiaryContainer$delegate", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorScheme {
    public static final int $stable = 0;

    /* renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: errorContainer$delegate, reason: from kotlin metadata */
    private final MutableState errorContainer;

    /* renamed from: inverseOnSurface$delegate, reason: from kotlin metadata */
    private final MutableState inverseOnSurface;

    /* renamed from: inversePrimary$delegate, reason: from kotlin metadata */
    private final MutableState inversePrimary;

    /* renamed from: inverseSurface$delegate, reason: from kotlin metadata */
    private final MutableState inverseSurface;

    /* renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* renamed from: onErrorContainer$delegate, reason: from kotlin metadata */
    private final MutableState onErrorContainer;

    /* renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* renamed from: onPrimaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onPrimaryContainer;

    /* renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* renamed from: onSecondaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onSecondaryContainer;

    /* renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* renamed from: onSurfaceVariant$delegate, reason: from kotlin metadata */
    private final MutableState onSurfaceVariant;

    /* renamed from: onTertiary$delegate, reason: from kotlin metadata */
    private final MutableState onTertiary;

    /* renamed from: onTertiaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState onTertiaryContainer;

    /* renamed from: outline$delegate, reason: from kotlin metadata */
    private final MutableState outline;

    /* renamed from: outlineVariant$delegate, reason: from kotlin metadata */
    private final MutableState outlineVariant;

    /* renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* renamed from: primaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState primaryContainer;

    /* renamed from: scrim$delegate, reason: from kotlin metadata */
    private final MutableState scrim;

    /* renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* renamed from: secondaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState secondaryContainer;

    /* renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    /* renamed from: surfaceTint$delegate, reason: from kotlin metadata */
    private final MutableState surfaceTint;

    /* renamed from: surfaceVariant$delegate, reason: from kotlin metadata */
    private final MutableState surfaceVariant;

    /* renamed from: tertiary$delegate, reason: from kotlin metadata */
    private final MutableState tertiary;

    /* renamed from: tertiaryContainer$delegate, reason: from kotlin metadata */
    private final MutableState tertiaryContainer;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j20), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j22), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j23), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j24), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j25), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j26), SnapshotStateKt.structuralEqualityPolicy());
        this.outline = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j27), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j28), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim = SnapshotStateKt.mutableStateOf(Color.m3314boximpl(j29), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1547getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).m3334unboximpl();
    }

    /* renamed from: setPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1576setPrimary8_81llA$material3_release(long j) {
        this.primary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1537getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1566setOnPrimary8_81llA$material3_release(long j) {
        this.onPrimary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1548getPrimaryContainer0d7_KjU() {
        return ((Color) this.primaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1577setPrimaryContainer8_81llA$material3_release(long j) {
        this.primaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1538getOnPrimaryContainer0d7_KjU() {
        return ((Color) this.onPrimaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1567setOnPrimaryContainer8_81llA$material3_release(long j) {
        this.onPrimaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m1532getInversePrimary0d7_KjU() {
        return ((Color) this.inversePrimary.getValue()).m3334unboximpl();
    }

    /* renamed from: setInversePrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1561setInversePrimary8_81llA$material3_release(long j) {
        this.inversePrimary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1550getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).m3334unboximpl();
    }

    /* renamed from: setSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1579setSecondary8_81llA$material3_release(long j) {
        this.secondary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1539getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1568setOnSecondary8_81llA$material3_release(long j) {
        this.onSecondary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1551getSecondaryContainer0d7_KjU() {
        return ((Color) this.secondaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1580setSecondaryContainer8_81llA$material3_release(long j) {
        this.secondaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1540getOnSecondaryContainer0d7_KjU() {
        return ((Color) this.onSecondaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1569setOnSecondaryContainer8_81llA$material3_release(long j) {
        this.onSecondaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m1555getTertiary0d7_KjU() {
        return ((Color) this.tertiary.getValue()).m3334unboximpl();
    }

    /* renamed from: setTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1584setTertiary8_81llA$material3_release(long j) {
        this.tertiary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m1543getOnTertiary0d7_KjU() {
        return ((Color) this.onTertiary.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1572setOnTertiary8_81llA$material3_release(long j) {
        this.onTertiary.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1556getTertiaryContainer0d7_KjU() {
        return ((Color) this.tertiaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1585setTertiaryContainer8_81llA$material3_release(long j) {
        this.tertiaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1544getOnTertiaryContainer0d7_KjU() {
        return ((Color) this.onTertiaryContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1573setOnTertiaryContainer8_81llA$material3_release(long j) {
        this.onTertiaryContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1528getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).m3334unboximpl();
    }

    /* renamed from: setBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1557setBackground8_81llA$material3_release(long j) {
        this.background.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1534getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1563setOnBackground8_81llA$material3_release(long j) {
        this.onBackground.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1552getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).m3334unboximpl();
    }

    /* renamed from: setSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1581setSurface8_81llA$material3_release(long j) {
        this.surface.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1541getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1570setOnSurface8_81llA$material3_release(long j) {
        this.onSurface.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1554getSurfaceVariant0d7_KjU() {
        return ((Color) this.surfaceVariant.getValue()).m3334unboximpl();
    }

    /* renamed from: setSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1583setSurfaceVariant8_81llA$material3_release(long j) {
        this.surfaceVariant.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1542getOnSurfaceVariant0d7_KjU() {
        return ((Color) this.onSurfaceVariant.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1571setOnSurfaceVariant8_81llA$material3_release(long j) {
        this.onSurfaceVariant.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m1553getSurfaceTint0d7_KjU() {
        return ((Color) this.surfaceTint.getValue()).m3334unboximpl();
    }

    /* renamed from: setSurfaceTint-8_81llA$material3_release, reason: not valid java name */
    public final void m1582setSurfaceTint8_81llA$material3_release(long j) {
        this.surfaceTint.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m1533getInverseSurface0d7_KjU() {
        return ((Color) this.inverseSurface.getValue()).m3334unboximpl();
    }

    /* renamed from: setInverseSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1562setInverseSurface8_81llA$material3_release(long j) {
        this.inverseSurface.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1531getInverseOnSurface0d7_KjU() {
        return ((Color) this.inverseOnSurface.getValue()).m3334unboximpl();
    }

    /* renamed from: setInverseOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1560setInverseOnSurface8_81llA$material3_release(long j) {
        this.inverseOnSurface.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1529getError0d7_KjU() {
        return ((Color) this.error.getValue()).m3334unboximpl();
    }

    /* renamed from: setError-8_81llA$material3_release, reason: not valid java name */
    public final void m1558setError8_81llA$material3_release(long j) {
        this.error.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1535getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnError-8_81llA$material3_release, reason: not valid java name */
    public final void m1564setOnError8_81llA$material3_release(long j) {
        this.onError.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1530getErrorContainer0d7_KjU() {
        return ((Color) this.errorContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1559setErrorContainer8_81llA$material3_release(long j) {
        this.errorContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1536getOnErrorContainer0d7_KjU() {
        return ((Color) this.onErrorContainer.getValue()).m3334unboximpl();
    }

    /* renamed from: setOnErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1565setOnErrorContainer8_81llA$material3_release(long j) {
        this.onErrorContainer.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m1545getOutline0d7_KjU() {
        return ((Color) this.outline.getValue()).m3334unboximpl();
    }

    /* renamed from: setOutline-8_81llA$material3_release, reason: not valid java name */
    public final void m1574setOutline8_81llA$material3_release(long j) {
        this.outline.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m1546getOutlineVariant0d7_KjU() {
        return ((Color) this.outlineVariant.getValue()).m3334unboximpl();
    }

    /* renamed from: setOutlineVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1575setOutlineVariant8_81llA$material3_release(long j) {
        this.outlineVariant.setValue(Color.m3314boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m1549getScrim0d7_KjU() {
        return ((Color) this.scrim.getValue()).m3334unboximpl();
    }

    /* renamed from: setScrim-8_81llA$material3_release, reason: not valid java name */
    public final void m1578setScrim8_81llA$material3_release(long j) {
        this.scrim.setValue(Color.m3314boximpl(j));
    }

    /* renamed from: copy-G1PFc-w, reason: not valid java name */
    public final ColorScheme m1527copyG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.m3332toStringimpl(m1547getPrimary0d7_KjU())) + "onPrimary=" + ((Object) Color.m3332toStringimpl(m1537getOnPrimary0d7_KjU())) + "primaryContainer=" + ((Object) Color.m3332toStringimpl(m1548getPrimaryContainer0d7_KjU())) + "onPrimaryContainer=" + ((Object) Color.m3332toStringimpl(m1538getOnPrimaryContainer0d7_KjU())) + "inversePrimary=" + ((Object) Color.m3332toStringimpl(m1532getInversePrimary0d7_KjU())) + "secondary=" + ((Object) Color.m3332toStringimpl(m1550getSecondary0d7_KjU())) + "onSecondary=" + ((Object) Color.m3332toStringimpl(m1539getOnSecondary0d7_KjU())) + "secondaryContainer=" + ((Object) Color.m3332toStringimpl(m1551getSecondaryContainer0d7_KjU())) + "onSecondaryContainer=" + ((Object) Color.m3332toStringimpl(m1540getOnSecondaryContainer0d7_KjU())) + "tertiary=" + ((Object) Color.m3332toStringimpl(m1555getTertiary0d7_KjU())) + "onTertiary=" + ((Object) Color.m3332toStringimpl(m1543getOnTertiary0d7_KjU())) + "tertiaryContainer=" + ((Object) Color.m3332toStringimpl(m1556getTertiaryContainer0d7_KjU())) + "onTertiaryContainer=" + ((Object) Color.m3332toStringimpl(m1544getOnTertiaryContainer0d7_KjU())) + "background=" + ((Object) Color.m3332toStringimpl(m1528getBackground0d7_KjU())) + "onBackground=" + ((Object) Color.m3332toStringimpl(m1534getOnBackground0d7_KjU())) + "surface=" + ((Object) Color.m3332toStringimpl(m1552getSurface0d7_KjU())) + "onSurface=" + ((Object) Color.m3332toStringimpl(m1541getOnSurface0d7_KjU())) + "surfaceVariant=" + ((Object) Color.m3332toStringimpl(m1554getSurfaceVariant0d7_KjU())) + "onSurfaceVariant=" + ((Object) Color.m3332toStringimpl(m1542getOnSurfaceVariant0d7_KjU())) + "surfaceTint=" + ((Object) Color.m3332toStringimpl(m1553getSurfaceTint0d7_KjU())) + "inverseSurface=" + ((Object) Color.m3332toStringimpl(m1533getInverseSurface0d7_KjU())) + "inverseOnSurface=" + ((Object) Color.m3332toStringimpl(m1531getInverseOnSurface0d7_KjU())) + "error=" + ((Object) Color.m3332toStringimpl(m1529getError0d7_KjU())) + "onError=" + ((Object) Color.m3332toStringimpl(m1535getOnError0d7_KjU())) + "errorContainer=" + ((Object) Color.m3332toStringimpl(m1530getErrorContainer0d7_KjU())) + "onErrorContainer=" + ((Object) Color.m3332toStringimpl(m1536getOnErrorContainer0d7_KjU())) + "outline=" + ((Object) Color.m3332toStringimpl(m1545getOutline0d7_KjU())) + "outlineVariant=" + ((Object) Color.m3332toStringimpl(m1546getOutlineVariant0d7_KjU())) + "scrim=" + ((Object) Color.m3332toStringimpl(m1549getScrim0d7_KjU())) + ')';
    }
}