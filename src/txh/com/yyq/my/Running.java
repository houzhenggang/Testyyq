package txh.com.yyq.my;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Running extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "Running";
		String testClass = "txh.com.yyq.my.Running";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase()throws UiObjectNotFoundException{
		AllGrabRecord allrecord = new AllGrabRecord();
		allrecord.testCase();
		RunningGrabRecord runningrecord = new RunningGrabRecord();
		runningrecord.testCase();
		JXGrabRecord jxrecord = new JXGrabRecord();
		jxrecord.testCase();
	}

}
