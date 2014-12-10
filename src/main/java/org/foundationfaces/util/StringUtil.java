package org.foundationfaces.util;

/**
 *
 * @author Michael
 */
public final class StringUtil {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
