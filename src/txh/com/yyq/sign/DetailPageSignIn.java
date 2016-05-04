package txh.com.yyq.sign;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 商品详情页-微信登录-注销
 *  1、登录后获取幸运号码 2、注销
 * 
 * @author xiaohua
 * 
 */
public class DetailPageSignIn extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "DetailPageSignIn";
		String testClass = "txh.com.yyq.sign.DetailPageSignIn";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		detailSignIn();
		Logout();
	}

	/**
	 * 登录：第三方微信登录 1、微信登录成功 2、获取幸运号码
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void detailSignIn() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		// 点击某个坐标点的商品
		// UiDevice device = getUiDevice();
		// device.click(400, 800);
		UiObject clickIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_iv_icon"));
		clickIcon.clickAndWaitForNewWindow();
		UiObject clickLogin = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_logindesc"));
		clickLogin.clickAndWaitForNewWindow();
		SignInWeiXin signweixin = new SignInWeiXin(getUiDevice());
		signweixin.weixinSignIn();
		sleep(3500);
		// device.takeScreenshot(new File("sdcard/Download/clicklogin.png"));
		UiObject luckNum = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detaiil_rl_lucky_numbers"));
		assertEquals(true, luckNum.exists());
		UiObject buyNum = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_buy"));
		System.out.println(buyNum.getText());

		UiObject luckyNumber = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_buynumbers"));
		UiObject number = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_numbers"));
		System.out.println(luckyNumber.getText() + ":" + number.getText());

	}

	/**
	 * 注销： 1、返回一元抢首页 2、我的 3、注销
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void Logout() throws UiObjectNotFoundException {
		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
		ExitGfan exit = new ExitGfan(getUiDevice());
		exit.exit();

	}

}
