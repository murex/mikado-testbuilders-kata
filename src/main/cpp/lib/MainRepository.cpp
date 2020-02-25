/*******************************************************************************
 *
 * Copyright (c) {2003-2019} Murex S.A.S. and its affiliates.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * https://opensource.org/licenses/MIT
 *
 *******************************************************************************/

#include "MainRepository.h"
#include "storage/Repository.h"
#include "storage/JsonRepository.h"


namespace
{
	std::shared_ptr<storage::Repository> runningRepository;
}

namespace main_repository
{
	std::shared_ptr<storage::Repository> configuredRepository()
	{
		if (!runningRepository.get()) {
			runningRepository = std::make_shared<storage::JsonRepository>();
		}
		return runningRepository;
	}

	/* Working effectively with Legacy Code
	 * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
	 */
	 // TESTING ONLY
	void override(const std::shared_ptr<storage::Repository>& newRepository)
	{
		runningRepository = newRepository;
	}

	// TESTING ONLY
	void reset()
	{
		runningRepository = nullptr;
	}
}


