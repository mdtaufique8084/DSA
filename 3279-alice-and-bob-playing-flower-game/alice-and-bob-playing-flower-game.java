class Solution {
    public long flowerGame(int n, int m) {
        int odd_x = (n + 1) / 2;
        int even_x = n / 2;
        int odd_y = (m + 1) / 2;
        int even_y = m / 2;
        return (long) odd_x * even_y + (long) even_x * odd_y;
    }
}
