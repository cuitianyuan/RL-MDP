package burlap.assignment4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GridWorldImage {

    int[][] map;
    int width;
    int height;
    int startX;
    int startY;
    int goalX;
    int goalY;

    public GridWorldImage(String filename) {
        gridWorldFromImage(filename);
    }

    public int[][] getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getGoalX() {
        return goalX;
    }

    public int getGoalY() {
        return goalY;
    }

    private void gridWorldFromImage(String filename) {
        try {
            BufferedImage image = ImageIO.read(new File(filename));
            width = image.getWidth();
            height = image.getHeight();
            map = new int[width][height];

            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int color = image.getRGB(x, y);
                    if (color == Color.BLACK.getRGB()) {
                        map[x][image.getHeight() - (y + 1)] = 1;
                    } else {
                        if (color == Color.BLUE.getRGB()) {
                            startX = x;
                            startY = image.getHeight() - (y + 1);
                        }
                        if (color == Color.GREEN.getRGB()) {
                            goalX = x;
                            goalY = image.getHeight() - (y + 1);
                        }
                        map[x][image.getHeight() - (y + 1)] = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
