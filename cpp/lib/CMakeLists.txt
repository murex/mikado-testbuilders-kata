add_library(Client Client.cpp BooksOrder.cpp Order.cpp)
target_include_directories(Client PUBLIC client)

add_library(Domain Author.cpp Book.cpp Novel.cpp Country.cpp EducationalBook.cpp)
target_include_directories(Domain PUBLIC domain/book domain/country)

add_library(Finance CurrencyConverter.cpp TaxRule.cpp)
target_include_directories(Finance PUBLIC finance)

add_library(Purchase Invoice.cpp PurchasedBook.cpp)
target_include_directories(Purchase PUBLIC purchase)

add_library(Report ReportGenerator.cpp)
target_include_directories(Report PUBLIC report)

add_library(Storage JsonRepository.cpp Repository.cpp)
target_include_directories(Storage PUBLIC storage)

add_library(MainRepository MainRepository.cpp)
target_include_directories(MainRepository PUBLIC .)

add_library(IdGenerator IdGenerator.cpp)
target_include_directories(IdGenerator PUBLIC .)

target_link_libraries(Report MainRepository)
