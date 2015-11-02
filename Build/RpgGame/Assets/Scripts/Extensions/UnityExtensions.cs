using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts
{
    public static class UnityExtensions
    {
        public static T GetComponentInterface<T>(this Component self) where T : class
        {
            return self.GetComponent(typeof(T)) as T;
        }
        public static T GetComponentInterface<T>(this GameObject self) where T : class
        {
            return self.GetComponent(typeof(T)) as T;
        }
    }
}
