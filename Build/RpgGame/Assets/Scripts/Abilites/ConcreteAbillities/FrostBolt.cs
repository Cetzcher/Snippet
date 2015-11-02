using Assets.Scripts.Abilites.Projectiles;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public class FrostBolt : DamageAbillity
    {

        [SerializeField]
        private float m_frostBoltImpulse;
        public FrostBoltProjectile m_frostBoltProjectile;

        protected override void CastInternal(Character caller)
        {
            var projectile = Instantiate<FrostBoltProjectile>(m_frostBoltProjectile);
            projectile.transform.position = caller.transform.position + caller.transform.forward;
            projectile.m_damage = m_damage;
            projectile.transform.LookAt(caller.transform.forward * 2 + caller.transform.position);
            var rb = projectile.GetComponent<Rigidbody>();
            rb.AddForce(caller.transform.forward * m_frostBoltImpulse, ForceMode.Impulse);
        }
    }
}
