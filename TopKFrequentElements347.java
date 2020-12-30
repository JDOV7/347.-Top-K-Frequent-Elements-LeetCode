package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class TopKFrequentElements347 {

    public void TopKFrequentElements347() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Elements> lListElements = new ArrayList();
        Map<Integer, Integer> mListElements = new HashMap();
        int iArrResult[] = new int[k];
        Arrays.sort(nums);
        for (int num : nums) {
            if (mListElements.containsKey(num)) {
                mListElements.put(num, mListElements.get(num) + 1);
            } else {
                mListElements.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mListElements.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            lListElements.add(new Elements(key, value));
        }
        Collections.sort(lListElements);
        for (int i = 0; i < k; i++) {
            iArrResult[i] = lListElements.get(i).iValue;
        }
        //return iArrResult;
    }

    public class Elements implements Comparable<Elements> {

        int iValue;
        int iFrequent;

        public int getiValue() {
            return iValue;
        }

        public int getiFrequent() {
            return iFrequent;
        }

        public Elements(int iValue, int iFrequent) {
            this.iFrequent = iFrequent;
            this.iValue = iValue;
        }

        public int compareTo(Elements next) {
            if (next.getiFrequent() > getiFrequent()) {
                return 1;
            }
            if (next.getiFrequent() < getiFrequent()) {
                return -1;
            }
            return 0;
        }
    }
}
