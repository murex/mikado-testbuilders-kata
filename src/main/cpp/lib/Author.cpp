#include "domain/book/Author.h"

domain::book::Author::Author(const std::string& name, const country::Country& nationality): name_(name)
                                                                                            , nationality_(nationality)
{
}
