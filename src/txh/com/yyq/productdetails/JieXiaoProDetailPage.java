package txh.com.yyq.productdetails;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class JieXiaoProDetailPage extends UiAutomatorTestCase {
	UiDevice device;
	public JieXiaoProDetailPage(UiDevice uidevice){
		device = uidevice;
	}

	public static void main(String[] args) {
		String jarName = "JieXiaoProDetailPage";
		String testClass = "txh.com.yyq.productdetails.JieXiaoProDetailPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		scrollVert();
		getProBasicMess();
		
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

		UiObject result = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/rl_lottery_result"));
		System.out.println("result is : " + result.exists());

		UiObject luckyIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_iv_luckyone_icon"));
		System.out.println("luckyIcon is :" + luckyIcon.exists());

		UiObject luckyName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_lucky_name"));
		System.out.println("luckyName is : " + luckyName.exists() + ","
				+ luckyName.getText());

		UiObject luckyIssue = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_lucky_issue"));
		System.out.println("luckyIssue is : " + luckyIssue.exists() + ", "
				+ luckyIssue.getText());

		UiObject luckyBuy = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_lucky_buy"));
		System.out.println("luckyBuy is : " + luckyBuy.exists() + ", "
				+ luckyBuy.getText());
		UiObject luckyTime = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_lucky_time"));
		System.out.println("luckyTime is :" + luckyTime.exists() + ", "
				+ luckyTime.getText());

		UiObject luckyNumberText = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/tv_lucky_number"));
		System.out.println("luckyNumber is : " + luckyNumberText.exists() + ","
				+ luckyNumberText.getText());
		UiObject luckyNumber = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_lucky_number"));
		System.out.println(luckyNumberText.getText() + luckyNumber.getText());

		UiObject logindesc = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_logindesc"));
		System.out.println("login  button :" + logindesc.exists());
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
	 * 所有参与记录：
	 * 1、获取文本信息：所有参与记录/统计时间
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void allRecord() throws UiObjectNotFoundException {
		UiObject text = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/textview"));
		System.out.println(text.getText());
		UiObject time = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_tv_time"));
		System.out.println(time.getText());
	}

	/**
	 * 所有参与记录： 参与者的个人中心usercenter
	 * 1、点击某条参与记录 -个人中心 2、返回详情页
	 * @throws UiObjectNotFoundException
	 */
	public void userCenter() throws UiObjectNotFoundException {
		UiScrollable scroll = new UiScrollable(
				new UiSelector().scrollable(true));
		scroll.setAsVerticalList();
		scroll.flingForward();
		UiObject icon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_records_item_riv_icon"));
		System.out.println("icon is :" + icon.exists());
		UiObject nickName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_records_item_tv_name"));
		System.out.println("nickName is :" + nickName.exists() + ","
				+ nickName.getText());
		UiObject ip = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_records_item_tv_ip"));
		System.out.println("ip is :" + ip.exists() + "," + ip.getText());
		UiObject tvCount = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_records_item_tv_count"));
		System.out.println(tvCount.exists() + ", " + tvCount.getText());

		UiScrollable uiscroll = new UiScrollable(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_detail_rv_list"));
		UiObject contact = uiscroll
				.getChild(new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_records_item_tv_name"));
		contact.clickAndWaitForNewWindow();

		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
	}


	
	
	
}
