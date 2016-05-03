package txh.com.yyq.unsign;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestUnsignCase extends UiAutomatorTestCase{
	public static void main(String[] args) {
		String jarName = "TestUnsignCase";
		String testClass = "txh.com.yyq.unsign.TestUnsignCase";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase() throws UiObjectNotFoundException {
		FirstPageyyq firstpageyyq = new FirstPageyyq(getUiDevice());
		firstpageyyq.testCase();
		Pageyyq pageyyq = new Pageyyq(getUiDevice());
		pageyyq.testCase();
		Pagejiexiao pagejiexiao = new Pagejiexiao(getUiDevice());
		pagejiexiao.testCase();
	}

}
