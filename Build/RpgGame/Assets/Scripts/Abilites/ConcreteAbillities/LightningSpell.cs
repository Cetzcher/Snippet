using Assets.Scripts.Projectiles;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public class LightningSpell : DamageAbillity
    {
        [SerializeField]
        private float m_distance = 10;

        public Lightning m_lightningPrefab;

        protected override void CastInternal(Character caller)
        {
            var impactDist = caller.transform.forward * m_distance;
            var startPoint = caller.transform.position + caller.transform.forward * 0.5F;

            Lightning lh = Instantiate<Lightning>(m_lightningPrefab);
            lh.transform.position = startPoint;

            RaycastHit rh;
            if (Physics.Raycast(startPoint, transform.forward, out rh, impactDist.magnitude))
            {
                if (rh.collider.gameObject.GetComponentInterface<IHealth>() != null)
                {
                    rh.collider.gameObject.GetComponentInterface<IHealth>().Health -= m_damage;
                }
                impactDist = rh.point;
            }

            lh.Strike(impactDist);

        }
    }
}
