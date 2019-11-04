/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

#ifndef TESTBUILDERS_WORKSHOP_MAIN_REPOSITORY_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_MAIN_REPOSITORY_H_INCLUDED
#include <memory>


namespace storage {
	class Repository;
}

namespace main_repository
{
	std::shared_ptr<storage::Repository> configuredRepository();

	/* Working effectively with Legacy Code
	 * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
	 */
	 // TESTING ONLY
	void override(const std::shared_ptr<storage::Repository>& newRepository);

	// TESTING ONLY
	void reset();
}

#endif // TESTBUILDERS_WORKSHOP_MAIN_REPOSITORY_H_INCLUDED