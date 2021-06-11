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
     * @return ���ټ۸�
     */
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        // û��ʹ�ô������ʱ��������Ҫ������Ǯ
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }


        for (List<Integer> item : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                // ��������Ҫ�ĸ��� - ���������ĸ���
                int diff = clone.get(j) - item.get(j);
                if (diff < 0) {
                    // ��Ҫ�� < �����
                    break;
                }
                // ��Ҫ�Ĳ���Խ��Խ�٣�set ����˼����������
                clone.set(j, diff);
            }

            // ���ж����������Ժ�
            if (j == needs.size()) {
                res = Math.min(res, item.get(j) + dfs(price, special, clone));
            }
        }
        return res;
    }
}