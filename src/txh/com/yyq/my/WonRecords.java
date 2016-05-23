package txh.com.yyq.my;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class WonRecords extends UiAutomatorTestCase {

	/**
	 * 中奖记录
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "WonRecords";
		String testClass = "txh.com.yyq.my.WonRecords";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		clickAwardRecord();
		noAwardRecord();
		manageAddress();

	}

	public void clickAwardRecord() throws UiObjectNotFoundException {
		UiObject awardrecord = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_award_records"));
		awardrecord.click();

	}

	public void noAwardRecord() throws UiObjectNotFoundException {
		UiObject emptyGo = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/award_empty_go"));
		if (emptyGo.exists()) {
			System.out.println("no award record is exsit:" + emptyGo.getText());
		}
	}

	public void manageAddress() throws UiObjectNotFoundException {
		UiObject manageADD = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/tv_address_manager"));
		System.out.println("button text :" + manageADD.getText());
		manageADD.click();
		// ManageAddress manADD = new ManageAddress();
		// manADD.testCase();
		UiObject back = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		back.click();
	}

}
