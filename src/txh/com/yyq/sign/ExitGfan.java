package txh.com.yyq.sign;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 注销：
 * 注销-返回应用商店首页
 * @author xiaohua
 *
 */
public class ExitGfan extends UiAutomatorTestCase {
	UiDevice device;

	public ExitGfan(UiDevice uidevice) {
		device = uidevice;
	}

	/**
	 * 注销： 1、点击注销 2、注销后返回应用商店首页
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void exit() throws UiObjectNotFoundException {
		UiObject myBtn = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/userCenterRadio"));
		myBtn.click();

		UiObject headIcon = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/logged_iv_icon"));
		headIcon.click();

		UiObject exit = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_exit"));
		exit.click();

		UiObject confirmBtn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/btn_positive"));
		confirmBtn.click();

		UiObject signBtn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_sign_in"));
		System.out.println("login button is:" + signBtn.exists());

		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
	}

}
