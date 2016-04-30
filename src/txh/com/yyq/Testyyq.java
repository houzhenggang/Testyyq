package txh.com.yyq;

import junit.framework.Assert;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 1、验证两种方式进入一元抢 2、验证首页一元抢icon/商品名称/开奖进度/加入清单
 * 
 * @author xiaohua
 * 
 */
public class Testyyq extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "Testyyq";
		String testClass = "txh.com.yyq.Testyyq";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	/**
	 * @testCase()
	 * @throws UiObjectNotFoundException
	 */
	public void testCase() throws UiObjectNotFoundException {
		clickNav();
		clickGo();
		productElement();
	}

	/**
	 * fourthNav 一元抢按钮进入一元抢首页
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickNav() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject yyqtext = new UiObject(
				new UiSelector().className("android.widget.TextView"));
		System.out.println("yyq  title is ： " + yyqtext.exists() + "="
				+ yyqtext.getText());
		sleep(1000);
		device.pressBack();
	}

	/**
	 * goButton Go 进入一元抢首页
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickGo() throws UiObjectNotFoundException {
		UiObject goButton = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/actionGo"));
		goButton.clickAndWaitForNewWindow();
		UiObject yyqtext = new UiObject(
				new UiSelector().className("android.widget.TextView"));
		System.out.println("yyq title is ： " + yyqtext.exists() + "="
				+ yyqtext.getText());
		UiObject backButton = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		sleep(1000);
		backButton.clickAndWaitForNewWindow();

	}

	/**
	 * 1、验证商品描述元素
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void productElement() throws UiObjectNotFoundException {
		UiObject proIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_iv_icon"));
		Assert.assertEquals(true, proIcon.exists());
		System.out.println("icon is exists " + proIcon.exists());

		UiObject proName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_name"));
		Assert.assertEquals(true, proName.exists());
		System.out.println("proName is = " + proName.getText());

		UiObject winDesc = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_desc"));
		Assert.assertEquals(true, winDesc.exists());
		System.out.println("winDesc is " + winDesc.getText());

		UiObject proProcess = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_progress"));
		Assert.assertEquals(true, proProcess.exists());
		System.out.println("proProcess is " + proProcess.getText());

		UiObject proBar = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_pb_progress"));
		Assert.assertEquals(true, proBar.exists());
		System.out.println("proBar is " + proBar.exists());

		UiObject proBuy = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_buy"));
		Assert.assertEquals(true, proBuy.exists());
		System.out.println("proBuy is " + proBuy.getText());

	}

}
