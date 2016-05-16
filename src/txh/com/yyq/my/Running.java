package txh.com.yyq.my;

import txh.com.yyq.sign.SignInMappn;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Running extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "Running";
		String testClass = "txh.com.yyq.my.Running";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		scrollGrabRecordHori();

	}

	/**
	 * 抢宝记录： 1、水平滚动 
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollGrabRecordHori() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject my = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/userCenterRadio"));
		my.click();
		UiObject signIn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_sign_in"));
		if (signIn.exists()) {
			SignInMappn signMapp = new SignInMappn();
			signMapp.signIn();
		}
		UiObject clickRunning = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_running"));
		clickRunning.clickAndWaitForNewWindow();
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollableH.flingBackward();
		scrollableH.flingBackward();
		scrollableH.flingForward();

	}
	/**
	 * 2、垂直滚动
	 * @throws UiObjectNotFoundException
	 */
	public void scrollGrabRecordVer()throws UiObjectNotFoundException{
		UiScrollable scrollableV = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableV.setAsVerticalList();
		
	}
	

}
