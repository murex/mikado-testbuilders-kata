using System;

namespace Application
{
    public sealed class IdGenerator
    {
        private static readonly IdGenerator ID_GENERATOR = new IdGenerator();

        private int _currentId = 0;
        
        public static int NextId()
        {
            ID_GENERATOR._currentId += 1;
            return ID_GENERATOR._currentId;
        }
    }
}