import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 11:44
 * @Description ***
 **/
public class ScoresTool {
    public Integer calculates(Integer[][] scores) {
        Integer sum = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }
        }
        return sum;
    }
}
