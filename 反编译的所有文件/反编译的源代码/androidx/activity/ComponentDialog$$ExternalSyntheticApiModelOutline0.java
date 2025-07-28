package androidx.activity;

import android.graphics.RenderNode;
import android.os.LocaleList;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorBoundsInfo;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import java.util.Locale;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ RenderNode m(String str) {
        return new RenderNode(str);
    }

    public static /* synthetic */ LocaleList m(Locale[] localeArr) {
        return new LocaleList(localeArr);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimationControlListener m(Object obj) {
        return (WindowInsetsAnimationControlListener) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimationController m8m(Object obj) {
        return (WindowInsetsAnimationController) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DeleteGesture m9m(Object obj) {
        return (DeleteGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DeleteRangeGesture m10m(Object obj) {
        return (DeleteRangeGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ EditorBoundsInfo.Builder m11m() {
        return new EditorBoundsInfo.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ HandwritingGesture m12m(Object obj) {
        return (HandwritingGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ InsertGesture m13m(Object obj) {
        return (InsertGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ JoinOrSplitGesture m14m(Object obj) {
        return (JoinOrSplitGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ RemoveSpaceGesture m15m(Object obj) {
        return (RemoveSpaceGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SelectGesture m16m(Object obj) {
        return (SelectGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SelectRangeGesture m17m(Object obj) {
        return (SelectRangeGesture) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m18m() {
        return SelectGesture.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m29m(Object obj) {
        return obj instanceof RemoveSpaceGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return SelectRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof JoinOrSplitGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return DeleteRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$2(Object obj) {
        return obj instanceof DeleteGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return DeleteGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$3(Object obj) {
        return obj instanceof SelectGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return JoinOrSplitGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$4(Object obj) {
        return obj instanceof SelectRangeGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return InsertGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$5(Object obj) {
        return obj instanceof DeleteRangeGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$6() {
        return RemoveSpaceGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$6(Object obj) {
        return obj instanceof InsertGesture;
    }
}