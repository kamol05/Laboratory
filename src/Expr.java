public class Expr {

    static class TreeNode {
        final String token;
        TreeNode left;
        TreeNode right;

        public TreeNode(String token) {
            this.token = token;
        }
    }

    static int getPrio(char op) {
        switch (op) {
            case '+':
//            case '1':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static boolean isOperator(String token) {
        return token.length() == 1 && getPrio(token.charAt(0)) != -1;
    }

    static boolean isNumber(String token) {
        if (token.charAt(0) == '-')
            token = token.substring(1);

        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) < '0' || token.charAt(i) > '9')
                return false;
        }

        return !token.isEmpty();
    }

    static TreeNode buildTree(String[] tokens, int start, int end) {
        int elem = -1;
        int folding = 0;
        int minprio = -1, minfolding = -1;

        // find element with min priority
        for (int i = start; i < end; i++) {
            String tok = tokens[i];

            if ("(".equals(tok))
                folding++;
            else if (")".equals(tok))
                folding--;
            else if (isOperator(tok)) {
                int prio = getPrio(tok.charAt(0));
                if (elem == -1 || folding < minfolding || (folding == minfolding && prio <= minprio)) {
                    minfolding = folding;
                    minprio = prio;
                    elem = i;
                }
            }
        }

        if (elem == -1) {
            /// что конкретно это за случай? когда токеном должна быть цифра без соседей
            for (int i = start; i <= end; i++)
                if (isNumber(tokens[i])) {
                    return new TreeNode(tokens[i]);
                }

            return null;
        }

        TreeNode node = new TreeNode(tokens[elem]);
        node.left = buildTree(tokens, start, elem - 1);
        node.right = buildTree(tokens, elem + 1, end);
        return node;
    }

    static int applyOperation(char op, int left, int right) {
        switch (op) {
            case '+':
                return left + right;
            case '-':// WRITE MISSING CODE HERE
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '%':
                return left % right;//here
            case '^':
                return (int) (Math.pow(left, right));
            default:
                return 0;
        }
    }

    static int calcTree(TreeNode root) { // Written by Me
        int result = 0;
        String op = root.token;
        int left = 0;
        int right = 0;

        if (isOperator(root.left.token)){
            left = calcTree(root.left);
        } else { left = Integer.parseInt(root.left.token); }

        if (isOperator(root.right.token)){
            right = calcTree(root.right);
        } else { right = Integer.parseInt(root.right.token); }

        result += applyOperation( op.charAt(0), left, right);
        return  result;
    }


    public static void main(String... args) {
//        args = "( 3 + 2 ) * 4 + 15 + 15 + ( 2 * 5 ) + 10".split(" ");  //70
//        args = "2 * 2 ^ 2 + 2 + 2 + 3 ^ 3".split(" ");   // 39

        args = "6 * 6 / 2 + 2 - 2".split(" "); //18
//        args = "2 + 8 * 2".split(" ");

        if (args.length < 1) {
            System.err.println("Please provide arithmetic expression");
            System.exit(64);
        }
        TreeNode root = buildTree(args, 0, args.length - 1);
        if (root != null) {
//            calcTree(root);
            System.out.println(calcTree(root));
        }
    }
}
