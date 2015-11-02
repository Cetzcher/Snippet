using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts.Abilites
{
    public abstract class Abillity : MonoBehaviour
    {

        //
        // Filds
        //


        [SerializeField]
        private float m_manaCost;
        [SerializeField]
        private float m_staminaCost;
        [SerializeField]
        private float m_cooldown;
        [SerializeField]
        private string m_abillityName = "";

        private float m_cooldownStart;

        //
        // Properties
        //

        public float ManaCost
        {
            get { return m_manaCost; }
            private set { m_manaCost = value; }
        }
        public float StaminaCost
        {
            get { return m_staminaCost; }
            private set { m_staminaCost = value; }
        }
        public float Cooldown
        {
            get { return m_cooldown; }
            private set { m_cooldown = value; }
        }
        public string AbillityName
        {
            get { return m_abillityName; }
            private set { m_abillityName = value; }
        }

        //
        // Methiodes
        //

        protected bool IsCooldownPast()
        {
            return m_cooldown + m_cooldownStart <= Time.time;
        }

        /// <summary>
        /// returns cooldown in a value between 1 and 0
        /// </summary>
        protected float CooldownFraction()
        {
            return 0;
        }

        public void Cast(Character caller)
        {
            if (IsCooldownPast())
            {
                if (caller.Mana >= ManaCost && caller.Stamina >= StaminaCost)
                {
                    caller.Mana -= ManaCost;
                    caller.Stamina -= StaminaCost;
                    m_cooldownStart = Time.time;
                    CastInternal(caller);
                }

            }
        }

        protected abstract void CastInternal(Character caller);
    }
}
