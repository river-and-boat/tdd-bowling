import java.util.List;

public class GetScoresByType {
    public static Integer getStrikeScores(List<Integer> strikeIndex, Integer[][] scores) {
        Integer strikeSumTotal = 0;
        // 全中得分，除了求当前和，除第十次，还要加下一次两次的和
        for (Integer index : strikeIndex) {
            Integer nextIndex = index + 1;
            // 对于第十次全中特殊处理
            if (index < 9) {
                // 判断下一次是否依然是全中
                if (strikeIndex.contains(nextIndex)) {
                    strikeSumTotal += scores[index][0] + scores[index][1]
                            + scores[nextIndex][0] + scores[++nextIndex][0];
                } else {
                    strikeSumTotal += scores[index][0] + scores[index][1]
                            + scores[nextIndex][0] + scores[nextIndex][1];
                }
            } else if (index == 9) {
                // 第十次
                strikeSumTotal += scores[index][0] + scores[index][1]
                        + scores[nextIndex][0] + scores[nextIndex][1];
            }
        }
        return strikeSumTotal;
    }

    public static Integer getNormalScores(List<Integer> normalIndex, Integer[][] scores) {
        Integer normalSumTotal = 0;
        // 正常得分的，直接求和即可
        for (Integer index : normalIndex) {
            if (index < 9) {
                normalSumTotal += scores[index][0] + scores[index][1];
            } else if (index == 9){
                // 第十次
                normalSumTotal += scores[index][0] + scores[index][1];
            }
        }
        return normalSumTotal;
    }

    public static Integer getSpareScores(List<Integer> spareIndex, Integer[][] scores) {
        Integer spareSumTotal = 0;
        for (Integer index : spareIndex) {
            if(index < 10) {
                // 排除额外项
                spareSumTotal += scores[index][0] + scores[index][1] + scores[++index][0];
            }
        }
        return spareSumTotal;
    }
}
