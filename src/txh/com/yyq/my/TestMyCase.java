package txh.com.yyq.my;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestMyCase extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "TestMyCase";
		String testClass = "txh.com.yyq.my.TestMyCase";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);


	}
	public void testCase() throws UiObjectNotFoundException {

	}


}
