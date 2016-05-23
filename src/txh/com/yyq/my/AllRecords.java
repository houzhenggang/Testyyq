package txh.com.yyq.my;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class AllRecords extends UiAutomatorTestCase {

	/**
	 * 全部抢宝记录
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "AllRecords";
		String testClass = "txh.com.yyq.my.AllRecords";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		UiObject all = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_all_records"));
		all.click();//进入全部抢宝贝页面
		AllGrabRecord allrecord = new AllGrabRecord();
		allrecord.testCase();
		RunningGrabRecord runningrecord = new RunningGrabRecord();
		runningrecord.testCase();
		JXGrabRecord jxrecord = new JXGrabRecord();
		jxrecord.testCase();

	}

}
