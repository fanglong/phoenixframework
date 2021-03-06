package org.phoenix.cases;

import java.util.LinkedList;

import org.phoenix.action.WebElementActionProxy;
import org.phoenix.enums.LocatorType;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;

/**
 * 浏览器驱动测试类
 * @author mengfeiyang
 *
 */
public class TestBrowserDriver extends WebElementActionProxy{
	private static String caseName = "IE";
	
	public TestBrowserDriver() {
		
	}

	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean caseLogBean) {
		init(caseName,caseLogBean);
		
		webProxy.setFirefoxExePath("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		webProxy.setChromeDriverExePath("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		//webProxy.openNewWindowByFirefox("http://www.baidu.com");
		//webProxy.openNewWindowByChrome("http://www.baidu.com");
		webProxy.openNewWindowByIE("http://www.baidu.com");
		//webProxy.openNewWindowByHtmlUnit("http://www.baidu.com", true, BrowserVersion.INTERNET_EXPLORER);
		//webProxy.openNewWindowByPhantomJs("http://www.baidu.com");
		webProxy.webElement("//*[@id=\"kw\"]",LocatorType.XPATH).setText("phoenixframe");
		webProxy.webElement("//*[@id=\"su\"]", LocatorType.XPATH).click();
		System.out.println(webProxy.webElement("//*[@id=\"su\"]", LocatorType.XPATH).getAttribute("value"));
		webProxy.sleep(1000);
		webProxy.closeWindow();	
		
		return getUnitLog();
	}
	
	public static void main(String[] args) {
		TestBrowserDriver t = new TestBrowserDriver();
		LinkedList<UnitLogBean> ll = t.run(new CaseLogBean());
		for(UnitLogBean l : ll){
			System.out.println(l.getContent());
		}
	}
}
