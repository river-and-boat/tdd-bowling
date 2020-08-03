import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    @Test
    void test_all_scores_in_each_round_less_than_10() {
        // Given
        Integer[][] scores = {{1, 2}, {2, 2}, {3, 2}, {3, 3}, {2, 5}, {3, 5}, {6, 3}, {2, 1}, {2, 2}, {3, 2}};
        Integer excepted = 54;
        ScoresTool scoresTool = new ScoresTool();

        // When
        Integer totalScores = scoresTool.calculates(scores);

        // Then
        assertEquals(excepted, totalScores);
    }
}
