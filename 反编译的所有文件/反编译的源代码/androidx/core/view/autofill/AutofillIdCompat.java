package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;

/* loaded from: classes2.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(AutofillId autofillId) {
        this.mWrappedObj = autofillId;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    public AutofillId toAutofillId() {
        return Paint29$$ExternalSyntheticApiModelOutline0.m5350m(this.mWrappedObj);
    }
}