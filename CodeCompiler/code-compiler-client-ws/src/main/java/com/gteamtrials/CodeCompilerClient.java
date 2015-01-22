package com.gteamtrials;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.gteamtrials.soap.service.CodeCompiler;
import com.gteamtrials.soap.service.CodeCompilerServiceImplService;

public class CodeCompilerClient {

	public String compileAndRun(String helloWorldCode)
			throws MalformedURLException {
		URL wsdlUrl = new URL("http://localhost:8080/code-compiler-server-ws/codecompiler?wsdl");
		QName qname = new QName("http://service.soap.gteamtrials.com/", "CodeCompilerServiceImplService");
		
		CodeCompilerServiceImplService service = new CodeCompilerServiceImplService(wsdlUrl, qname);
		CodeCompiler compiler = service.getCodeCompilerServiceImplPort();
		return compiler.compileAndRun(helloWorldCode);
	}
	
	public static void main(String[] args) throws Exception {		
		
		String helloWorldCode = "class HelloWorld {"
				+ "\n  public static void main(String[] args) {"
				+ "\n      System.out.println(\"Hello World!\");"
				+ "\n  }"
				+ "\n}";
		
		new CodeCompilerClient().compileAndRun(helloWorldCode);
			
	}

}
