package com.gteamtrials.soap.service;

import org.junit.Assert;
import org.junit.Test;

public class CodeCompilerServiceImplTest {
	
	private static final String ERROR_RUN_FAILED = "ERROR - Run Failed!\r\n";

	private static final String INFO_RUNNING_HELLO_WORLD = "INFO - Running HelloWorld.main(String[] args) ...\r\n";

	private static final String INFO_RUN_SUCCESSFUL = "INFO - Run Successful!\r\n";

	private static final String INFO_COMPILING_CODE = "INFO - Compiling code...\r\n";

	private static final String INFO_COMPILE_SUCCESSFUL = "INFO - Compile Successful!\r\n";

	String helloWorldCode = "class HelloWorld {"
			+ "\n  public static void main(String[] args) {"
			+ "\n      System.out.println(\"Hello World!\");"
			+ "\n  }"
			+ "\n}";
	
	String helloWorldCodeWithCompilationErrors = "class HelloWorld {"
			+ "\n  public static void main(String[] args) {"
			+ "\n      Sys.out.println(\"Hello World!\");"
			+ "\n  }"
			+ "\n}";
	
	
	String helloWorldCodeWithExecutionErrors = "class HelloWorld {"
			+ "\n  public static void main(String[] args) {"
			+ "\n      throw new RuntimeException();"
			+ "\n  }"
			+ "\n}";
	
	@Test
	public void testCompileAndRunHelloWorld() throws Exception {		
		String logMessages = new CodeCompilerServiceImpl().compileAndRun(helloWorldCode);
		Assert.assertEquals(
				INFO_COMPILING_CODE +
				INFO_COMPILE_SUCCESSFUL +
				INFO_RUNNING_HELLO_WORLD +
				"Hello World!\r\n" +
				INFO_RUN_SUCCESSFUL, 
				logMessages);
	}
	
	@Test
	public void testCompileAndRunWithCompilationErrorsd() throws Exception {		
		String logMessages = new CodeCompilerServiceImpl().compileAndRun(helloWorldCodeWithCompilationErrors);
		Assert.assertEquals(
				INFO_COMPILING_CODE +
				"ERROR - Line 3, Column 11: Unknown variable or type \"Sys.out\"\r\n", 
				logMessages);
	}
	
	@Test
	public void testCompileAndRunWithExecutionErrors() throws Exception {		
		String logMessages = new CodeCompilerServiceImpl().compileAndRun(helloWorldCodeWithExecutionErrors);
		String expectedMessage = 
				INFO_COMPILING_CODE +
				INFO_COMPILE_SUCCESSFUL +
				INFO_RUNNING_HELLO_WORLD +
				ERROR_RUN_FAILED;
		Assert.assertTrue("Expected: " + expectedMessage + ", actual: " + logMessages, 
				logMessages.startsWith(expectedMessage));
	}

}
