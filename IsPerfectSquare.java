public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            } else if (sq < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare solution = new IsPerfectSquare();

        int num1 = 16;
        int num2 = 14;
        int num3 = 1;
        int num4 = 808201; // 899^2

        System.out.println(num1 + " is perfect square? " + solution.isPerfectSquare(num1)); // true
        System.out.println(num2 + " is perfect square? " + solution.isPerfectSquare(num2)); // false
        System.out.println(num3 + " is perfect square? " + solution.isPerfectSquare(num3)); // true
        System.out.println(num4 + " is perfect square? " + solution.isPerfectSquare(num4)); // true
    }
}
