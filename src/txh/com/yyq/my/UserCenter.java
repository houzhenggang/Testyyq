package txh.com.yyq.my;

import java.util.ArrayList;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

import txh.com.yyq.unsign.UiAutomatorHelper;

public class UserCenter extends UiAutomatorHelper {

	public static void main(String[] args) {
		String jarName = "UserCenter";
		String testClass = "txh.com.yyq.my.UserCenter";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		clickHeadImage();
		getAccountHeadIcon();
		editNickName();

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
		UiObject weixinchat = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/iv_login_weichat"));
		if (weixinchat.exists()) {

			weixinchat.clickAndWaitForNewWindow();
			UiObject btnOk = new UiObject(new UiSelector().resourceId("btnOk"));
			btnOk.clickAndWaitForNewWindow();
			System.out.println("weixin signin sucessful!!");
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
	 * 个人中心： 1、获取机锋账号 2、修改头像 4、获取排长、相册选择、取消button
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

	/**
	 * 修改昵称 1、直接点击提交按钮 2、 set Nickname 3、提交 4、判断newNickname是否与setNickname一致
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editNickName() throws UiObjectNotFoundException {
		UiObject clickNickname = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_nickname"));
		clickNickname.click();
		UiObject setnickname = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/kit_et_change_nickname"));
		UiObject submit = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/kit_btn_change_nickname_commit"));
		submit.click();
		setnickname.setText("balabala");
		String setNickname = setnickname.getText();
		submit.click();
		UiObject userName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_tv_nick_name"));
		String newNickname = userName.getText();
		if (newNickname.equals(setNickname)) {
			System.out.println("newNickname equals setnickname !!");
		}

	}

	/**
	 * 4、修改密码
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editPassword() throws UiObjectNotFoundException {
		UiObject clickEditPassword = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_password"));
		clickEditPassword.click();
		

	}

	/**
	 * 5、地址管理
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editAddress() throws UiObjectNotFoundException {

	}
}
