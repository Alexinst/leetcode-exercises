/*
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

以这种方式修改数组后，返回数组可能的最大和。

示例 1：
	输入：A = [4,2,3], K = 1
	输出：5
	解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。

示例 2：
	输入：A = [3,-1,0,2], K = 3
	输出：6
	解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。

示例 3：
	输入：A = [2,-3,-1,5,-4], K = 2
	输出：13
	解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 
提示：
1. 1 <= A.length <= 10000
2. 1 <= K <= 10000
3. -100 <= A[i] <= 100
*/

class MySolution {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A.length == 0) return 0;
        
        int sum = 0, len = A.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] *= -1;
                K--;
            }
            if (min > A[i]) min = A[i];

            sum += A[i];
        } 
        
        if (K % 2 == 1) 
            sum -= min * 2;
        
        return sum;
    }
}