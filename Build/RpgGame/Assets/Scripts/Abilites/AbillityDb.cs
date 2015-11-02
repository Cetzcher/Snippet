using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public class AbillityDb : MonoBehaviour
    {

        [SerializeField]
        private Abillity[] m_abillites;

        public static AbillityDb Instance
        {
            get;
            private set;
        }

        public Abillity GetAbillity(string name)
        {
            Abillity ab = (from x in m_abillites where x.AbillityName == name select x).SingleOrDefault();
            if (ab != null)
                return Instantiate<Abillity>(ab);
            return null;
        }

        private void Awake()
        {
            Instance = Instance == null ? this : Instance;
        }

    }
}
