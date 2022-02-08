/** Reverse Only Letters **/
class Solution {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(new Solution().reverseOnlyLetters(s));
    }
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0,j = chars.length -1; i < chars.length; i++,j--) {
            if ( Character.toString(chars[i]).matches("[a-zA-Z]") ){
                for ( ; j > -1; j--) {
                    if ( Character.toString(chars[j]).matches("[a-zA-Z]") ){
                        sb.append(chars[j]);
                        break;
                    }
                }
            }
            else {
                sb.append(chars[i]);
                j++;
            }
        }
        return sb.toString();
    }
}

/* Must Be...
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
Output: "Qedo1ct-eeLg=ntse-T!"

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.

* */