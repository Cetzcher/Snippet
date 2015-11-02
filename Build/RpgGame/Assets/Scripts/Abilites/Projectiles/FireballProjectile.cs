using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites.Projectiles
{

    public class FireballProjectile : Projectile
    {

        protected override void OnCollionEnter(Collision col)
        {
            var other = col.gameObject;
            IHealth health = other.GetComponentInterface<IHealth>();
            if (health != null)
                health.Health -= m_damage;
        }

    }
}
