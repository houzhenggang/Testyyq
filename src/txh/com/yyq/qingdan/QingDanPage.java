package txh.com.yyq.qingdan;

import txh.com.yyq.unsign.UiAutomatorHelper;

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
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject qingdan = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/billRadio"));
		qingdan.click();

		UiObject noProImage = new UiObject(
				new UiSelector().resourceId("android.widget.ImageView"));
		System.out.println("no product image is :" + noProImage.exists());

		UiObject textView = new UiObject(
				new UiSelector().resourceId("android.widget.TextView"));
		System.out.println("textView is :" + textView.exists());
		System.out.println("textView is :" + textView.getText());

		UiObject emptyGo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_empty_go"));
		System.out.println("empty go is :" + emptyGo.exists());
		System.out.println("empty go is :" + emptyGo.getText());

		emptyGo.clickAndWaitForNewWindow();
	}
}
