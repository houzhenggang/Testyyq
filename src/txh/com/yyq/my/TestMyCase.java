package txh.com.yyq.my;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestMyCase extends UiAutomatorTestCase{

	/**
	 * 执行方法类
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
		HeadNickname headnickname = new HeadNickname();
		headnickname.testCase();
		EditNickName editnickname = new EditNickName(getUiDevice());
		editnickname.testCase();
		ChangePassword changepwd = new ChangePassword();
		changepwd.testCase();
		ManageAddress editadd = new ManageAddress();
		editadd.testCase();
		Recharge recharge = new Recharge();
		recharge.testCase();
		AllGrabRecord allrecord = new AllGrabRecord();
		allrecord.testCase();
		

	}


}
