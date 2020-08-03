import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

        // 正常得分的，直接求和即可
        for (Integer index : normalIndex) {
            sumTotal += scores[index][0] + scores[index][1];
        }

        // 补中得分，除了求当前和，除第十次，还要加下一次的首次得分
        for (Integer index : spareIndex) {
            sumTotal += scores[index][0] + scores[index][1] + scores[++index][0];
        }

        // 全中得分，除了求当前和，除第十次，还要加下一次两次的和
        for (Integer index : strikeIndex) {
            Integer nextIndex = index + 1;
            // 判断下一次是否依然是全中
            if(strikeIndex.contains(nextIndex)) {
                sumTotal += scores[index][0] + scores[index][1]
                        + scores[nextIndex][0] + scores[++nextIndex][0];
            } else {
                sumTotal += scores[index][0] + scores[index][1]
                        + scores[nextIndex][0] + scores[nextIndex][1];
            }
        }
        return sumTotal;
    }
}
