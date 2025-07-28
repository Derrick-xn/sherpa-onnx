package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

/* compiled from: ModifierLocalModifierNode.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    <T> T getCurrent(ModifierLocal<T> modifierLocal);

    ModifierLocalMap getProvidedValues();

    <T> void provide(ModifierLocal<T> key, T value);

    /* compiled from: ModifierLocalModifierNode.kt */
    /* renamed from: androidx.compose.ui.modifier.ModifierLocalModifierNode$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$provide(ModifierLocalModifierNode _this, ModifierLocal modifierLocal, Object obj) {
            if (!(_this.getProvidedValues() != EmptyMap.INSTANCE)) {
                InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
            }
            if (!_this.getProvidedValues().contains$ui_release(modifierLocal)) {
                InlineClassHelperKt.throwIllegalArgumentException("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + modifierLocal + " was not found.");
            }
            _this.getProvidedValues().mo4792set$ui_release(modifierLocal, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r3v9 */
        public static Object $default$getCurrent(ModifierLocalModifierNode modifierLocalModifierNode, ModifierLocal modifierLocal) {
            NodeChain nodes;
            if (!modifierLocalModifierNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("ModifierLocal accessed from an unattached node");
            }
            ModifierLocalModifierNode modifierLocalModifierNode2 = modifierLocalModifierNode;
            int iM4922constructorimpl = NodeKind.m4922constructorimpl(32);
            if (!modifierLocalModifierNode2.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent = modifierLocalModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(modifierLocalModifierNode2);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM4922constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM4922constructorimpl) != 0) {
                            DelegatingNode delegatingNodePop = parent;
                            MutableVector mutableVector = null;
                            while (delegatingNodePop != 0) {
                                if (delegatingNodePop instanceof ModifierLocalModifierNode) {
                                    ModifierLocalModifierNode modifierLocalModifierNode3 = (ModifierLocalModifierNode) delegatingNodePop;
                                    if (modifierLocalModifierNode3.getProvidedValues().contains$ui_release(modifierLocal)) {
                                        return modifierLocalModifierNode3.getProvidedValues().get$ui_release(modifierLocal);
                                    }
                                } else if ((delegatingNodePop.getKindSet() & iM4922constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = delegatingNodePop.getDelegate();
                                    int i = 0;
                                    delegatingNodePop = delegatingNodePop;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet() & iM4922constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                delegatingNodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNodePop);
                                                    }
                                                    delegatingNodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild();
                                        delegatingNodePop = delegatingNodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
            return modifierLocal.getDefaultFactory$ui_release().invoke();
        }
    }
}