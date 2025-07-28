package androidx.core.graphics;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.Person;
import android.app.job.JobWorkItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.os.LocaleList;
import android.telephony.SubscriptionManager;
import android.text.style.LocaleSpan;
import java.io.FileDescriptor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class ColorKt$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ Notification.MessagingStyle m(Object obj) {
        return (Notification.MessagingStyle) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ NotificationChannel m6115m(Object obj) {
        return (NotificationChannel) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ NotificationChannelGroup m6116m(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Person m6117m(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ JobWorkItem m(Intent intent) {
        return new JobWorkItem(intent);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ShortcutInfo.Builder m6120m(Context context, String str) {
        return new ShortcutInfo.Builder(context, str);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ShortcutInfo m6121m(Object obj) {
        return (ShortcutInfo) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ShortcutManager m6122m(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* synthetic */ Typeface.Builder m(FileDescriptor fileDescriptor) {
        return new Typeface.Builder(fileDescriptor);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Icon m6124m(Object obj) {
        return (Icon) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LocaleSpan m6127m(LocaleList localeList) {
        return new LocaleSpan(localeList);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m6129m() {
        return Notification.MessagingStyle.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m6133m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m6141m(Object obj) {
        return obj instanceof Icon;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return Notification.DecoratedCustomViewStyle.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m6146m$1() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return SubscriptionManager.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m6151m$2() {
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return ShortcutManager.class;
    }
}