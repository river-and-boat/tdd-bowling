import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 11:44
 * @Description ***
 **/
public class ScoresTool {
    public Integer calculates(Integer[][] scores) {

        // 存储数据
        Map<ScoresEnum, List<Integer>> maps = new HashMap<ScoresEnum, List<Integer>>() {
            {
                put(ScoresEnum.NormalScores, new ArrayList<>());
                put(ScoresEnum.SpareScores, new ArrayList<>());
                put(ScoresEnum.StrikeScores, new ArrayList<>());
            }
        };

        init(maps, scores);

        // 调用各自的函数
        return maps.entrySet().stream()
                .collect(Collectors.summingInt(entry -> entry.getKey().getScores(entry.getValue(), scores)));
    }

    private void init(Map<ScoresEnum, List<Integer>> maps, Integer[][] scores) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] == 10) {
                // Strike
                maps.get(ScoresEnum.StrikeScores).add(i);
            } else if (scores[i][0] + scores[i][1] == 10) {
                // Spare
                maps.get(ScoresEnum.SpareScores).add(i);
            } else {
                // Normal
                maps.get(ScoresEnum.NormalScores).add(i);
            }
        }
    }
}
