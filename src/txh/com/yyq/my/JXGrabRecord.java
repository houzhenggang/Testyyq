package txh.com.yyq.my;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class JXGrabRecord extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "JXGrabRecord";
		String testClass = "txh.com.yyq.my.JXGrabRecord";
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
		UiObject back = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		back.click();
		

	}

}
