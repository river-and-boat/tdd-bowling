import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    private static ScoresTool scoresTool;

    @BeforeEach
    void init() {
        scoresTool = new ScoresTool();
    }

    @Test
    void test_all_scores_in_each_round_less_than_10() {
        // Given
        Integer[][] scores = {{1, 2}, {2, 2}, {3, 2}, {3, 3}, {2, 5}, {3, 5}, {6, 3}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 54;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_only_spare_in_first_9_rounds_with_no_continue() {
        // Given
        Integer[][] scores = {{1, 2}, {2, 2}, {3, 7}, {3, 3}, {2, 5}, {3, 5}, {6, 4}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 65;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_only_spare_in_first_9_rounds_with_continue() {
        // Given
        Integer[][] scores = {{1, 2}, {2, 2}, {3, 7}, {4, 6}, {5, 5}, {3, 5}, {6, 4}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 81;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_only_strike_in_first_9_rounds_with_no_continue() {
        // Given
        Integer[][] scores = {{1, 2}, {10, 0}, {3, 5}, {3, 3}, {10, 0}, {3, 5}, {6, 2}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 81;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_only_strike_in_first_9_rounds_with_continue() {
        // Given
        // 3+10+10+3+10+8+8+10+10+6+10+8+8+3+4+5
        Integer[][] scores = {{1, 2}, {10, 0}, {10, 0}, {3, 5}, {10, 0}, {10, 0}, {6, 2}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 116;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_both_strike_and_spare_in_first_9_rounds() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+5
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {3, 2}};
        Integer expected = 88;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_strike_in_the_10_round_with_addition_normal() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+9
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {10, 0}, {4, 5}};
        Integer expected = 102;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_spare_in_the_10_round_with_addition_normal() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+4
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {4, 6}, {1, 5}};
        Integer expected = 94;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_strike_in_the_10_round_with_addition_strike() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+10+0
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {10, 0}, {10, 0}};
        Integer expected = 103;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_strike_in_the_10_round_with_addition_spare() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+10+0
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {10, 0}, {4, 6}};
        Integer expected = 103;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_spare_in_the_10_round_with_addition_strike() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+10+0
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {4, 6}, {10, 0}};
        Integer expected = 103;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }

    @Test
    void test_spare_in_the_10_round_with_addition_spare() {
        // Given
        // 3+10+10+10+3+8+10+5+5+10+2+3+4+10+10+0
        // 此处最后的4和5为新加的一轮(补加两个球)
        Integer[][] scores = {{1, 2}, {10, 0}, {4, 6}, {3, 5}, {10, 0}, {3, 2}, {7, 3}, {2, 1}, {2, 2}, {4, 6}, {3, 7}};
        Integer expected = 96;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(expected, totalScores);
    }
}
