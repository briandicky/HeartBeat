package com.givemepass.FragmentTabs;

/**
 * This abstract class is used to process images.
 */
public abstract class ImageProcessing {
    /**
     * Given a byte array representing a yuv420sp image, determine the average
     * amount of red in the image. Note: returns 0 if the byte array is NULL.
     * 
     * @param yuv420sp
     *            Byte array representing a yuv420sp image
     * @param width
     *            Width of the image.
     * @param height
     *            Height of the image.
     * @return int representing the average amount of red in the image.
     */
 
    public static float RedAvg(byte[] yuv420sp, int width, int height) {
        if (yuv420sp == null) return 0;
 
        final int frameSize = width * height;
 
        int sum = 0;
        for (int j = 0, yp = 0; j < height; j++) {
            int uvp = frameSize + (j >> 1) * width, v = 0;
            for (int i = 0; i < width; i++, yp++) {
                int y = (0xff & yuv420sp[yp]) - 16;
                if (y < 0) y = 0;
                if ((i & 1) == 0) {
                    v = (0xff & yuv420sp[uvp++]) - 128;
                }
                int y1192 = 1192 * y;
                int r = (y1192 + 1634 * v);
 
                if (r < 0) r = 0;
                else if (r > 262143) r = 262143;
 
                int pixel = 0xff000000 | ((r << 6) & 0xff0000);
                int red = (pixel >> 16) & 0xff;
                sum += red;
            }
        }
        
        return (sum / frameSize);
    }
 
}