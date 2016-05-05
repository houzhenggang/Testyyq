package txh.com.yyq.productdetails;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ProductDetails extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "ProductDetails";
		String testClass = "txh.com.yyq.productdetails.ProductDetails";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		scrollVert();
		getProBasicMess();
		pastJiexiao();
		proDetailImage();
		allRecord();

	}

	/**
	 * 垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollVert() throws UiObjectNotFoundException {
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		scroll.setAsVerticalList();
		scroll.flingForward();
		scroll.flingBackward();
		scroll.flingBackward();

	}

	/**
	 * 商品详情： 1、获取icon 2、获取proname 3、获取 期号/人次
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getProBasicMess() throws UiObjectNotFoundException {
		UiObject picture = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_vp_pictures"));
		System.out.println("picture is exists :" + picture.exists());

		UiObject proname = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_name"));
		System.out.println("proname is :" + proname.getText());

		UiObject normal = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_rl_normal"));
		System.out.println("normal is : " + normal.exists());

		UiObject issue = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_issue"));
		System.out.println(issue.getText());

		UiObject processBar = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_pb_progressbar"));
		System.out.println("processBar is : " + processBar.exists());

		UiObject totalNum = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_total"));
		System.out.println("totalNum is : " + totalNum.getText());

		UiObject lastNum = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_last"));
		System.out.println("lastNum is : " + lastNum.getText());
		System.out.println(totalNum.getText() + ", " + lastNum.getText());

	}

	/**
	 * 往期揭晓 1、往期揭晓页面-有数据；2、往期揭晓页面-没有数据 3、返回商品详情页
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void pastJiexiao() throws UiObjectNotFoundException {
		UiObject past = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_rl_past"));
		past.clickAndWaitForNewWindow();
		UiObject promptText = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/promptText"));
		if (promptText.exists()) {
			System.out.println(promptText.getText());
		} else {
			UiObject jiexiaoList = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/yyq_to_announce_rv_list"));
			System.out.println("jiexiaoList is : " + jiexiaoList.exists());
		}
		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();

	}

	/**
	 * 宝贝图文 1、进入宝贝图文 2、垂直滚动3、点击返回顶部按钮 4、返回商品详情
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void proDetailImage() throws UiObjectNotFoundException {
		UiObject detailImage = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_rl_gooddesc"));
		detailImage.clickAndWaitForNewWindow();
		sleep(1500);
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		scroll.setAsVerticalList();
		scroll.flingForward();
		UiObject backHead = new UiObject(
				new UiSelector().className("android.widget.Image"));
		assertEquals(true, backHead.exists());
		if (backHead.exists()) {
			backHead.click();
			sleep(1000);
		}
		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
	}
	/**
	 * 所有参与记录
	 * @throws UiObjectNotFoundException
	 */
	public void allRecord() throws UiObjectNotFoundException {
		UiObject text = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/textview"));
		System.out.println(text.getText());
		UiObject time = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_time"));
		System.out.println(time.getText());
	}

}
