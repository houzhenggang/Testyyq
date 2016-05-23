package txh.com.yyq.my;



import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class AllGrabRecord extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "AllGrabRecord";
		String testClass = "txh.com.yyq.my.AllGrabRecord";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		ProductMessage proMessage = new ProductMessage();
		proMessage.testCase();

	}

	
}
