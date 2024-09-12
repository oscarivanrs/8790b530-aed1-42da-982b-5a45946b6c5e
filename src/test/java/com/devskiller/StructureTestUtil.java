package com.devskiller;

import java.lang.reflect.Method;
import java.util.Base64;

import static java.util.stream.Stream.of;
import static org.junit.platform.commons.util.ReflectionUtils.tryToGetMethod;
import static org.junit.platform.commons.util.ReflectionUtils.tryToLoadClass;

public class StructureTestUtil {

    public static Class<?> loadClass(final String encodedClassName) {
        try {
            return tryToLoadClass(decode(encodedClassName)).get();
        } catch (Exception e) {
            return null;
        }
    }

    public static Method loadMethod(
            final String encodedClassName,
            final String encodedMethodName,
            final String... encodedParametersName) {
        try {
            return tryToGetMethod(
                    loadClass(encodedClassName),
                    decode(encodedMethodName),
                    of(encodedParametersName).map(StructureTestUtil::loadClass).toArray(Class[]::new))
                    .get();
        } catch (Exception e) {
            return null;
        }
    }

    public static String decode(final String encodedText) {
        return new String(Base64.getDecoder().decode(encodedText));
    }
}
