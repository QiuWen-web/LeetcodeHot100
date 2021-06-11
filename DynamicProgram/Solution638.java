package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class Solution638 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class DynamicSolution638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    /**
     * @param price
     * @param special
     * @param needs
     * @return 最少价格
     */
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        // 没有使用大礼包的时候，我们须要花多少钱
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }


        for (List<Integer> item : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                // 用我们须要的个数 - 大礼包里面的个数
                int diff = clone.get(j) - item.get(j);
                if (diff < 0) {
                    // 须要的 < 大礼包
                    break;
                }
                // 须要的部分越来越少，set 的意思是在做减法
                clone.set(j, diff);
            }

            // 所有都考虑完了以后
            if (j == needs.size()) {
                res = Math.min(res, item.get(j) + dfs(price, special, clone));
            }
        }
        return res;
    }
}