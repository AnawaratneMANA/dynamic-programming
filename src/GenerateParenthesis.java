import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private static void dfs(int n, int open, int close, StringBuilder cur, List<String> ans) {
        if (cur.length() == 2 * n) {
            ans.add(cur.toString());
            return;
        }
        if (open < n) {
            cur.append('(');
            dfs(n, open + 1, close, cur, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            dfs(n, open, close + 1, cur, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}