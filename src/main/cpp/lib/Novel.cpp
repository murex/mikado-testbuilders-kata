#include "domain/book/Novel.h"

domain::book::Novel::Novel(std::string& name, double price, const Author& author, country::Language language,
                           const std::vector<Genre>& genres): name_(name)
                                                              , price_(price)
                                                              , author_(author)
                                                              , language_(language)
                                                              , genres_(genres)
{
}
