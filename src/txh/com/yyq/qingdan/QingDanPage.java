package txh.com.yyq.qingdan;

import txh.com.yyq.sign.SignInWeiXin;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 清单： 1、有商品 2、没有商品
 * 
 * @author xiaohua
 * 
 */
public class QingDanPage extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "QingDanPage";
		String testClass = "txh.com.yyq.qingdan.QingDanPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		noPro();
	}

	/**
	 * 已登录： 1、进入清单页面 2、清单页面没有商品 3、点击开始抢宝
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void noPro() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject qingdan = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/billRadio"));
		qingdan.click();
		UiObject signIn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_sign_in"));
		if (signIn.exists()) {
			SignInWeiXin weixin = new SignInWeiXin(getUiDevice());
			weixin.weixinSignIn();
			sleep(2500);
			System.out.println("weixin login succesful!");
			device.click(300, 400);
			qingdan.click();
		}
		UiObject emptyGo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_empty_go"));
		if (emptyGo.exists()) {
			UiObject noProImage = new UiObject(
					new UiSelector().resourceId("android.widget.ImageView"));
			System.out.println("no product image is :" + noProImage.exists());
			UiObject tipsMess = new UiObject(
					new UiSelector().resourceId("android.widget.TextView"));
			System.out.println("tipsMess is :" + tipsMess.exists());
			// System.out.println("tipsMess is :" + tipsMess.getText());

			System.out.println("empty go is :" + emptyGo.exists());
			System.out.println("empty go is :" + emptyGo.getText());
			emptyGo.clickAndWaitForNewWindow();
			UiObject yyqTitle = new UiObject(
					new UiSelector().className("android.widget.TextView"));
			System.out.println("back to yyq page :" + yyqTitle.getText());

		}
		UiObject lists = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_lv_list_view"));
		if (lists.exists()) {
			QingDanLists listname = new QingDanLists();
			listname.testCase();
		}

	}
}
