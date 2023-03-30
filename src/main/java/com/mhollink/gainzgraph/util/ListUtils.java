package com.mhollink.gainzgraph.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ListUtils {

    public static <T> T getLast(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
    }
    
    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }
    public static <T> T getElement(List<T> list, int index) {
        if (isEmpty(list)) {
            return null;
        }
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }
}
