package com.gteamtrials.soap.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;

import com.gteamtrials.CodeCompiler;

@WebService
public class CodeCompilerServiceImpl implements CodeCompiler {
	
	private static final Logger log = Logger.getLogger(CodeCompilerServiceImpl.class);

	@Override
	public String compileAndRun(String code) {
		OutputStream outputStream = new ByteArrayOutputStream();
		WriterAppender writerAppender = new WriterAppender(new SimpleLayout(), outputStream);
		log.addAppender(writerAppender);

		PrintStream sytemOutDefault = System.out;
		
		try {
			log.info("Compiling code...");
			SimpleCompiler compiler = new SimpleCompiler(null, new StringReader(code));
			ClassLoader classLoader = compiler.getClassLoader();
			log.info("Compile Successful!");

	        // Load the class.
	        String className = "HelloWorld";
	        
	        log.info("Running " + className + ".main(String[] args) ...");
			Class<?> c = classLoader.loadClass(className);

	        // Invoke the "public static main(String[])" method.
	        Method mainMethod = c.getMethod("main", new Class[] { String[].class });
	        mainMethod.setAccessible(true);
			
			System.setOut(new PrintStream(outputStream));			
	        mainMethod.invoke(null, new Object[] { new String[0]});
	        
	        log.info("Run Successful!");
	    	        			
		} catch (InvocationTargetException e) {
			log.error("Run Failed!", e.getCause());
		} catch (CompileException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			System.setOut(sytemOutDefault);
			log.removeAppender(writerAppender);
		}
		
		return outputStream.toString();
		
	}
	
}
