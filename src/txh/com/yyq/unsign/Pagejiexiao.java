package txh.com.yyq.unsign;

import java.io.File;
import java.util.ArrayList;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 未登录 1、揭晓页面 2、垂直滚动 3、滚动getChildText() 4、水平滚动 5、操作通知栏
 * 
 * @author xiaohua
 * 
 */
public class Pagejiexiao extends UiAutomatorTestCase {
	UiDevice device;

	public Pagejiexiao(UiDevice uidevice) {
		device = uidevice;
	}

	public static void main(String[] args) {
		String jarName = "Pagejiexiao";
		String testClass = "txh.com.yyq.unsign.Pagejiexiao";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	/**
	 * 未登录： 1、垂直滚动 2、滚动，获取指定元素 3、水平滚动 4、操作通知栏
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testCase() throws UiObjectNotFoundException {
		getIconAndName();
		getAwardMessage();
		scrollPage();
		getElement();
		scrollHorizontalList();
		// ClearNotifycation clearNotify = new ClearNotifycation(getUiDevice());
		// clearNotify.testCase();
		clickExchangeTag();
	}

	/**
	 * 未登录： 1、获取奖品icon 2、获取奖品name
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getIconAndName() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject jxTag = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/openAwardRadio"));
		jxTag.click();
		UiObject icon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_award_item_iv_icon"));
		System.out.println("award icon is exists :" + icon.exists());
		UiObject proName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_award_item_tv_name"));
		System.out.println("proName is : " + proName.exists()
				+   proName.getText());
	}
	/**
	 * 未登录：
	 * 1、获取获奖者信息
	 * @throws UiObjectNotFoundException
	 */
	public void getAwardMessage() throws UiObjectNotFoundException {
		ArrayList<String> messLists = new ArrayList<String>();
		UiCollection coll = new UiCollection(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_award_item_rl_do_open"));
		System.out.println("coll is :" + coll.exists());
		if (coll.exists()) {
			int counts = coll.getChildCount();
			for (int i = 0; i < counts; i++) {
				UiObject mess = new UiObject(new UiSelector()
						.className("android.widget.TextView").instance(i));
				if(mess.exists()){
					messLists.add(mess.getText());
				}
				
			}
		}
		System.out.println("mess is : " + messLists);

	}

	/**
	 * 垂直滚动 1、获取最大滚动步数 2、滚动到底部 3、获取底部描述
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollPage() throws UiObjectNotFoundException {
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		scroll.setAsVerticalList();
		int steps = scroll.getMaxSearchSwipes();
		System.out.println("max steps is :" + steps);
		scroll.flingToEnd(steps);
		scroll.flingForward();

		UiObject endText = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/promptText"));
		UiObject endImage = new UiObject(
				new UiSelector().className("android.widget.ImageView"));
		System.out.println("end text is : " + endText.getText());
		System.out.println("end image is exists : " + endImage.exists());

	}

	/**
	 * 未登录： 1、getChildByText(); 2、滚动页面直到查找到指定的元素 3、点击查找到的元素，获取详情页商品的名称
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getElement() throws UiObjectNotFoundException {
		UiScrollable list = new UiScrollable(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_open_award_rlv_list"));
		UiObject contact = list.getChildByText(new UiSelector()
				.resourceId("com.mappn.gfan:id/gm3_yyq_award_item_tv_name"),
				"MOKE手机VR魔镜3d眼镜千幻智能谷歌2box虚拟现实手机私人游戏头盔 vr");
		contact.click();
		sleep(2500);
		device.takeScreenshot(new File("sdcard/Download/afterclickPro.png"));
		device.pressBack();
		UiObject contact2 = list.getChildByText(new UiSelector()
				.resourceId("com.mappn.gfan:id/gm3_yyq_award_tv_good_number"),
				"1000014", true);
		contact2.click();
		sleep(1500);
		device.takeScreenshot(new File("sdcard/Download/afterclickgoodnum.png"));
		device.pressBack();

	}

	/**
	 * 未登录：水平滚动 1、设置滚动方向：水平滚动 2、
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollHorizontalList() throws UiObjectNotFoundException {
		UiScrollable scrollH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollH.setAsHorizontalList();
		scrollH.scrollForward();
		scrollH.scrollBackward();
		sleep(2000);
	}

	/**
	 * 未登录： 1、点击底部四个button切换页面
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void clickExchangeTag() throws UiObjectNotFoundException {
		UiObject yyqTag = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/homeRadio"));
		UiObject jxTag = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/openAwardRadio"));
		UiObject billTag = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/billRadio"));
		UiObject myTag = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/userCenterRadio"));
		yyqTag.click();
		jxTag.click();
		billTag.click();
		myTag.click();
		yyqTag.click();

		device.pressBack();// 返回应用商店首页

	}
}
