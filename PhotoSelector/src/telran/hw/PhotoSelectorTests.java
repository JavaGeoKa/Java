package telran.hw;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhotoSelectorTests {

	private static final String[] pictures = {
			"Paris\\20140101_090000.jpg",
			"Paris\\20140201_121005.jpg",				
			"Paris\\20150301_211035.jpg",				
			"Paris\\20150401_110023.gif",
			"Paris\\20150401_181705.jpg",				
			"Paris\\20150501_231035.gif",				
			"London\\20140205_090000.jpg",
			"London\\20140205_121005.jpg",				
			"London\\20140601_211035.gif",				
			"London\\20151001_110023.jpg",
			"London\\20151001_121705.jpg",				
			"London\\20151001_231035.jpg",
			"Chicago\\20150301_120001.png",
			"Chicago\\20151111_232000.png"
	};

	@Test
	public void testAllEuropePictures() {
		String[] expecteds = {
				"Paris\\20140101_090000.jpg",
				"Paris\\20140201_121005.jpg",				
				"Paris\\20150301_211035.jpg",				
				"Paris\\20150401_110023.gif",
				"Paris\\20150401_181705.jpg",				
				"Paris\\20150501_231035.gif",				
				"London\\20140205_090000.jpg",
				"London\\20140205_121005.jpg",				
				"London\\20140601_211035.gif",				
				"London\\20151001_110023.jpg",
				"London\\20151001_121705.jpg",				
				"London\\20151001_231035.jpg"	
		};
		String regex="(London|Paris)";
//		String regex="Chicago";
		String[] actuals = PhotoSelector.selectPictures(pictures,regex);
		assertArrayEquals(expecteds, actuals);
	}

}
