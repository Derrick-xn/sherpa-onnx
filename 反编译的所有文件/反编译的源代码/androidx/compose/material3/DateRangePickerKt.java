package androidx.compose.material3;

import android.content.res.Resources;
import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0081\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\"\u001ad\u0010#\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010*\u001a.\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u000b\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002\u001aM\u00103\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0013H\u0002\u001a)\u0010>\u001a\u00020\n*\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "stateData", "Landroidx/compose/material3/StateData;", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "onDateSelected", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/StateData;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "rememberDateRangePickerState-pMw4iz8", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangePickerKt {
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m708PaddingValuesa9UjIt4$default(Dp.m5844constructorimpl(24), Dp.m5844constructorimpl(20), 0.0f, Dp.m5844constructorimpl(8), 4, null);
    private static final float HeaderHeightOffset = Dp.m5844constructorimpl(60);

    /* JADX WARN: Removed duplicated region for block: B:105:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DateRangePicker(final androidx.compose.material3.DateRangePickerState r56, androidx.compose.ui.Modifier r57, androidx.compose.material3.DatePickerFormatter r58, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, boolean r62, androidx.compose.material3.DatePickerColors r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt.DateRangePicker(androidx.compose.material3.DateRangePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: rememberDateRangePickerState-pMw4iz8, reason: not valid java name */
    public static final DateRangePickerState m1647rememberDateRangePickerStatepMw4iz8(Long l, Long l2, Long l3, IntRange intRange, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(501019096);
        ComposerKt.sourceInformation(composer, "C(rememberDateRangePickerState)P(3,2,1,4,0:c#material3.DisplayMode)164@7390L384:DateRangePicker.kt#uh7d8r");
        final Long l4 = (i3 & 1) != 0 ? null : l;
        final Long l5 = (i3 & 2) != 0 ? null : l2;
        final Long l6 = (i3 & 4) != 0 ? l4 : l3;
        final IntRange yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int iM1668getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.INSTANCE.m1668getPickerjFl4v0() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(501019096, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:157)");
        }
        DateRangePickerState dateRangePickerState = (DateRangePickerState) RememberSaveableKt.m2871rememberSaveable(new Object[0], (Saver) DateRangePickerState.INSTANCE.Saver(), (String) null, (Function0) new Function0<DateRangePickerState>() { // from class: androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DateRangePickerState invoke() {
                return new DateRangePickerState(l4, l5, l6, yearRange, iM1668getPickerjFl4v0, null);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dateRangePickerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchableDateEntryContent(final DateRangePickerState dateRangePickerState, final DatePickerFormatter datePickerFormatter, final Function1<? super Long, Boolean> function1, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(984055784);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchableDateEntryContent)P(3,1,2)455@19358L648:DateRangePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        final int i3 = i2;
        if ((i3 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(984055784, i3, -1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:447)");
            }
            int iM1650getDisplayModejFl4v0 = dateRangePickerState.m1650getDisplayModejFl4v0();
            CrossfadeKt.Crossfade(DisplayMode.m1660boximpl(iM1650getDisplayModejFl4v0), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.SwitchableDateEntryContent.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContainer(semantics, true);
                }
            }, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1354418636, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.SwitchableDateEntryContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode, Composer composer2, Integer num) throws Resources.NotFoundException {
                    m1649invokeQujVXRc(displayMode.getValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m1649invokeQujVXRc(int i4, Composer composer2, int i5) throws Resources.NotFoundException {
                    int i6;
                    ComposerKt.sourceInformation(composer2, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
                    if ((i5 & 14) == 0) {
                        i6 = (composer2.changed(i4) ? 4 : 2) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i6 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1354418636, i5, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:458)");
                        }
                        if (DisplayMode.m1663equalsimpl0(i4, DisplayMode.INSTANCE.m1668getPickerjFl4v0())) {
                            composer2.startReplaceableGroup(-1168754929);
                            ComposerKt.sourceInformation(composer2, "460@19572L208");
                            StateData stateData = dateRangePickerState.getStateData();
                            DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                            Function1<Long, Boolean> function12 = function1;
                            DatePickerColors datePickerColors2 = datePickerColors;
                            int i7 = i3;
                            DateRangePickerKt.DateRangePickerContent(stateData, datePickerFormatter2, function12, datePickerColors2, composer2, (i7 & 112) | (i7 & 896) | (i7 & 7168));
                            composer2.endReplaceableGroup();
                        } else if (DisplayMode.m1663equalsimpl0(i4, DisplayMode.INSTANCE.m1667getInputjFl4v0())) {
                            composer2.startReplaceableGroup(-1168754686);
                            ComposerKt.sourceInformation(composer2, "467@19815L175");
                            StateData stateData2 = dateRangePickerState.getStateData();
                            DatePickerFormatter datePickerFormatter3 = datePickerFormatter;
                            Function1<Long, Boolean> function13 = function1;
                            int i8 = i3;
                            DateRangeInputKt.DateRangeInputContent(stateData2, datePickerFormatter3, function13, composer2, (i8 & 896) | (i8 & 112));
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1168754501);
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.SwitchableDateEntryContent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                DateRangePickerKt.SwitchableDateEntryContent(dateRangePickerState, datePickerFormatter, function1, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateRangePickerContent(final StateData stateData, final DatePickerFormatter datePickerFormatter, final Function1<? super Long, Boolean> function1, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1003501610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerContent)P(3,1,2)485@20269L105,489@20401L82,492@20488L412:DateRangePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(stateData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003501610, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:478)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(stateData.getDisplayedMonthIndex(), 0, composerStartRestartGroup, 0, 2);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$onDateSelected$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        DateRangePickerKt.updateDateSelection(stateData, j);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Function1 function12 = (Function1) objRememberedValue;
            Modifier modifierM713paddingVpY3zN4$default = PaddingKt.m713paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM713paddingVpY3zN4$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2777constructorimpl = Updater.m2777constructorimpl(composerStartRestartGroup);
            Updater.m2784setimpl(composerM2777constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2784setimpl(composerM2777constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2784setimpl(composerM2777constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2784setimpl(composerM2777constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m2768boximpl(SkippableUpdater.m2769constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1265369378, "C493@20576L41,494@20626L268:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors, stateData.getCalendarModel(), composerStartRestartGroup, (i2 >> 9) & 14);
            int i3 = (i2 << 3) & 112;
            int i4 = i2 << 6;
            VerticalMonthsList(function12, stateData, lazyListStateRememberLazyListState, datePickerFormatter, function1, datePickerColors, composerStartRestartGroup, i3 | (i4 & 7168) | (57344 & i4) | (i4 & 458752));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePickerContent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                DateRangePickerKt.DateRangePickerContent(stateData, datePickerFormatter, function1, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalMonthsList(final Function1<? super Long, Unit> function1, final StateData stateData, final LazyListState lazyListState, final DatePickerFormatter datePickerFormatter, final Function1<? super Long, Boolean> function12, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-837198453);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalMonthsList)P(4,5,3,1,2)520@21434L168,527@21647L10,526@21607L2599,584@24241L62,584@24211L92:DateRangePicker.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(stateData) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 131072 : 65536;
        }
        final int i3 = i2;
        if ((374491 & i3) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-837198453, i3, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:511)");
            }
            final CalendarDate today = stateData.getCalendarModel().getToday();
            IntRange yearRange = stateData.getYearRange();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(yearRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = stateData.getCalendarModel().getMonth(stateData.getYearRange().getFirst(), 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final CalendarMonth calendarMonth = (CalendarMonth) objRememberedValue;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 56792252, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) throws Resources.NotFoundException {
                    ComposerKt.sourceInformation(composer2, "C531@21781L24,532@21847L59,533@21944L55,534@22008L2192:DateRangePicker.kt#uh7d8r");
                    if ((i4 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(56792252, i4, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:530)");
                        }
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        final String strM1959getStringNWtq28 = Strings_androidKt.m1959getStringNWtq28(Strings.INSTANCE.m1931getDateRangePickerScrollToShowPreviousMonthadMyvUU(), composer2, 6);
                        final String strM1959getStringNWtq282 = Strings_androidKt.m1959getStringNWtq28(Strings.INSTANCE.m1930getDateRangePickerScrollToShowNextMonthadMyvUU(), composer2, 6);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        LazyListState lazyListState2 = lazyListState;
                        final StateData stateData2 = stateData;
                        final CalendarMonth calendarMonth2 = calendarMonth;
                        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                        final DatePickerColors datePickerColors2 = datePickerColors;
                        final Function1<Long, Unit> function13 = function1;
                        final CalendarDate calendarDate = today;
                        final Function1<Long, Boolean> function14 = function12;
                        final int i5 = i3;
                        final LazyListState lazyListState3 = lazyListState;
                        LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState2, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int totalMonthsInRange = stateData2.getTotalMonthsInRange();
                                final StateData stateData3 = stateData2;
                                final CalendarMonth calendarMonth3 = calendarMonth2;
                                final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                final DatePickerColors datePickerColors3 = datePickerColors2;
                                final Function1<Long, Unit> function15 = function13;
                                final CalendarDate calendarDate2 = calendarDate;
                                final Function1<Long, Boolean> function16 = function14;
                                final int i6 = i5;
                                final LazyListState lazyListState4 = lazyListState3;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                final String str = strM1959getStringNWtq28;
                                final String str2 = strM1959getStringNWtq282;
                                LazyListScope.CC.items$default(LazyColumn, totalMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(1246706073, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int i7, Composer composer3, int i8) {
                                        int i9;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        ComposerKt.sourceInformation(composer3, "C548@22622L1554:DateRangePicker.kt#uh7d8r");
                                        if ((i8 & 14) == 0) {
                                            i9 = (composer3.changed(items) ? 4 : 2) | i8;
                                        } else {
                                            i9 = i8;
                                        }
                                        if ((i8 & 112) == 0) {
                                            i9 |= composer3.changed(i7) ? 32 : 16;
                                        }
                                        if ((i9 & 731) != 146 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1246706073, i8, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:542)");
                                            }
                                            CalendarMonth calendarMonthPlusMonths = stateData3.getCalendarModel().plusMonths(calendarMonth3, i7);
                                            Modifier modifierFillParentMaxWidth$default = LazyItemScope.CC.fillParentMaxWidth$default(items, Modifier.INSTANCE, 0.0f, 1, null);
                                            DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                            StateData stateData4 = stateData3;
                                            DatePickerColors datePickerColors4 = datePickerColors3;
                                            Function1<Long, Unit> function17 = function15;
                                            CalendarDate calendarDate3 = calendarDate2;
                                            Function1<Long, Boolean> function18 = function16;
                                            int i10 = i6;
                                            final LazyListState lazyListState5 = lazyListState4;
                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                            final String str3 = str;
                                            final String str4 = str2;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume = composer3.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            Density density = (Density) objConsume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composer3.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object objConsume3 = composer3.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillParentMaxWidth$default);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor);
                                            } else {
                                                composer3.useNode();
                                            }
                                            composer3.disableReusing();
                                            Composer composerM2777constructorimpl = Updater.m2777constructorimpl(composer3);
                                            Updater.m2784setimpl(composerM2777constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2784setimpl(composerM2777constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m2784setimpl(composerM2777constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m2784setimpl(composerM2777constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            composer3.enableReusing();
                                            function3MaterializerOf.invoke(SkippableUpdater.m2768boximpl(SkippableUpdater.m2769constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1680467237, "C555@22915L15,551@22731L992,570@23744L414:DateRangePicker.kt#uh7d8r");
                                            String monthYear$material3_release = datePickerFormatter4.formatMonthYear$material3_release(calendarMonthPlusMonths, stateData4.getCalendarModel(), CalendarModel_androidKt.defaultLocale(composer3, 0));
                                            if (monthYear$material3_release == null) {
                                                monthYear$material3_release = "-";
                                            }
                                            TextKt.m2047Text4IGK_g(monthYear$material3_release, SemanticsModifierKt.semantics$default(ClickableKt.m293clickableXHw0xAI$default(PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, null, null, new Function0<Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }
                                            }, 7, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                    SemanticsPropertiesKt.setCustomActions(semantics, DateRangePickerKt.customScrollActions(lazyListState5, coroutineScope3, str3, str4));
                                                }
                                            }, 1, null), datePickerColors4.getSubheadContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131064);
                                            int i11 = i10 << 3;
                                            int i12 = i10 << 6;
                                            DatePickerKt.Month(calendarMonthPlusMonths, function17, calendarDate3, stateData4, true, function18, datePickerFormatter4, datePickerColors4, composer3, ((i10 << 9) & 3670016) | (i11 & 458752) | (i11 & 112) | 24576 | (i12 & 7168) | (29360128 & i12));
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), 6, null);
                            }
                        }, composer2, (i3 >> 3) & 112, 252);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, 48);
            int i4 = (i3 >> 6) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(lazyListState) | composerStartRestartGroup.changed(stateData);
            DateRangePickerKt$VerticalMonthsList$2$1 dateRangePickerKt$VerticalMonthsList$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || dateRangePickerKt$VerticalMonthsList$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                dateRangePickerKt$VerticalMonthsList$2$1RememberedValue = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState, stateData, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerKt$VerticalMonthsList$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$VerticalMonthsList$2$1RememberedValue, composerStartRestartGroup, i4 | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i5) {
                DateRangePickerKt.VerticalMonthsList(function1, stateData, lazyListState, datePickerFormatter, function12, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(StateData stateData, long j) {
        CalendarDate canonicalDate = stateData.getCalendarModel().getCanonicalDate(j);
        CalendarDate value = stateData.getSelectedStartDate().getValue();
        CalendarDate value2 = stateData.getSelectedEndDate().getValue();
        if ((value == null && value2 == null) || ((value != null && value2 != null) || (value != null && canonicalDate.compareTo(value) < 0))) {
            stateData.getSelectedStartDate().setValue(canonicalDate);
            stateData.getSelectedEndDate().setValue(null);
        } else {
            if (value == null || canonicalDate.compareTo(value) < 0) {
                return;
            }
            stateData.getSelectedEndDate().setValue(canonicalDate);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m1646drawRangeBackgroundmxwnekA(ContentDrawScope drawRangeBackground, SelectedRangeInfo selectedRangeInfo, long j) {
        float fM3113getWidthimpl;
        Intrinsics.checkNotNullParameter(drawRangeBackground, "$this$drawRangeBackground");
        Intrinsics.checkNotNullParameter(selectedRangeInfo, "selectedRangeInfo");
        float f = drawRangeBackground.mo397toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f2 = drawRangeBackground.mo397toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f3 = drawRangeBackground.mo397toPx0680j_4(DatePickerModalTokens.INSTANCE.m2281getDateStateLayerHeightD9Ej5fM());
        float f4 = 2;
        float f5 = (f2 - f3) / f4;
        float f6 = 7;
        float fM3113getWidthimpl2 = (Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()) - (f6 * f)) / f6;
        long packedValue = selectedRangeInfo.getGridCoordinates().getFirst().getPackedValue();
        int iM5968component1impl = IntOffset.m5968component1impl(packedValue);
        int iM5969component2impl = IntOffset.m5969component2impl(packedValue);
        long packedValue2 = selectedRangeInfo.getGridCoordinates().getSecond().getPackedValue();
        int iM5968component1impl2 = IntOffset.m5968component1impl(packedValue2);
        int iM5969component2impl2 = IntOffset.m5969component2impl(packedValue2);
        float f7 = f + fM3113getWidthimpl2;
        float f8 = fM3113getWidthimpl2 / f4;
        float fM3113getWidthimpl3 = (iM5968component1impl * f7) + (selectedRangeInfo.getFirstIsSelectionStart() ? f / f4 : 0.0f) + f8;
        float f9 = (iM5969component2impl * f2) + f5;
        float f10 = iM5968component1impl2 * f7;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            f /= f4;
        }
        float fM3113getWidthimpl4 = f10 + f + f8;
        float f11 = (iM5969component2impl2 * f2) + f5;
        boolean z = drawRangeBackground.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            fM3113getWidthimpl3 = Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()) - fM3113getWidthimpl3;
            fM3113getWidthimpl4 = Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()) - fM3113getWidthimpl4;
        }
        ContentDrawScope contentDrawScope = drawRangeBackground;
        long jOffset = OffsetKt.Offset(fM3113getWidthimpl3, f9);
        if (iM5969component2impl == iM5969component2impl2) {
            fM3113getWidthimpl = fM3113getWidthimpl4 - fM3113getWidthimpl3;
        } else {
            fM3113getWidthimpl = z ? -fM3113getWidthimpl3 : Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()) - fM3113getWidthimpl3;
        }
        DrawScope.CC.m3891drawRectnJ9OG0$default(contentDrawScope, j, jOffset, SizeKt.Size(fM3113getWidthimpl, f3), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        if (iM5969component2impl != iM5969component2impl2) {
            for (int i = (iM5969component2impl2 - iM5969component2impl) - 1; i > 0; i--) {
                DrawScope.CC.m3891drawRectnJ9OG0$default(contentDrawScope, j, OffsetKt.Offset(0.0f, (i * f2) + f9), SizeKt.Size(Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()), f3), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            }
            long jOffset2 = OffsetKt.Offset(drawRangeBackground.getLayoutDirection() != LayoutDirection.Ltr ? Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc()) : 0.0f, f11);
            if (z) {
                fM3113getWidthimpl4 -= Size.m3113getWidthimpl(drawRangeBackground.mo3806getSizeNHjbRc());
            }
            DrawScope.CC.m3891drawRectnJ9OG0$default(contentDrawScope, j, jOffset2, SizeKt.Size(fM3113getWidthimpl4, f3), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState lazyListState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (lazyListState.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", f = "DateRangePicker.kt", i = {}, l = {774}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyListState lazyListState = this.$state;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() - 1, 0, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (lazyListState.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(lazyListState, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", f = "DateRangePicker.kt", i = {}, l = {784}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyListState lazyListState = this.$state;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + 1, 0, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        })});
    }

    static {
        float f = 64;
        float f2 = 12;
        DateRangePickerTitlePadding = PaddingKt.m708PaddingValuesa9UjIt4$default(Dp.m5844constructorimpl(f), 0.0f, Dp.m5844constructorimpl(f2), 0.0f, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m708PaddingValuesa9UjIt4$default(Dp.m5844constructorimpl(f), 0.0f, Dp.m5844constructorimpl(f2), Dp.m5844constructorimpl(f2), 2, null);
    }
}