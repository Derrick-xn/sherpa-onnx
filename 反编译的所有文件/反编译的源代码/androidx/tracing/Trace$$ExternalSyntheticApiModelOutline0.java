package androidx.tracing;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputContentInfo;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class Trace$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* bridge */ /* synthetic */ InputContentInfo m(Object obj) {
        return (InputContentInfo) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m6257m() {
        return BasicFileAttributes.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DirectoryStream m6259m(Object obj) {
        return (DirectoryStream) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ FileSystemException m6263m(Object obj) {
        return (FileSystemException) obj;
    }

    public static /* synthetic */ FileSystemException m(String str) {
        return new FileSystemException(str);
    }

    public static /* synthetic */ FileSystemException m(String str, String str2, String str3) {
        return new FileSystemException(str, str2, str3);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ FileSystemLoopException m6264m(String str) {
        return new FileSystemLoopException(str);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ FileVisitResult m6267m(Object obj) {
        return (FileVisitResult) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ FileVisitor m6268m(Object obj) {
        return (FileVisitor) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ NoSuchFileException m6270m(String str, String str2, String str3) {
        return new NoSuchFileException(str, str2, str3);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Path m6271m(Object obj) {
        return (Path) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SecureDirectoryStream m6274m(Object obj) {
        return (SecureDirectoryStream) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BasicFileAttributeView m6277m(Object obj) {
        return (BasicFileAttributeView) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BasicFileAttributes m6278m(Object obj) {
        return (BasicFileAttributes) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m6281m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m6283m(Object obj) {
        return obj instanceof SecureDirectoryStream;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m6290m$1() {
        return BasicFileAttributeView.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m6292m$1() {
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m6295m$2() {
    }
}