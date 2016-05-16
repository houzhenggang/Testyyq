package txh.com.yyq.my;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;
import txh.com.yyq.sign.SignInMappn;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 充值： 1、获取原有机锋券 2、充值
 * 
 * @param args
 */
public class Recharge extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "Recharge";
		String testClass = "txh.com.yyq.my.Recharge";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		getGfanCard();
		goCharge();

	}

	public void getGfanCard() throws UiObjectNotFoundException {
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
		UiObject GfanCard = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_luck_coin_num"));
		System.out.println("GfanCard is :" + GfanCard.getText());
		UiObject charge = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_charge"));
		charge.click();
		UiObject tipsMessage = new UiObject(new UiSelector().resourceId(
				"com.mappn.gfan:id/ll_1").childSelector(
				new UiSelector().className("android.widget.TextView")));
		System.out.println("tip message is :" + tipsMessage.getText());
		UiObject contactQQ = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/contact_QQ"));
		System.out.println("contactQQ is :" + contactQQ.getText());
		UiObject contactEmail = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/contact_emial"));
		UiObject email = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/emial"));
		System.out.println("contactEmail is :"
				+ (contactEmail.getText()).contains(email.getText()));

	}
	/**
	 * 充值页面：
	 * 1、点击没一个充值金额；输入充值金额 
	 * 2、点击[立即支付]
	 * 3、放弃支付，返回首页
	 * @throws UiObjectNotFoundException
	 */
	public void goCharge() throws UiObjectNotFoundException {
		UiObject charge10 = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_t1"));
		charge10.click();
		UiObject charge50 = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_t2"));
		charge50.click();
		UiObject charge100 = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_t3"));
		charge100.click();
		UiObject charge500 = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_t5"));
		charge500.click();
		UiObject edcharge = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_e1"));
		edcharge.setText(Utf7ImeHelper.e("1"));
		UiObject charge200 = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_t4"));
		charge200.click();
		edcharge.clickTopLeft();
		edcharge.clearTextField();
		edcharge.setText(Utf7ImeHelper.e("0.2"));
		UiObject alipay = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_AiPay"));
		alipay.click();
		UiObject weiPay = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_WePay"));
		weiPay.click();
		UiObject gocharge = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/uc_Go_recharge"));
		gocharge.clickAndWaitForNewWindow();
		UiObject weixinBackBtn = new UiObject(
				new UiSelector().resourceId("com.tencent.mm:id/cex"));
		weixinBackBtn.clickAndWaitForNewWindow(2000);
		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
		backBtn.click();

	}

}
