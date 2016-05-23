package txh.com.yyq.productdetails;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class ClickJieXiaoPage extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "ClickFirstPage";
		String testClass = "txh.com.yyq.productdetails.ClickFirstPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		getProDetails();
	}

	public void getProDetails() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject award = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/openAwardRadio"));
		award.clickAndWaitForNewWindow();
		UiObject icon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_award_item_iv_icon"));
		icon.clickAndWaitForNewWindow();
		sleep(1500);
		JieXiaoProDetailPage jiexiaoPage = new JieXiaoProDetailPage(getUiDevice());
		jiexiaoPage.testCase();

		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
		backBtn.click();
		
	}

}
