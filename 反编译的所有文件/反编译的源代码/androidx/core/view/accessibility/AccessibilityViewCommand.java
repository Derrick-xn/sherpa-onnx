package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes2.dex */
public interface AccessibilityViewCommand {
    boolean perform(View view, CommandArguments commandArguments);

    public static abstract class CommandArguments {
        Bundle mBundle;

        public void setBundle(Bundle bundle) {
            this.mBundle = bundle;
        }
    }

    public static final class MoveAtGranularityArguments extends CommandArguments {
        public int getGranularity() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        }

        public boolean getExtendSelection() {
            return this.mBundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        }
    }

    public static final class MoveHtmlArguments extends CommandArguments {
        public String getHTMLElement() {
            return this.mBundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_HTML_ELEMENT_STRING);
        }
    }

    public static final class SetSelectionArguments extends CommandArguments {
        public int getStart() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT);
        }

        public int getEnd() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT);
        }
    }

    public static final class SetTextArguments extends CommandArguments {
        public CharSequence getText() {
            return this.mBundle.getCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
        }
    }

    public static final class ScrollToPositionArguments extends CommandArguments {
        public int getRow() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_ROW_INT);
        }

        public int getColumn() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_COLUMN_INT);
        }
    }

    public static final class SetProgressArguments extends CommandArguments {
        public float getProgress() {
            return this.mBundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
        }
    }

    public static final class MoveWindowArguments extends CommandArguments {
        public int getX() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVE_WINDOW_X);
        }

        public int getY() {
            return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVE_WINDOW_Y);
        }
    }
}