#ifndef TESTBUILDERS_WORKSHOP_CLIENT_CLIENT_H_INCLUDED
#define TESTBUILDERS_WORKSHOP_CLIENT_CLIENT_H_INCLUDED

#include <string>
#include "domain/country/Country.h"

namespace client
{

class Client {
	const std::string name_;
	const domain::country::Country country_;

public:
	Client(const std::string& name, const domain::country::Country& country);

	std::string getName() const
	{
		return name_;
	}

	domain::country::Country getCountry() const
	{
		return country_;
	}
};
}

#endif // TESTBUILDERS_WORKSHOP_CLIENT_CLIENT_H_INCLUDED