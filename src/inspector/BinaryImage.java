package inspector;

public class BinaryImage {
    private int[][] pixels;
    private int width;
    private int height;

    public static final int BACKGROUND = 0; 
    public static final int OBJECT = 1;   
      
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

    public int getRawPixel(int r, int c) {
        return pixels[r][c];
    }

    public void setRawPixel(int r, int c, int value) {
        pixels[r][c] = value;
    }

    public int getTotalHeight() { 
        return pixels.length; 
    }

    public int getTotalWidth() { 
        return pixels[0].length; 
    } 

    public boolean isInside(int r, int c) {
        return r >= 0 && r < pixels.length && c >= 0 && c < pixels[0].length;
    }
}