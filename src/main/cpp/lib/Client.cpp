#include "client/Client.h"

client::Client::Client(const std::string& name, const domain::country::Country& country): name_(name)
                                                                                          , country_(country)
{
}
