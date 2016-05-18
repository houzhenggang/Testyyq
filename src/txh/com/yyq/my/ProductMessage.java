package txh.com.yyq.my;

import java.util.ArrayList;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ProductMessage extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public void testCase() throws UiObjectNotFoundException {
		emptyGo();
		recordRunningItem();
		recordResultItem();
		checkRunningInfo();
		checkResultInfo();
		runningBuyAgain();
		runningBuyAgain();
		resultBuyAgain();

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
	 * 第一次参与抢宝的商品：running 抢宝记录某个产品的相关信息： 1、判断列表是否有商品，判断产品icon是否存在 2、获取产品名称
	 * 3、获取参与期号 4、后去我参与的次数 5、剩余人次，总需人次 6、进度条是否存在
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void recordRunningItem() throws UiObjectNotFoundException {
		UiObject item = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_all_recycler_view"));
		// assertEquals(true, item.exists());
		UiObject runningTitle = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_tv_title"));
		// assertEquals(true, title.exists());
		if (item.exists() & runningTitle.exists()) {
			System.out.println("runningTitle is :" + runningTitle.getText());
			UiObject runningIcon = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_iv_icon"));
			assertEquals(true, runningIcon.exists());
			UiObject runningIssue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_issue"));
			assertEquals(true, runningIssue.exists());
			System.out.println("runningIssue is :" + runningIssue.getText());
			UiObject runningAttends = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_attends_times"));
			assertEquals(true, runningAttends.exists());
			System.out
					.println("runningAttends is :" + runningAttends.getText());
			UiObject runningAllcount = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_all_count"));
			assertEquals(true, runningAllcount.exists());
			System.out.println("running all count is :"
					+ runningAllcount.getText());
			UiObject runningAeftcount = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_left_count"));
			assertEquals(true, runningAeftcount.exists());
			System.out.println("running left count is :"
					+ runningAeftcount.getText());
			UiObject runningProcessBar = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_running_progress"));
			assertEquals(true, runningProcessBar.exists());

		}
	}

	/**
	 * 该商品参与抢宝次数大于1次：result
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void recordResultItem() throws UiObjectNotFoundException {
		// UiObject item = new UiObject(
		// new UiSelector()
		// .resourceId("com.mappn.gfan:id/record_all_recycler_view"));
		// assertEquals(true, item.exists());
		UiObject resultTitle = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_result_tv_title"));
		// assertEquals(true, resultTitle.exists());
		if (resultTitle.exists()) {
			System.out.println("resultTitle is :" + resultTitle.getText());
			UiObject resultIcon = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_iv_icon"));
			assertEquals(true, resultIcon.exists());
			UiObject resultIssue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_tv_issue"));
			assertEquals(true, resultIssue.exists());
			System.out.println("resultIssue is :" + resultIssue.getText());
			UiObject myAttends = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_tv_attends_times"));
			assertEquals(true, myAttends.exists());
			System.out.println("myAttends is :" + myAttends.getText());
			UiObject winner = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_tv"));
			// assertEquals(true, winner.exists());
			// System.out.println("winner:" + winner.getText());
			UiObject winname = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_win_name"));
			// assertEquals(true, winname.exists());
			System.out.println("winner is :" + (winner.getText())
					+ (winname.getText()));
			UiObject attendscounts = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_tv_left_count"));
			// assertEquals(true, attendscounts.exists());
			System.out.println("attends is :" + attendscounts.getText());
			checkResultInfo();

		}
	}

	/**
	 * 追加、再抢一次 抢宝详情相同的信息: 参与信息：日期、人次
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void grabDetails() throws UiObjectNotFoundException {
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
					// String text = checkButton.getText();
					assertEquals(true, checkButton.exists());
					// lists.add(record.getText());
					lists.add(date);
					lists.add(attendcount);

				}

			}
		}
		System.out.println("list is :" + lists);
		UiObject checkNum = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_info_item_detail"));
		checkNum.click();
		UiObject numTimes = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/other_num_times"));
		System.out.println("num times :" + numTimes.getText());

		UiCollection collNum = new UiCollection(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/other_num_grid_view"));
		ArrayList<String> listsNum = new ArrayList<String>();
		if (collNum.exists()) {
			int countNum = collNum.getChildCount(new UiSelector()
					.className("android.widget.TextView"));
			for (int i = 0; i < countNum; i++) {
				UiObject nums = new UiObject(new UiSelector().className(
						"android.widget.TextView").instance(i));
				if (nums.exists()) {
					listsNum.add(nums.getText());

				}

			}
		}
		System.out.println("lists num :" + listsNum);

	}

	/**
	 * 8、查看详情:商品进行中
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void checkRunningInfo() throws UiObjectNotFoundException {
		UiObject item = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_ll_layout"));
		UiObject runningInfo = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_tv_info"));
		if (item.exists() & runningInfo.exists()) {
			UiObject runnigTitle = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_title"));
			String titleText = runnigTitle.getText();
			UiObject runningIssue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_running_tv_issue"));
			String issueText = (runningIssue.getText()).trim();
			runningInfo.clickAndWaitForNewWindow();
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
			grabDetails();
		}
	}

	/**
	 * 查看详情：商品已经有开奖结果
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void checkResultInfo() throws UiObjectNotFoundException {
		// UiObject item = new UiObject(
		// new UiSelector()
		// .resourceId("com.mappn.gfan:id/record_item_running_ll_layout"));
		UiObject resultInfo = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_result_tv_info"));
		if (resultInfo.exists()) {
			UiObject resultTitle = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_tv_title"));
			String titleText = resultTitle.getText();
			UiObject resultIssue = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/record_item_result_tv_info"));
			String issueText = (resultIssue.getText()).trim();
			resultInfo.clickAndWaitForNewWindow();
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
			UiObject revealed = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/other_revealed_time"));
			System.out.println("revealed time :" + revealed.getText());
			grabDetails();
			UiObject back = new UiObject(
					new UiSelector().className("android.widget.ImageButton"));
			back.click();
			back.click();

		}

	}

	/**
	 * 7、追加
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void runningBuyAgain() throws UiObjectNotFoundException {
		UiObject runningBuyAgain = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_running_tv_buy_again"));
		if (runningBuyAgain.exists()) {
			runningBuyAgain.clickAndWaitForNewWindow(2000);
			UiObject yyqlist = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/gm3_yyq_detail_btn_in_indiana_normal"));
			assertEquals(true, yyqlist.exists());
			UiObject normalBtn = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/gm3_yyq_detail_btn_in_indiana_normal"));
			assertEquals(true, normalBtn.exists());
			UiObject back = new UiObject(
					new UiSelector().className("android.widget.ImageButton"));
			back.click();

		}

	}

	/**
	 * 再抢一次
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void resultBuyAgain() throws UiObjectNotFoundException {
		UiObject resultBuyAgain = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/record_item_result_tv_buy_again"));
		if (resultBuyAgain.exists()) {
			resultBuyAgain.clickAndWaitForNewWindow(2000);
			UiObject yyqlist = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/yyq_detail_rv_list"));
			assertEquals(true, yyqlist.exists());
			UiObject newBtn = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/gm3_yyq_detail_btn_newactivity"));
			assertEquals(true, newBtn.exists());
			UiObject back = new UiObject(
					new UiSelector().className("android.widget.ImageButton"));
			back.click();

		}
	}

}
