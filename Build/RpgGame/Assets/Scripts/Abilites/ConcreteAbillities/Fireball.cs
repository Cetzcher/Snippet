using Assets.Scripts.Abilites.Projectiles;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public class Fireball : DamageAbillity
    {

        [SerializeField]
        private float m_fireballImpulse;
        public FireballProjectile m_fireballProjectile;

        protected override void CastInternal(Character caller)
        {
            var projectile = Instantiate<FireballProjectile>(m_fireballProjectile);
            projectile.transform.position = caller.transform.position + caller.transform.forward;
            projectile.m_damage = m_damage;
            var rb = projectile.GetComponent<Rigidbody>();
            rb.AddForce(caller.transform.forward * m_fireballImpulse, ForceMode.Impulse);
        }
    }
}
