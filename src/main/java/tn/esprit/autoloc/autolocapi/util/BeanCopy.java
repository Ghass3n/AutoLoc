package tn.esprit.autoloc.autolocapi.util;

import jakarta.persistence.Id;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public final class BeanCopy {

    private BeanCopy() {
    }

    /** Copie les attributs non null de source vers target, sans l'identifiant ni les collections. */
    public static void copyNonNull(Object source, Object target) {
        BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> ignored = new HashSet<>();
        for (Field field : target.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                ignored.add(field.getName());
            }
        }
        for (PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object value = src.isReadableProperty(pd.getName())
                    ? src.getPropertyValue(pd.getName()) : null;
            if (value == null || value instanceof Collection) {
                ignored.add(pd.getName());
            }
        }
        BeanUtils.copyProperties(source, target, ignored.toArray(new String[0]));
    }
}
