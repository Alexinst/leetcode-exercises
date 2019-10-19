/*
 * https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row/ 
 *
 * Reference: https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row/solution/lian-xu-chai-xiang-tong-de-shu-zi-by-leetcode/
 
在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）

我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。

返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。

如果无法做到，返回 -1.

	https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/03/08/domino.png

示例 1：
	输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
	输出：2
	解释：
	图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
	如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。

示例 2：
	输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
	输出：-1
	解释：
	在这种情况下，不可能旋转多米诺牌使一行的值相等。

提示：
    1. 1 <= A[i], B[i] <= 6
    2. 2 <= A.length == B.length <= 20000

----------------------------------------------------------------------------------------------------

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

	https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/03/08/domino.png

Example 1:
	Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
	Output: 2
	Explanation: 
	The first figure represents the dominoes as given by A and B: before we do any rotations.
	If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

	Example 2:

	Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
	Output: -1
	Explanation: 
	In this case, it is not possible to rotate the dominoes to make one row of values equal.

Note:
    1. 1 <= A[i], B[i] <= 6
    2. 2 <= A.length == B.length <= 20000
*/

class MySolution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length < 2) return 0;

        int min = check(A, B, A[0]);
        if (min != -1) return min;

        min = check(A, B, B[0]);
        if (min != -1) return min;

        return -1;
    }

    private int check(int[] A, int[] B, int n) {
        int minA = 0, minB = 0, i = 0;

        for (i = 0; i < A.length; i++) {
            if (A[i] != n && B[i] != n) return -1;
            if (A[i] != n) minA++;
            if (B[i] != n) minB++;
        }

        return Math.min(minA, minB);
    }
}
