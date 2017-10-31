package vision;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CameraStream {
	
	VideoCapture camera = new VideoCapture(0);
	
	Mat frame = new Mat();
	
	public Mat getFrame(){
		camera.read(frame);
		return frame;
	}

}
