using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites.Projectiles
{
    [RequireComponent(typeof(Rigidbody))]
    public abstract class Projectile : MonoBehaviour
    {
        public float m_damage;
        public float m_timeTilDisappear = 10;

        private float m_startTime;

        protected Abillity Creator
        {
            get;
            private set;
        }

        protected abstract void OnCollionEnter(Collision col);

        protected virtual void Start()
        {
            m_startTime = Time.time;
        }


        protected virtual void Update()
        {
            if (m_startTime + m_timeTilDisappear <= Time.time)
                Destroy(gameObject);
        }
    }
}
