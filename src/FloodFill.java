import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int originalColor, int color) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == originalColor) {
            image[sr][sc] = color;
            fill(image, sr-1, sc, originalColor, color);
            fill(image, sr+1, sc, originalColor, color);
            fill(image, sr, sc-1, originalColor, color);
            fill(image, sr, sc+1, originalColor, color);
        }
    }
}
