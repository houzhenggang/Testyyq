package txh.com.yyq.qingdan;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;


public class TestQingDanPageCase extends UiAutomatorTestCase{

	public static void main(String[] args) {
		String jarName = "TestQingDanPageCase";
		String testClass = "txh.com.yyq.qingdan.TestQingDanPageCase";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase()throws UiObjectNotFoundException{
		QingDanPage qingdanpage = new QingDanPage();
		qingdanpage.testCase();
		Settlement settlement = new Settlement();
		settlement.testCase();
	}

}
