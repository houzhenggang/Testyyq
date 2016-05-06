package txh.com.yyq.productdetails;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestProDetailPage extends UiAutomatorTestCase{

	public static void main(String[] args) {
		String jarName = "TestProDetailPage";
		String testClass = "txh.com.yyq.productdetails.TestProDetailPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase()throws UiObjectNotFoundException{
		ClickYYQPage yyqPage = new ClickYYQPage();
		yyqPage.testCase();
		ClickFirstPage firstPage = new ClickFirstPage();
		firstPage.testCase();
		ClickJieXiaoPage jiexiaoPage = new ClickJieXiaoPage();
		jiexiaoPage.testCase();
	}

}
