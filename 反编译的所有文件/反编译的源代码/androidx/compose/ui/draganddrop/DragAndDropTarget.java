package androidx.compose.ui.draganddrop;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: DragAndDrop.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "onChanged", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onDrop", "", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DragAndDropTarget {

    /* compiled from: DragAndDrop.kt */
    /* renamed from: androidx.compose.ui.draganddrop.DragAndDropTarget$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onChanged(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }

        public static void $default$onEnded(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }

        public static void $default$onEntered(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }

        public static void $default$onExited(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }

        public static void $default$onMoved(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }

        public static void $default$onStarted(DragAndDropTarget _this, DragAndDropEvent dragAndDropEvent) {
        }
    }

    void onChanged(DragAndDropEvent event);

    boolean onDrop(DragAndDropEvent event);

    void onEnded(DragAndDropEvent event);

    void onEntered(DragAndDropEvent event);

    void onExited(DragAndDropEvent event);

    void onMoved(DragAndDropEvent event);

    void onStarted(DragAndDropEvent event);
}