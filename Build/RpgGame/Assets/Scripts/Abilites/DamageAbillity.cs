using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public abstract class DamageAbillity : Abillity
    {
        [SerializeField]
        protected float m_damage = 10;
    }
}
