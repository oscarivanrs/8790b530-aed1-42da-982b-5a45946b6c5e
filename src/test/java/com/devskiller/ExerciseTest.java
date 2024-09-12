package com.devskiller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseTest {

    @Test
    void shouldReturnListWithRepeatedValues() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(-1, 1, 3, 2, 5, 6, -1, 3, 6), 2);

        // then
        assertThat(result).containsExactlyInAnyOrder(-1, 3, 6);
    }

    @Test
    void nullValuesShouldBeOmitted() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(1, 1, null, 2, 5, 6, 1, 3, 6, null), 2);

        // then
        assertEquals(singletonList(6), result);
    }

}
