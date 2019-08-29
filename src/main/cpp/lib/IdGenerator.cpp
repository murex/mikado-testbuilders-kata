#include "IdGenerator.h"

namespace
{
	int currentId = 0;
}

int id_generator::nextId()
{
	return ++currentId;
};
