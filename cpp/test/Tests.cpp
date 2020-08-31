#include "gtest/gtest.h"
#include "report/ReportGenerator.h"

using namespace std;

TEST(Books, DISABLED_empty_test)
{
	EXPECT_TRUE(false);
}

int main(int argc, char** argv)
{
	testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}
