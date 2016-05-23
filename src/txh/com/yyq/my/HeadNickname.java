package txh.com.yyq.my;

import java.util.ArrayList;


import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

import txh.com.yyq.sign.SignInMappn;
/**
 * 1、获取昵称
 * 2、获取修改头像方式
 * @author xiaohua
 *
 */
public class HeadNickname extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "HeadNickname";
		String testClass = "txh.com.yyq.my.HeadNickname";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		clickHeadImage();
		getAccountHeadIcon();

	}

	/**
	 * 个人中心： 1、从应用商店首页进入 2、点击我的 3、判断是否登录(如未登录使用微信登录) 4、登录后，点击头像 4、get昵稱、點擊頭像
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickHeadImage() throws UiObjectNotFoundException {
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
		UiObject loggedIcon = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/logged_iv_icon"));
		UiObject loggedName = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/logged_tv_name"));
		String loggedname = loggedName.getText();
		loggedIcon.clickAndWaitForNewWindow();
		UiObject nickName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_tv_nick_name"));
		String nickname = nickName.getText();
		if (loggedname.equals(nickname)) {
			System.out.println("loggedName equals nickName !!");
		}

	}

	/**
	 * 个人中心： 1、获取机锋账号 2、修改头像 4、获取拍照、相册选择、取消button
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getAccountHeadIcon() throws UiObjectNotFoundException {
		UiObject userAccount = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/user_tv1"));
		UiObject userName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_tv_user_name"));
		System.out.println("userAcount & userName is :"
				+ (userAccount.getText()).concat(userName.getText()));
		UiObject editUserHead = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_icon"));
		editUserHead.click();
		UiCollection coll = new UiCollection(
				new UiSelector().resourceId("com.mappn.gfan:id/pop_layout"));
		ArrayList<String> list = new ArrayList<String>();
		if (coll.exists()) {
			int count = coll.getChildCount(new UiSelector()
					.className("android.widget.Button"));
			System.out.println("count is :" + count);
			for (int i = 0; i < count; i++) {
				UiObject button = new UiObject(new UiSelector().className(
						"android.widget.Button").instance(i));
				if (button.exists()) {
					list.add(button.getText());
				}
			}
		}
		System.out.println("list is :" + list);

	}
}
