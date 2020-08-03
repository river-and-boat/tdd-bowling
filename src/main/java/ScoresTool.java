import java.util.ArrayList;
import java.util.List;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 11:44
 * @Description ***
 **/
public class ScoresTool {
    public Integer calculates(Integer[][] scores) {

        // 总分
        Integer sumTotal = 0;

        // 存储Spare的索引
        List<Integer> spareIndex = new ArrayList<>();

        // 存储Strike的索引
        List<Integer> strikeIndex = new ArrayList<>();

        // 存储正常得分的索引(不超过10)
        List<Integer> normalIndex = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] == 10) {
                // Strike
                strikeIndex.add(i);
            } else if (scores[i][0] + scores[i][1] == 10) {
                // Spare
                spareIndex.add(i);
            } else {
                // Normal
                normalIndex.add(i);
            }
        }

        return GetScoresByType.getNormalScores(normalIndex,scores) +
                GetScoresByType.getSpareScores(spareIndex,scores) +
                GetScoresByType.getStrikeScores(strikeIndex, scores);
    }
}
