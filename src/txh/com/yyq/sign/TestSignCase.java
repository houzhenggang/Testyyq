package txh.com.yyq.sign;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class TestSignCase extends UiAutomatorTestCase{

	public static void main(String[] args) {
		String jarName = "TestSignCase";
		String testClass = "txh.com.yyq.sign.TestSignCase";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);


	}
	public void testCase() throws UiObjectNotFoundException {
		AddToBill addbil = new AddToBill();
		addbil.testCase();
		AddToBill2 addbil2 = new AddToBill2();
		addbil2.testCase();
		DetailPageSignIn detailesign = new  DetailPageSignIn();
		detailesign.testCase();
		ClickYYQBtn yyqBtn = new ClickYYQBtn();
		yyqBtn.testCase();
		
	}

}
