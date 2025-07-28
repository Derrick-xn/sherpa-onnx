package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aó\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0018\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0019\u001a»\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00100\u001f2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010$\u001a\u0098\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010&\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u00112\u001f\b\u0002\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010'\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010%2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010(\u001a¿\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00100\u001f2$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112$\b\u0002\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00130\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112(\b\u0002\u0010\u0016\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u0004\u0018\u00010\u000f*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u000f*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u0010/\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010\u0017*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u00061²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u008a\u0084\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e03X\u008a\u0084\u0002"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ExtensionFunctionType;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "builder", "Landroidx/navigation/NavGraphBuilder;", "(Landroidx/navigation/NavHostController;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "navigation-compose_release", "currentBackStack", "", NotificationCompat.CATEGORY_PROGRESS, "", "inPredictiveBack", "", "allVisibleEntries", "visibleEntries"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavHostKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r20, final java.lang.String r21, androidx.compose.ui.Modifier r22, java.lang.String r23, final kotlin.jvm.functions.Function1 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r26, final java.lang.String r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.Alignment r29, java.lang.String r30, kotlin.jvm.functions.Function1 r31, kotlin.jvm.functions.Function1 r32, kotlin.jvm.functions.Function1 r33, kotlin.jvm.functions.Function1 r34, final kotlin.jvm.functions.Function1 r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavHost(final androidx.navigation.NavHostController r27, final java.lang.String r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.Alignment r30, java.lang.String r31, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r32, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r33, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r34, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r36, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavHost(final androidx.navigation.NavHostController r30, final kotlin.reflect.KClass<?> r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.Alignment r33, kotlin.reflect.KClass<?> r34, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r37, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r38, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r39, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r40, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, kotlin.reflect.KClass, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavHost(final androidx.navigation.NavHostController r30, final java.lang.Object r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.Alignment r33, kotlin.reflect.KClass<?> r34, java.util.Map<kotlin.reflect.KType, androidx.navigation.NavType<?>> r35, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r37, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r38, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r39, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r40, final kotlin.jvm.functions.Function1<? super androidx.navigation.NavGraphBuilder, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, java.lang.Object, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.reflect.KClass, java.util.Map, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r18, final androidx.navigation.NavGraph r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void NavHost(final androidx.navigation.NavHostController r23, final androidx.navigation.NavGraph r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.Alignment r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.jvm.functions.Function1 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:292:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavHost(final androidx.navigation.NavHostController r33, final androidx.navigation.NavGraph r34, androidx.compose.ui.Modifier r35, androidx.compose.ui.Alignment r36, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r37, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r38, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.EnterTransition> r39, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.ExitTransition> r40, kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentTransitionScope<androidx.navigation.NavBackStackEntry>, androidx.compose.animation.SizeTransform> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 1685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavHost$lambda$8(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NavHost$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavHost$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        }
        return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$6(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$15(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$17(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }
}