package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J%\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0016¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotation", "T", "", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "", "()[Ljava/lang/annotation/Annotation;", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {
    private final KTypeParameter typeParameter;

    public final <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        return null;
    }

    public TypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.typeParameter.getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.typeParameter));
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List<KType> upperBounds = this.typeParameter.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVMKt.computeJavaType((KType) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        return getName();
    }

    public boolean equals(Object other) {
        if (other instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) other;
            if (Intrinsics.areEqual(getName(), typeVariable.getName()) && Intrinsics.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }

    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }
}