using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assets.Scripts
{
    public interface IHealth
    {
        float Health { get; set; }
        float MaxHealth { get; }
    }
}
