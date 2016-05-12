package txh.com.yyq.qingdan;

import java.util.ArrayList;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class QingDanLists extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "QingDanLists";
		String testClass = "txh.com.yyq.qingdan.QingDanLists";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		qingdanlist();
		editCount();
		submit();
		editList();
	}

	/**
	 * 1、获取清单页面列表count 5、获取list显示信息
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void qingdanlist() throws UiObjectNotFoundException {
		UiCollection coll = new UiCollection(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_ll_layout"));
		ArrayList<String> list = new ArrayList<String>();
		if (coll.exists()) {
			int count = coll.getChildCount(new UiSelector()
					.resourceId("com.mappn.gfan:id/bill_item_tv_des"));
			for (int i = 0; i > count; i++) {
				UiObject billname = new UiObject(new UiSelector().resourceId(
						"com.mappn.gfan:id/bill_item_tv_des").instance(i));
				if (billname.exists()) {
					list.add(billname.getText());
				}
			}
		}
		System.out.println("list bill is :" + list);
		UiObject renciMessage = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_tv_left"));
		System.out.println(renciMessage.getText());
		UiObject icon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_iv_icon"));
		System.out.println("icon is :" + icon.exists());

	}

	/**
	 * 检查清单页面元素： 2、点击- 3、点击+ 4、输入数字修改
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editCount() throws UiObjectNotFoundException {
		UiObject minus = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_iv_minus"));
		UiObject plus = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_iv_plus"));
		UiObject etcount = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_et_count"));
		System.out.println("before click -/+ button: " + etcount.getText());
		minus.click();
		System.out.println("after click - button:" + etcount.getText());
		plus.click();
		System.out.println("after click + button:" + etcount.getText());
		minus.click();
		System.out.println("after click - button:" + etcount.getText());
		etcount.click();
		etcount.clearTextField();
		etcount.setText("2");
		System.out.println("after setText :" + etcount.getText());
		UiObject back = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		back.click();
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject qingdan = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/billRadio"));
		qingdan.click();

	}

	/**
	 * 6、总计价格 7、温馨提示 8、结算按钮
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void submit() throws UiObjectNotFoundException {
		UiObject billnum = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_tv_num"));
		System.out.println("bill num & bill price is :" + billnum.getText());
		UiObject tipsMessage = new UiObject(
				new UiSelector().className("android.widget.TextView"));
		System.out.println("tipsMessage is :" + tipsMessage.getText());
		UiObject submitBtn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_tv_submit"));
		System.out.println("submint button is :" + submitBtn.exists());

	}

	/**
	 * 编辑： 1、修改清单
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editList() throws UiObjectNotFoundException {
		UiObject editBtn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_tv_edit"));
		editBtn.click();
		UiObject clicksiglecheck = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_item_cb_check"));
		clicksiglecheck.click();
		UiObject delete = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/bill_tv_delete_submit"));
		delete.click();
		UiObject negative = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/btn_negative"));
		negative.click();
		UiObject clickallcheck = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_cb_all"));
		clicksiglecheck.click();
		clickallcheck.click();
		delete.click();
		UiObject positive = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/btn_positive"));
		positive.click();
		UiObject emptyGo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/bill_empty_go"));
		emptyGo.clickAndWaitForNewWindow();
		UiObject yyqTitle = new UiObject(
				new UiSelector().className("android.widget.TextView"));
		System.out.println("back to yyq page :" + yyqTitle.getText());
		UiObject back = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		back.click();

	}
}
