package com.ui.api.automation.rerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass, 
			Constructor testConstructor, Method testMethod) {
		/*IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
		if (retry == null)
			testAnnotation.setRetryAnalyzer(Retry.class);*/
		testAnnotation.setRetryAnalyzer(Retry.class);
	}
	
}
