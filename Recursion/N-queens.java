import java.util.*;

class Solution {

    static boolean isSafe(int row, int col, ArrayList<Integer> current) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = current.get(prevRow) - 1;

            if (prevCol == col) {
                return false;
            }

            if (Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }

        return true;
    }

    static void solve(
        int row,
        int n,
        ArrayList<Integer> current,
        ArrayList<ArrayList<Integer>> ans
    ) {
        if (row == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, current)) {
                current.add(col + 1);
                solve(row + 1, n, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        solve(0, n, current, ans);

        return ans;
    }
}
