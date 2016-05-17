package txh.com.yyq.my;

import java.util.ArrayList;

import txh.com.yyq.sign.SignInMappn;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Running extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "Running";
		String testClass = "txh.com.yyq.my.Running";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		scrollGrabRecordHori();
		runningScroll();
		wonScroll();
		allScroll();
		emptyGo();
		recordItem();
		checkInfo();
		buyAgain();

	}

	/**
	 * 抢宝记录： 1、水平滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollGrabRecordHori() throws UiObjectNotFoundException {
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
		UiObject clickRunning = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_running"));
		clickRunning.clickAndWaitForNewWindow();
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollableH.flingBackward();
		scrollableH.flingBackward();
		scrollableH.flingForward();

	}

	/**
	 * 2、垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void scrollGrabRecordVer() throws UiObjectNotFoundException {
		UiObject runningLists = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_all_recycler_view"));
		if (runningLists.exists()) {
			UiScrollable scrollableV = new UiScrollable(
					new UiSelector().scrollable(true));
			scrollableV.setAsVerticalList();
			int steps = scrollableV.getMaxSearchSwipes();
			scrollableV.flingToEnd(steps);
			// scrollableV.flingBackward();
			// scrollableV.flingBackward();
			UiObject prompttext = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/promptText"));
			System.out.println("end message is :" + prompttext.getText());
		}
	}

	/**
	 * 进行中页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void runningScroll() throws UiObjectNotFoundException {
		scrollGrabRecordVer();

	}

	/**
	 * 揭晓页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void wonScroll() throws UiObjectNotFoundException {
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollGrabRecordVer();
	}

	/**
	 * 全部页面垂直滚动
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void allScroll() throws UiObjectNotFoundException {
		UiScrollable scrollableH = new UiScrollable(
				new UiSelector().scrollable(true));
		scrollableH.setAsHorizontalList();
		scrollableH.flingForward();
		scrollableH.flingBackward();
		scrollableH.flingBackward();
		scrollGrabRecordVer();
	}

	/**
	 * 进行中页面没有数据： 1、判断是否页面是否有数据
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void emptyGo() throws UiObjectNotFoundException {
		UiObject emptyGo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/award_empty_go"));
		if (emptyGo.exists()) {
			System.out.println("button's text :" + emptyGo.getText());
			UiObject tipsMessage = new UiObject(new UiSelector().resourceId(
					"com.mappn.gfan:id/record_vp_view_pager").childSelector(
					new UiSelector().className("android.widget.TextView")));
			System.out.println("tisp message :" + tipsMessage.getText());
			emptyGo.clickAndWaitForNewWindow();
			UiObject my = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/userCenterRadio"));
			my.click();
			UiObject clickRunning = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/logged_tv_running"));
			clickRunning.clickAndWaitForNewWindow();

		}

	}

	/**
	 * 抢宝记录某个产品的相关信息： 1、判断产品icon是否存在 2、获取产品名称 3、获取参与期号 4、后去我参与的次数 5、剩余人次，总需人次
	 * 6、进度条是否存在
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void recordItem() throws UiObjectNotFoundException {
		UiObject item = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_all_recycler_view"));
		assertEquals(true, item.exists());
		if (item.exists()) {
			UiObject icon = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_iv_icon"));
			assertEquals(true, icon.exists());
			UiObject title = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_title"));
			assertEquals(true, title.exists());
			System.out.println("title is :" + title.getText());
			UiObject issue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_issue"));
			assertEquals(true, issue.exists());
			System.out.println("issue is :" + issue.getText());
			UiObject attends = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_attends_times"));
			assertEquals(true, attends.exists());
			System.out.println("attends is :" + attends.getText());
			UiObject allcount = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_all_count"));
			assertEquals(true, allcount.exists());
			System.out.println("all count is :" + allcount.getText());
			UiObject leftcount = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_left_count"));
			assertEquals(true, leftcount.exists());
			System.out.println("left count is :" + leftcount.getText());
			UiObject processBar = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_running_progress"));
			assertEquals(true, processBar.exists());

		}
	}

	/**
	 * 8、查看详情
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void checkInfo() throws UiObjectNotFoundException {
		UiObject item = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_ll_layout"));
		if (item.exists()) {
			UiObject title = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_title"));
			String titleText = title.getText();
			UiObject issue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_issue"));
			String issueText = (issue.getText()).trim();
			UiObject info = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_info"));
			info.clickAndWaitForNewWindow();
			UiObject infoTitle = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/other_info_title"));
			String infotitle = infoTitle.getText();
			UiObject infoIssue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/other_info_issue"));
			String infoissue = (infoIssue.getText()).trim();
			System.out.println("info issue is :" + infoIssue.getText());
			if (titleText.equalsIgnoreCase(infotitle)) {
				System.out.println("抢宝记录页的产品title与参看详情页的产品title一致！");
			} else {
				System.out.println("抢宝记录页的产品title与参看详情页的产品title不一致！");
			}
			if (issueText.equalsIgnoreCase(infoissue)) {
				System.out.println("抢宝记录页的参与期号与参看详情页的参与期号一致！");
			} else {
				System.out.println("抢宝记录页的参与期号与参看详情页的参与期号不一致！");
			}
			UiObject recordNum = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/record_num"));
			assertEquals(true, recordNum.exists());
			System.out.println("record num :" + recordNum.getText());

			UiCollection coll = new UiCollection(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/other_info_list_view"));
			ArrayList<String> lists = new ArrayList<String>();
			if (coll.exists()) {
				int count = coll.getChildCount(new UiSelector()
						.className("android.widget.LinearLayout"));
				for (int i = 0; i < count; i++) {
					UiObject record = new UiObject(new UiSelector().className(
							"android.widget.LinearLayout").instance(i));
					if (record.exists()) {
						
						UiObject attendDate = new UiObject(
								new UiSelector()
										.resourceId("com.mappn.gfan:id/record_info_item_date"));
						String date = attendDate.getText();
						UiObject attendCount = new UiObject(
								new UiSelector()
										.resourceId("com.mappn.gfan:id/record_info_item_times"));
						String attendcount = attendCount.getText();
						UiObject checkButton = new UiObject(
								new UiSelector()
										.resourceId("com.mappn.gfan:id/record_info_item_detail"));
//						String text = checkButton.getText();
						assertEquals(true, checkButton.exists());
//						lists.add(record.getText());
						lists.add(date);
						lists.add(attendcount);
								
					}

				}
			}
			System.out.println("list is :" + lists);

		}
	}

	/**
	 * 7、追加/再抢一次
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void buyAgain() throws UiObjectNotFoundException {
		UiObject item = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_ll_layout"));
		if (item.exists()) {
			UiObject buyagain = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_buy_again"));
			buyagain.clickAndWaitForNewWindow();

		}

	}

}
