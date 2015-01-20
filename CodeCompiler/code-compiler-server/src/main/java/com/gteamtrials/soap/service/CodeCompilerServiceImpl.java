package com.gteamtrials.soap.service;

import java.util.logging.Logger;

import javax.jws.WebService;

import com.gteamtrials.CodeCompiler;

@WebService
public class CodeCompilerServiceImpl implements CodeCompiler {
	
	private static final Logger log = Logger.getAnonymousLogger();

	@Override
	public String compileAndTest(String code) {
		log.info("Compiling and testing code...");
		return code;
	}
	
}
