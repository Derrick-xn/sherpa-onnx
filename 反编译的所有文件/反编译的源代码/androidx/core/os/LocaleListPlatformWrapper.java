package androidx.core.os;

import android.os.LocaleList;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    LocaleListPlatformWrapper(Object obj) {
        this.mLocaleList = HalfKt$$ExternalSyntheticApiModelOutline0.m6185m(obj);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    public boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] strArr) {
        return this.mLocaleList.getFirstMatch(strArr);
    }
}