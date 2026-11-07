/**
 * Solution for Assignment 2 - Introduction to Computer Science.
 * Image Processing Utilities: Grayscale conversion, cropping, rotation, smoothing, and scaling.
 * 
 * Note: All given 3D arrays (img) represent an RGB image where:
 * img[0] - Red channel, img[1] - Green channel, img[2] - Blue channel.
 */
public class Ex2 {

	public static void main(String[] args) {
		int[][][] cat = MyImageIO.readImageFromFile("cat.jpg");
		int[][][] butterfly = MyImageIO.readImageFromFile("butterfly.jpg");
		
		// 1. RGB to Grayscale
		int[][] catGray = rgb2gray(cat);
		MyImageIO.writeImageToFile("catGray.jpg", catGray);
		
		int[][] butterflyGray = rgb2gray(butterfly);
		MyImageIO.writeImageToFile("butterflyGray.jpg", butterflyGray);
		
		// 2. Crop Image
		int[][][] catCrop = crop(cat, 200, 300, 600, 1000);
		MyImageIO.writeImageToFile("catCrop.jpg", catCrop);
		
		int[][][] butterflyCrop = crop(butterfly, 1000, 1200, 2300, 3000);
		MyImageIO.writeImageToFile("butterflyCrop.jpg", butterflyCrop);
		
		// 3. Smooth (Blur) Image
		int[][][] catSmooth = smooth(cat, 3);
		MyImageIO.writeImageToFile("catSmooth.jpg", catSmooth);
		
		int[][][] butterflySmooth = smooth(butterfly, 3);
		MyImageIO.writeImageToFile("butterflySmooth.jpg", butterflySmooth);
		
		// 4. Rotate Image
		int[][][] catRotated = rotate_alpha(cat, 90);
		MyImageIO.writeImageToFile("catRotated.jpg", catRotated);
		
		int[][][] butterflyRotated = rotate_alpha(butterfly, 150);
		MyImageIO.writeImageToFile("butterflyRotated.jpg", butterflyRotated);
		
		// 5. Scale Image
		int[][] catRes = scaleImg(2.0, 3.0, catGray);
		MyImageIO.writeImageToFile("catRes.jpg", catRes);

		int[][] butterflyRes = scaleImg(2.0, 3.0, butterflyGray);
		MyImageIO.writeImageToFile("butterflyRes.jpg", butterflyRes);
	}

	/**
	 * Converts an RGB image to a grayscale image using luminance weights.
	 * 
	 * @param img - a 3D array representing an RGB image.
	 * @return a grayscale image of (img) as a 2D array.
	 */
	public static int[][] rgb2gray(int[][][] img) {
		int height = img[0].length;
		int width = img[0][0].length;
		int[][] gray = new int[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				gray[i][j] = (int) (0.3 * img[0][i][j] + 0.59 * img[1][i][j] + 0.11 * img[2][i][j]) * 255;
			}
		}
		return gray;
	}

	/**
	 * Crops a rectangular region from an RGB image.
	 * 
	 * @param img - an RGB image.
	 * @param i_1, j_1 - indices of the upper-left pixel of the crop range.
	 * @param i_2, j_2 - indices of the lower-right pixel of the crop range.
	 * @return a cropped RGB image from pixel (i_1, j_1) to pixel (i_2, j_2) as a 3D array.
	 */
	public static int[][][] crop(int[][][] img, int i_1, int j_1, int i_2, int j_2) {
		int cropHeight = i_2 - i_1 + 1;
		int cropWidth = j_2 - j_1 + 1;
		int[][][] cropped = new int[3][cropHeight][cropWidth];
		
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < cropHeight; i++) {
				for (int j = 0; j < cropWidth; j++) {
					cropped[k][i][j] = img[k][i + i_1][j + j_1];
				}
			}
		}
		return cropped;
	}

	/**
	 * Rotates an RGB image around its center by a given angle in degrees.
	 * 
	 * @param img - an RGB image.
	 * @param alpha - the rotation angle in degrees.
	 * @return a rotated RGB image by alpha degrees.
	 */
	public static int[][][] rotate_alpha(int[][][] img, double alpha) {
		int height = img[0].length;
		int width = img[0][0].length;
		int[][][] rotated = new int[3][height][width];
		
		int i0 = height / 2;
		int j0 = width / 2;
		double radians = Math.toRadians(alpha);
		double cosA = Math.cos(radians);
		double sinA = Math.sin(radians);
		
		for (int k = 0; k < 3; k++) {
			for (int i1 = 0; i1 < height; i1++) {
				for (int j1 = 0; j1 < width; j1++) {
					int i = (int) (cosA * (i1 - i0) - sinA * (j1 - j0)) + i0;
					int j = (int) (sinA * (i1 - i0) + cosA * (j1 - j0)) + j0;
					
					if (i >= 0 && j >= 0 && i < height && j < width) {
						rotated[k][i][j] = img[k][i1][j1];
					}
				}
			}
		}		
		return rotated;
	}

	/**
	 * Smooths (blurs) an RGB image using a sliding box-filter window of size (2n+1)x(2n+1).
	 * 
	 * @param img - an RGB image.
	 * @param n - the radius of the sliding window around each pixel.
	 * @return a smoothed RGB image.
	 */
	public static int[][][] smooth(int[][][] img, int n) {
		int height = img[0].length;
		int width = img[0][0].length;
		int[][][] smoothed = new int[3][height][width];
		
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					double sum = 0;
					int count = 0;
					
					for (int z = i - n; z <= i + n; z++) {
						for (int w = j - n; w <= j + n; w++) {
							if (z >= 0 && w >= 0 && z < height && w < width) {
								sum += img[k][z][w];
								count++;
							}
						}
					}
					smoothed[k][i][j] = (int) (sum / count);
				}
			}
		}
		return smoothed;
	}

	/**
	 * Scales a grayscale image up or down by the given height and width factors.
	 * 
	 * @param factor_h - height scale factor.
	 * @param factor_w - width scale factor.
	 * @param im - a 2D grayscale image to be scaled.
	 * @return a scaled grayscale image.
	 */
	public static int[][] scaleImg(double factor_h, double factor_w, int[][] im) {		
		int h = (int) (im.length * factor_h);
		int w = (int) (im[0].length * factor_w);
		int[][] res = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				res[i][j] = im[(int) (i / factor_h)][(int) (j / factor_w)];
			}
		}
		return res;
	}
}