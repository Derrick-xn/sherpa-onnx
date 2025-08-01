package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* compiled from: RichTooltipTokens.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u0011\u0010\"\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0011\u0010$\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/tokens/RichTooltipTokens;", "", "()V", "ActionFocusLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActionFocusLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActionHoverLabelTextColor", "getActionHoverLabelTextColor", "ActionLabelTextColor", "getActionLabelTextColor", "ActionLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getActionLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ActionPressedLabelTextColor", "getActionPressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerSurfaceTintLayerColor", "getContainerSurfaceTintLayerColor", "SubheadColor", "getSubheadColor", "SubheadFont", "getSubheadFont", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "getSupportingTextFont", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RichTooltipTokens {
    public static final RichTooltipTokens INSTANCE = new RichTooltipTokens();
    private static final ColorSchemeKeyTokens ActionFocusLabelTextColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens ActionHoverLabelTextColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens ActionLabelTextColor = ColorSchemeKeyTokens.Primary;
    private static final TypographyKeyTokens ActionLabelTextFont = TypographyKeyTokens.LabelLarge;
    private static final ColorSchemeKeyTokens ActionPressedLabelTextColor = ColorSchemeKeyTokens.Primary;
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float ContainerElevation = ElevationTokens.INSTANCE.m2312getLevel2D9Ej5fM();
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerMedium;
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
    private static final ColorSchemeKeyTokens SubheadColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final TypographyKeyTokens SubheadFont = TypographyKeyTokens.TitleSmall;
    private static final ColorSchemeKeyTokens SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final TypographyKeyTokens SupportingTextFont = TypographyKeyTokens.BodyMedium;

    private RichTooltipTokens() {
    }

    public final ColorSchemeKeyTokens getActionFocusLabelTextColor() {
        return ActionFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionHoverLabelTextColor() {
        return ActionHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActionLabelTextColor() {
        return ActionLabelTextColor;
    }

    public final TypographyKeyTokens getActionLabelTextFont() {
        return ActionLabelTextFont;
    }

    public final ColorSchemeKeyTokens getActionPressedLabelTextColor() {
        return ActionPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2595getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return ContainerSurfaceTintLayerColor;
    }

    public final ColorSchemeKeyTokens getSubheadColor() {
        return SubheadColor;
    }

    public final TypographyKeyTokens getSubheadFont() {
        return SubheadFont;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return SupportingTextFont;
    }
}