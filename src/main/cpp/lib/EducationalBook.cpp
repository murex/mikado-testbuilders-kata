#include "domain/book/EducationalBook.h"

domain::book::EducationalBook::EducationalBook(std::string& name, double price, const Author& author,
                                               country::Language language, Category category): name_(name)
                                                                                               , price_(price)
                                                                                               , author_(author)
                                                                                               , language_(language)
                                                                                               , category_(category)
{
}
