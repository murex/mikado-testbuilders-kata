using Application.Storage;

namespace Application
{
    public sealed class MainRepository
    {
        public static IRepository ConfiguredRepository { get; set; } = new JsonRepository();

        /**
         * Working effectively with Legacy Code
         * https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code
         */
        // TESTING ONLY
        public void Override(IRepository newRepository)
        {
            ConfiguredRepository = newRepository;
        }

        // TESTING ONLY
        public void Reset()
        {
            ConfiguredRepository = new JsonRepository();
        }
    }
}