package txh.com.yyq.my;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class Published extends UiAutomatorTestCase {

	/**
	 * 已揭晓
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "Published";
		String testClass = "txh.com.yyq.my.Published";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		UiObject result = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_result"));
		result.clickAndWaitForNewWindow();//进入揭晓页面
		UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(true));
		scroll.setAsHorizontalList();//设置水平滚动
		scroll.flingBackward();//滚动到进行中页面
		scroll.flingBackward();//滚动到全部页面
		AllGrabRecord allrecord =  new AllGrabRecord();
		allrecord.testCase();
		RunningGrabRecord runningrecord = new RunningGrabRecord();
		runningrecord.testCase();
		JXGrabRecord jxrecord = new JXGrabRecord();
		jxrecord.testCase();
		
		

	}

}
