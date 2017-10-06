/*
 * Copyright 2015-2017 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.platform.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.module.ModuleDescriptor;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link ModuleUtils}.
 *
 * @since 1.1
 */
class ModuleUtilsTests {

	@Test
	void version() {
		assertEquals("9", ModuleUtils.VERSION);
	}

	@Test
	void find() {
		ClassFilter modular = ClassFilter.of(name -> name.contains("Module"), type -> true);
		List<Class<?>> classes = ModuleUtils.findAllClassesInModule("java.base", modular);
		assertFalse(classes.isEmpty());
		assertTrue(classes.contains(Module.class));
		assertTrue(classes.contains(ModuleDescriptor.class));
	}
}
