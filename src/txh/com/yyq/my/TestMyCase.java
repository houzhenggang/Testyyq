package txh.com.yyq.my;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

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
		ScrollGrabRecord scroll = new ScrollGrabRecord();
		scroll.testCase();
		Running run = new Running();
		run.testCase();
		Published published = new Published();
		published.testCase();
		AllRecords records = new AllRecords();
		records.testCase();
		WonRecords wonrecord = new WonRecords();
		wonrecord.testCase();
		

	}


}
