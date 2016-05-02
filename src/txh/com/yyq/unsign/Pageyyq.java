package txh.com.yyq.unsign;

import junit.framework.Assert;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 1、垂直滚动一元抢page 2、滚动页面找到指定product并点击 3、水平滚动到其他page 4、操作通知栏
 * 
 * @author klisly
 * 
 */
public class Pageyyq extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "Pageyyq";
		String testClass = "txh.com.yyq.Pageyyq";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testCase() throws UiObjectNotFoundException {
		scrollPage();
		getElements();
		scrollHorizontalList();
		ClearNotifycation clearNotify = new ClearNotifycation(getUiDevice());
		clearNotify.testCase();

	}

	/**
	 * 1、获取最大步数：getMaxSearchSwipes();滚动到最后的步数：scrollToEnd()
	 * ，默认不会滚动到最底部2、flingForward() 进一步滚动，到最底部 3、滚动一元抢页面，获取底部提示
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollPage() throws UiObjectNotFoundException {
		// 1、获取最大steps 2、滑动到页面底部
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		int steps = scroll.getMaxSearchSwipes();
		System.out.println("max scroll steps = " + steps);
		scroll.scrollToEnd(steps);
		scroll.flingForward();
		sleep(3500);
		// 1、获取底部元素
		UiObject endImage = new UiObject(
				new UiSelector().className("android.widget.ImageView"));
		Assert.assertEquals(true, endImage.exists());
		UiObject endText = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/promptText"));
		Assert.assertEquals(true, endText.exists());
		System.out.println("endText is :" + endText.getText());

	}

	/**
	 * 1、getChildByText(); 2、滚动页面直到查找到指定的元素 3、点击查找到的元素，获取详情页商品的名称
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getElements() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		// 1、默认滚动查找获取具备UiSelector条件元素集合list 2、再以文本条件查找对象
		UiScrollable list = new UiScrollable(
				new UiSelector().resourceId("com.mappn.gfan:id/yyq_home_view"));
		UiObject contact = list.getChildByText(new UiSelector()
				.resourceId("com.mappn.gfan:id/yyq_home_item_tv_name"),
				"幻响（i-mu）孙小圣 创意多媒体音响/音箱-蓝牙版 无线蓝牙连接 灵猴献瑞 时尚外观设计 ");
		contact.click();
		sleep(3000);
		UiObject detailProName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_name"));
		System.out.println("detail name : " + detailProName.getText());
		device.pressBack();
		// 2、获取滚动中的第二个元素
		UiObject contact2 = list.getChildByText(new UiSelector()
				.resourceId("com.mappn.gfan:id/yyq_home_item_tv_name"),
				" 艾力克智能机器人语音互动手势遥控可以对战智能机器人 黑白");
		contact2.clickAndWaitForNewWindow();
		sleep(2000);
		UiObject detailProName2 = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_name"));
		System.out.println("detail name2 : " + detailProName2.getText());
		device.pressBack();

	}

	/**
	 * 未登录水平滚动四个页面 1、设置滚动方向水平滚动：setAsHorizontalList();
	 * 2、scrollForward()/scrollBackward() 向前/向后滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollHorizontalList() throws UiObjectNotFoundException {
		UiScrollable scrollH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollH.setAsHorizontalList();
		scrollH.scrollForward();
		scrollH.scrollForward();
		scrollH.scrollBackward();
		sleep(2000);

	}

}
