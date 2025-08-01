package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

/* compiled from: AndroidTileMode.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTileMode_androidKt {

    /* compiled from: AndroidTileMode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            try {
                iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m3190isSupported0vamqd0(int i) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m3702equalsimpl0(i, TileMode.INSTANCE.m3707getDecal3opZhB0());
    }

    /* renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m3191toAndroidTileMode0vamqd0(int i) {
        if (TileMode.m3702equalsimpl0(i, TileMode.INSTANCE.m3706getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m3702equalsimpl0(i, TileMode.INSTANCE.m3709getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m3702equalsimpl0(i, TileMode.INSTANCE.m3708getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (TileMode.m3702equalsimpl0(i, TileMode.INSTANCE.m3707getDecal3opZhB0())) {
            if (Build.VERSION.SDK_INT >= 31) {
                return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
            }
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader.TileMode tileMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        if (i == 1) {
            return TileMode.INSTANCE.m3706getClamp3opZhB0();
        }
        if (i == 2) {
            return TileMode.INSTANCE.m3708getMirror3opZhB0();
        }
        if (i == 3) {
            return TileMode.INSTANCE.m3709getRepeated3opZhB0();
        }
        if (Build.VERSION.SDK_INT >= 31 && tileMode == Shader.TileMode.DECAL) {
            return TileModeVerificationHelper.INSTANCE.m3710getComposeTileModeDecal3opZhB0();
        }
        return TileMode.INSTANCE.m3706getClamp3opZhB0();
    }
}