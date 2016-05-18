package txh.com.yyq.my;


import txh.com.yyq.sign.SignInMappn;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AllGrabRecord extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "AllGrabRecord";
		String testClass = "txh.com.yyq.my.AllGrabRecord";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		scrollGrabRecordHori();
		runningScroll();
		wonScroll();
		allScroll();
		ProductMessage proMessage = new ProductMessage();
		proMessage.testCase();

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
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollGrabRecordVer() throws UiObjectNotFoundException {
		UiObject runningLists = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_all_recycler_view"));
		if (runningLists.exists()) {
			UiScrollable scrollableV = new UiScrollable(
					new UiSelector().scrollable(true));
			scrollableV.setAsVerticalList();
			int steps = scrollableV.getMaxSearchSwipes();
			scrollableV.flingToEnd(steps);
			// scrollableV.flingBackward();
			// scrollableV.flingBackward();
			UiObject prompttext = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/promptText"));
			System.out.println("end message is :" + prompttext.getText());
		}
	}

	/**
	 * 进行中页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void runningScroll() throws UiObjectNotFoundException {
		scrollGrabRecordVer();

	}

	/**
	 * 揭晓页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void wonScroll() throws UiObjectNotFoundException {
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollGrabRecordVer();
	}

	/**
	 * 全部页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void allScroll() throws UiObjectNotFoundException {
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollableH.flingBackward();
		scrollableH.flingBackward();
		scrollGrabRecordVer();
	}

}
