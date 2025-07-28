package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m1181updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM5294getLengthimpl;
        int iM5296getMinimpl = TextRange.m5296getMinimpl(j);
        int iM5295getMaximpl = TextRange.m5295getMaximpl(j);
        if (TextRange.m5300intersects5zctL8(j2, j)) {
            if (TextRange.m5288contains5zctL8(j2, j)) {
                iM5296getMinimpl = TextRange.m5296getMinimpl(j2);
                iM5295getMaximpl = iM5296getMinimpl;
            } else {
                if (TextRange.m5288contains5zctL8(j, j2)) {
                    iM5294getLengthimpl = TextRange.m5294getLengthimpl(j2);
                } else if (TextRange.m5289containsimpl(j2, iM5296getMinimpl)) {
                    iM5296getMinimpl = TextRange.m5296getMinimpl(j2);
                    iM5294getLengthimpl = TextRange.m5294getLengthimpl(j2);
                } else {
                    iM5295getMaximpl = TextRange.m5296getMinimpl(j2);
                }
                iM5295getMaximpl -= iM5294getLengthimpl;
            }
        } else if (iM5295getMaximpl > TextRange.m5296getMinimpl(j2)) {
            iM5296getMinimpl -= TextRange.m5294getLengthimpl(j2);
            iM5294getLengthimpl = TextRange.m5294getLengthimpl(j2);
            iM5295getMaximpl -= iM5294getLengthimpl;
        }
        return TextRangeKt.TextRange(iM5296getMinimpl, iM5295getMaximpl);
    }
}