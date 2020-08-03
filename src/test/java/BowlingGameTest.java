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
        Integer excepted = 54;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(excepted, totalScores);
    }

    @Test
    void test_only_spare_in_first_9_rounds_with_no_continue() {
        // Given
        Integer[][] scores = {{1, 2}, {2, 2}, {3, 7}, {3, 3}, {2, 5}, {3, 5}, {6, 4}, {2, 1}, {2, 2}, {3, 2}};
        Integer excepted = 65;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(excepted, totalScores);
    }

    @Test
    void test_only_strike_in_first_9_rounds_with_no_continue() {
        // Given
        Integer[][] scores = {{1, 2}, {10, 0}, {3, 5}, {3, 3}, {10, 0}, {3, 5}, {6, 2}, {2, 1}, {2, 2}, {3, 2}};
        Integer excepted = 81;

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(excepted, totalScores);
    }
}
