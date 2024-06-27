public class HighestPalindrome {

    public static String highestPalindrome(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[] changed = new boolean[n];

        // make string a palindrome
        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                arr[l] = arr[r] = (char) Math.max(arr[l], arr[r]);
                changed[l] = changed[r] = true;
                k--;
            }
            l++;
            r--;
        }

        // If more changes than allowed, return -1
        if (k < 0) return "-1";

        // maximize palindrome value
        l = 0;
        r = n - 1;
        while (l <= r) {
            if (l == r) {
                if (k > 0) arr[l] = '9';
            } else {
                if (arr[l] != '9') {
                    if (changed[l] || changed[r]) {
                        if (k > 0) {
                            arr[l] = arr[r] = '9';
                            k--;
                        }
                    } else {
                        if (k >= 2) {
                            arr[l] = arr[r] = '9';
                            k -= 2;
                        }
                    }
                }
            }
            l++;
            r--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        // Test
        System.out.println(highestPalindrome("3943", 1));
        System.out.println(highestPalindrome("932239", 2));
    }
}
