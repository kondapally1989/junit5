/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.junit5.extension;

import static org.junit.gen5.commons.util.AnnotationUtils.isAnnotated;

import java.lang.reflect.Parameter;

import org.junit.gen5.api.TestName;
import org.junit.gen5.api.extension.MethodParameterResolver;
import org.junit.gen5.api.extension.TestExecutionContext;

/**
 * {@code MethodParameterResolver} that resolves the name of the currently
 * executing test for {@code String} method parameters annotated with
 * {@link TestName @TestName}.
 *
 * @author Sam Brannen
 * @since 5.0
 */
public class TestNameParameterResolver implements MethodParameterResolver {

	@Override
	public boolean supports(Parameter parameter, TestExecutionContext testExecutionContext) {
		return (parameter.getType() == String.class && isAnnotated(parameter, TestName.class));
	}

	@Override
	public Object resolve(Parameter parameter, TestExecutionContext testExecutionContext) {
		return testExecutionContext.getDisplayName();
	}

}
