package txh.com.yyq.my;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class RechargeRecords extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName = "RechargeRecords";
		String testClass = "txh.com.yyq.my.RechargeRecords";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {

	}

	public void clickRechargeRecord() throws UiObjectNotFoundException {
		UiObject rechargeRecord = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/logged_tv_charge_records"));
		rechargeRecord.click();
		
	}
	

}
