package txh.com.yyq.unsign;

import java.io.File;
import java.util.ArrayList;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

/**
 * 1、打开通知栏 2、获取通知栏机锋应用商店的通知 3、点击某个通知 4、打开通知栏 ，清除通知栏信息 5、关闭通知栏
 * 
 * @author klisly
 * 
 */
public class ClearNotifycation extends UiAutomatorTestCase {
	UiDevice device;
	public ClearNotifycation(UiDevice uidevice) {
		device = uidevice;
	}

	public static void main(String[] args) {
		String jarName = "ClearNotifycation";
		String testClass = "txh.com.yyq.unsign.ClearNotifycation";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testCase() throws UiObjectNotFoundException {
		clickNotifcation();
	}

	/**
	 * 1、打开通知栏 2、获取通知栏机锋应用商店的通知title/描述 3、判断是否有机锋应用商店的通知 4、有：点击通知 5、再次打开通知栏
	 * 6、清除通知
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickNotifcation() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		device.openNotification();
		ArrayList<String> titleLists = new ArrayList<String>();
		ArrayList<String> detailLists = new ArrayList<String>();
		UiCollection notifyCounts = new UiCollection(new UiSelector()
				.resourceId("android:id/status_bar_latest_event_content")
				.childSelector(
						new UiSelector().packageNameMatches("com.mappn.gfan")));
		assertEquals(true, notifyCounts.exists());
		if (notifyCounts.exists()) {
			int notifycounts = notifyCounts.getChildCount();
			System.out.println("notifycounts is :" + notifycounts);
			// 1、获取通知的titleName
			if (notifyCounts.exists()) {
				int titleCount = notifyCounts.getChildCount(new UiSelector()
						.resourceId("android:id/title"));
				int detailCount = notifyCounts.getChildCount(new UiSelector()
						.resourceId("android:id/text"));
				for (int i = 0; i < titleCount; i++) {
					UiObject titleName = new UiObject(new UiSelector()
							.resourceId("android:id/title").instance(i));
					if (titleName.exists()) {
						titleLists.add(titleName.getText());
					}
				}
				// 1、获取通知描述detailName
				for (int j = 0; j < detailCount; j++) {
					UiObject detailName = new UiObject(new UiSelector()
							.resourceId("android:id/text").instance(j));
					if (detailName.exists()) {
						detailLists.add(detailName.getText());
					}
				}
			}

			System.out.println("notify titleName is : " + titleLists);
			System.out.println("notify detailName is : " + detailLists);
			// 1、点击通知
			UiObject gfanName = new UiObject(
					new UiSelector().packageName("com.mappn.gfan"));
			if (gfanName.exists()) {
				gfanName.clickAndWaitForNewWindow();
				sleep(1000);
				File path = new File("sdcard/Download/afterclickNotify.png");
				device.takeScreenshot(path);
				sleep(2000);
			}
			// 1、再次打开通知 2、清除某个坐标点的通知swipe() 3、清除通知栏所有通知
			// clearNotify();4、关闭通知栏pressBack()
			device.openNotification();
			UiObject clearNotifyHUA = new UiObject(
					new UiSelector()
							.resourceId("com.android.systemui:id/clear_notification"));
			UiObject clearNotifyMI = new UiObject(
					new UiSelector()
							.resourceId("com.android.systemui:id/clear_all_button"));
			device.swipe(320, 1153, 1080, 1299, 5);
			sleep(2000);
			if (clearNotifyHUA.exists()) {
				clearNotifyHUA.click();
			} else if (clearNotifyMI.exists()) {
				clearNotifyMI.click();
			}

			File path = new File("sdcard/Download/afterclearNotify.png");
			device.takeScreenshot(path);
			device.takeScreenshot(path);
			device.pressBack();

		} else {
			device.takeScreenshot(new File("sdcard/Download/noNotifys.png"));
			System.out.println("com.mappn.gfan is not exists!!");
			sleep(1500);
			device.pressBack();
		}
	}

}
