package inspector;

public class BinaryImage {
    private int[][] pixels;
    private int width;
    private int height;

    public static final int BACKGROUND = 0;
    public static final int OBJECT = 1;
    public static final int EXT_BACKGROUND = 2;
    public static final int VISITED = 3;

    public BinaryImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[height + 2][width + 2];
    }

    public int getPixel(int row, int col) {
        return pixels[row + 1][col + 1];
    }

    public void setPixel(int row, int col, int value) {
        pixels[row + 1][col + 1] = value;
    }

    public int getRawPixel(int row, int col) {
        return pixels[row][col];
    }

    public void setRawPixel(int row, int col, int value) {
        pixels[row][col] = value;
    }

    public int getTotalHeight() {
        return pixels.length;
    }

    public int getTotalWidth() {
        return pixels[0].length;
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < pixels.length && col >= 0 && col < pixels[0].length;
    }
}