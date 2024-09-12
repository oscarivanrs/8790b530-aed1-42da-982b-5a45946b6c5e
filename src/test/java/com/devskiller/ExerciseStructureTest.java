package com.devskiller;

import com.fasterxml.jackson.core.type.TypeReference;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static com.devskiller.StructureTestUtil.loadClass;
import static com.devskiller.StructureTestUtil.loadMethod;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class ExerciseStructureTest {

    private static final String EXERCISE_CLASS_ENCODED_NAME = "Y29tLmRldnNraWxsZXIuRXhlcmNpc2U=";
    private static final String FIND_DUPLICATES_METHOD_ENCODED_NAME = "ZmluZER1cGxpY2F0ZXM=";
    private static final String LIST_CLASS_ENCODED_NAME = "amF2YS51dGlsLkxpc3Q=";
    private static final String INT_CLASS_ENCODED_NAME = "aW50";
    private static final IntListTypeReference INT_LIST_TYPE_REFERENCE = new IntListTypeReference();

    @Test
    @Order(1)
    @DisplayName("should be named `Exercise` and be placed under `com.devskiller` package")
    void exerciseClass() {

        final Class<?> expectedClass = loadClass(EXERCISE_CLASS_ENCODED_NAME);

        assertThat(expectedClass)
                .isNotNull()
                .isPublic();
    }

    @Test
    @Order(2)
    @DisplayName("should have `findDuplicates` method with two parameters")
    void findDuplicatesMethod() {

        final Method expectedMethod = loadMethod(
                EXERCISE_CLASS_ENCODED_NAME,
                FIND_DUPLICATES_METHOD_ENCODED_NAME,
                LIST_CLASS_ENCODED_NAME,
                INT_CLASS_ENCODED_NAME
        );

        assertAll(
                () -> assertThat(expectedMethod).isNotNull(),
                () -> Assertions.assertThat(expectedMethod.getGenericReturnType()).isEqualTo(INT_LIST_TYPE_REFERENCE.getType()),
                () -> Assertions.assertThat(expectedMethod.getModifiers()).satisfies(
                        modifier -> {
                            Assertions.assertThat(Modifier.isStatic(modifier)).isFalse();
                            Assertions.assertThat(modifier).isEqualTo(Modifier.PUBLIC);
                        }
                ),
                () -> assertThat(expectedMethod.getGenericParameterTypes()[0]).isEqualTo(INT_LIST_TYPE_REFERENCE.getType())
        );
    }

    private static class IntListTypeReference extends TypeReference<List<Integer>> {

    }
}
