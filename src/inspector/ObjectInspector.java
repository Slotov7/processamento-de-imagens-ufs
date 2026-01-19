package inspector;

import java.util.ArrayDeque;
import java.util.Deque;

public class ObjectInspector {

    private record Point(int row, int col) {}

    public InspectionResult inspect(BinaryImage image){
        floodFillBackground(image);

        int total = 0;
        int withHoles = 0;
        int withoutHoles = 0;

        for (int row = 0; row < image.getTotalHeight(); row++) {
            for (int col = 0; col < image.getTotalWidth(); col++) {
                if (image.getRawPixel(col, row) == BinaryImage.OBJECT) {
                    total++;

                    boolean hasHole = processObjectCheckingHoles(image, row, col);
                    if (hasHole){
                        withHoles++;
                    }else {
                        withoutHoles++;
                    }
                }
            }
        }
        return new InspectionResult(total, withHoles, withoutHoles);
    }

    private void floodFillBackground(BinaryImage image){
        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(0, 0));

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        while(!stack.isEmpty()){
            Point p = stack.pop();

            if (!image.isInside(p.row, p.col)){
                continue;
            }
            if (image.getRawPixel(p.row, p.col) == BinaryImage.BACKGROUND){
                image.setRawPixel(p.row, p.col, 2);

                for (int i = 0; i < 4; i++) {
                    stack.push(new Point(p.row + drow[i], p.col + dcol[i]));
                }
            }
        }
    }

    private boolean processObjectCheckingHoles(BinaryImage image, int startRow, int startCol){
        boolean foundhole = false;

        Deque<Point> stack = new ArrayDeque<>();

        stack.push(new Point(startRow, startCol));

        int[] drow = {-1, 1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[] checkDRow = {-1, 1,0,0};
        int[] checkDCol = {0, 0,-1,1};

        while (!stack.isEmpty()){
            Point p = stack.pop();

            if (!image.isInside(p.row, p.col)){
                continue;
            }
            if (image.getRawPixel(p.row, p.col) == BinaryImage.OBJECT){
                continue;
            }
            image.setRawPixel(p.row, p.col, 3);

            if (!foundhole){
                for (int i = 0; i < 4; i++) {
                    int nrow = p.row + checkDRow[i];
                    int ncol = p.col + checkDCol[i];

                    if (image.isInside(nrow, ncol) && image.getRawPixel(nrow, ncol) == BinaryImage.BACKGROUND){
                        foundhole = true;
                    }
                }
            }
        }
        return foundhole;
    }
}


