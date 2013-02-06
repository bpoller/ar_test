package org.bpoller.artest;

/**
 * 
 */

import java.util.List;

import org.openimaj.image.MBFImage;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.Device;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.capture.VideoCaptureException;

/**
 * A simple test harness for processing videos through the OpenIMAJ Video APIs.
 * This demo draws a histogram at the bottom of the image.
 * 
 * @author David Dupplaw <dpd@ecs.soton.ac.uk>
 * @version $Author$, $Revision$, $Date$
 * @created 31 May 2011
 */
public class OpenIMAJVideoAPIDemo implements VideoDisplayListener<MBFImage> {
	/**
	 * Default constructor.
	 */
	public OpenIMAJVideoAPIDemo() {
		try {

			List<Device> devices = VideoCapture.getVideoDevices();

			initDisplay(devices.get(1));
			initDisplay(devices.get(2));
			
			// rightDisplay.addVideoListener(this);
			// leftDisplay.addVideoListener(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private VideoDisplay<MBFImage> initDisplay(Device device) throws VideoCaptureException {
		VideoCapture capture = new VideoCapture(320, 240, device);

		VideoDisplay<MBFImage> display = VideoDisplay
				.createVideoDisplay(capture);
		return display;
	}

	

	

	/**
	 * Plot a histogram into an image of another image in a given colour.
	 * 
	 * @param img
	 *            The image to plot into
	 * @param img2
	 *            The image whose histogram is to be plotted
	 * @param colour
	 *            The colour in which to plot the histogram.
	 */
//	public void plotHisto(MBFImage img, FImage img2, Float[] colour) {
//		// The number of bins is set to the image width here, but
//		// we could specify a specific amount here.
//		int nBins = img.getWidth();
//
//		// Calculate the histogram
//		Histogram h = HistogramProcessor.getHistogram(img2, nBins);
//		h.normalise();
//
//		// Find the maximum so we can scale the bins
//		double max = h.max();
//
//		// Work out how fat to draw the lines.
//		double lineWidth = img.getWidth() / nBins;
//
//		// Now draw all the bins.
//		int x = 0;
//		for (double d : h.getVector()) {
//			img.drawLine(x, img.getHeight(), x, img.getHeight()
//					- (int) (d / max * img.getHeight()), (int) lineWidth,
//					colour);
//			x += lineWidth;
//		}
//	}

	/**
	 * @inheritDoc
	 * @see org.openimaj.video.VideoDisplayListener#afterUpdate(org.openimaj.video.VideoDisplay)
	 */
	public void afterUpdate(VideoDisplay<MBFImage> display) {
		// No implementation
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new OpenIMAJVideoAPIDemo();
	}

	@Override
	public void beforeUpdate(MBFImage frame) {
		// TODO Auto-generated method stub
		
	}
}
