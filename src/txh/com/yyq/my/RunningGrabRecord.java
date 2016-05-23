package txh.com.yyq.my;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class RunningGrabRecord extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "RunningGrabRecord";
		String testClass = "txh.com.yyq.my.RunningGrabRecord";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		scroll.setAsHorizontalList();
		scroll.flingForward();
		ProductMessage proMessage = new ProductMessage();
		proMessage.testCase();

	}

}
