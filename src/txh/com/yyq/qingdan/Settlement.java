package txh.com.yyq.qingdan;

import java.util.ArrayList;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Settlement extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "Settlement";
		String testClass = "txh.com.yyq.qingdan.Settlement";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		settlement();
		getOrderPage();
	}

	/**
	 * 结算： 1、一元抢首页点击加入清单两次 2、点击清单 3、点击结算按钮 4、点击提交订单
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void settlement() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject buy = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_buy"));
		buy.click();
		buy.click();
		UiObject qingdan = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/billRadio"));
		qingdan.click();
		UiObject submit = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_tv_submit"));
		submit.click();
		UiObject ordersubmit = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/order_tv_submit"));
		ordersubmit.click();

	}

	/**
	 * 5、获取支付订单页面元素 6、选择支付方式(点击复选框) 7、点击确认支付
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getOrderPage() throws UiObjectNotFoundException {
		UiObject textView = new UiObject(new UiSelector().index(0));
		System.out.println("textView is :" + textView.getText());
		UiObject paytime = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_tv_time"));
		System.out.println("paytime is :" + paytime.getText());
		UiObject orderNo = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/pay_tv_order_no"));
		System.out.println("orderNo is :" + orderNo.getText());
		UiObject payMethod = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_tv1"));
		UiObject balance = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_tv_balance"));
		System.out.println("paymethod & balance is :"
				+ (payMethod.getText()).concat(balance.getText()));
		UiObject changeInfo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_change_info"));
		System.out.println("changeinfo is :" + changeInfo.getText());
		UiObject paycbbalance = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_cb_balance"));
		paycbbalance.click();
		UiObject payother = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_tv_other"));
		System.out.println("payother is :" + payother.getText());
		UiCollection otherpaymethod = new UiCollection(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_rg_pay"));
		ArrayList<String> lists = new ArrayList<String>();
		if (otherpaymethod.exists()) {
			int count = otherpaymethod.getChildCount(new UiSelector()
					.className("android.widget.RadioButton"));
			System.out.println("count is :" + count);
			for (int i = 0; i < count; i++) {
				UiObject otherpayM = new UiObject(new UiSelector().className(
						"android.widget.RadioButton").instance(i));
				if (otherpayM.exists()) {
					lists.add(otherpayM.getText());
				}
			}
		}
		System.out.println("other pay method is :" + lists);
		UiObject confirmPay = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/pay_tv_confirm"));
		confirmPay.click();
		
		
	}

}
