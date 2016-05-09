package txh.com.yyq.productdetails;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class YYQ extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "YYQ";
		String testClass = "txh.com.yyq.productdetails.YYQ";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		int i = 0;
		while (i < 10) {
			clickYYQ();
			System.out.println("i = :" + i);
			i++;
		}
	}

	/**
	 * 循环打开一元抢-返回应用商店首页： 1、点击一元抢 2、点击返回 3、while循环运行此方法
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickYYQ() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject back = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		back.click();

	}

}
