package txh.com.yyq.unsign;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 登录-注销
 * 1、执行方法类 2、调用类的实例对象，执行其他类中的方法
 * @author xiaohua
 *
 */
public class TestUnsignCase extends UiAutomatorTestCase{
	public static void main(String[] args) {
		String jarName = "TestUnsignCase";
		String testClass = "txh.com.yyq.unsign.TestUnsignCase";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	/**
	 * 执行方法
	 * @throws UiObjectNotFoundException
	 */
	public void testCase() throws UiObjectNotFoundException {
		FirstPageyyq firstpageyyq = new FirstPageyyq(getUiDevice());
		firstpageyyq.testCase();
		Pageyyq pageyyq = new Pageyyq(getUiDevice());
		pageyyq.testCase();
		Pagejiexiao pagejiexiao = new Pagejiexiao(getUiDevice());
		pagejiexiao.testCase();
	}

}
