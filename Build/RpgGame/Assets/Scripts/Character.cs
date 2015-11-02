using Assets.Scripts.Abilites;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts
{
    [RequireComponent(typeof(CharacterController))]
    public class Character : MonoBehaviour, IHealth
    {

        //
        // Fields
        //

        [SerializeField]
        private string m_characterName;
        [SerializeField]
        private float m_speed;
        [SerializeField]
        private string[] m_subscribedAbillities;

        [SerializeField]
        private float m_mana;
        [SerializeField]
        private float m_health;
        [SerializeField]
        private float m_stamina;


        [SerializeField]
        private float m_MaxMana;
        [SerializeField]
        private float m_MaxHealth;
        [SerializeField]
        private float m_MaxStamina;


        protected List<Abillity> m_abillitys = new List<Abillity>();
        protected int m_abillityPointer = 0;

        //
        // Properties 
        //

        public string CharacterName
        {
            get { return m_characterName; }
            private set { m_characterName = value; }
        }
        public float Speed
        {
            get { return m_speed; }
            private set { m_speed = value; }
        }
        public float Mana
        {
            get { return m_mana; }
            set { m_mana = value; }
        }
        public float Stamina
        {
            get { return m_stamina; }
            set { m_stamina = value; }
        }
        public float Health
        {
            get { return m_health; }
            set { m_health = value; }
        }
        public float MaxHealth
        {
            get { return m_MaxHealth; }
            private set { m_MaxHealth = value; }

        }
        public float MaxStamina
        {
            get { return m_MaxStamina; }
            private set { m_MaxStamina = value; }
        }
        public float MaxMana
        {
            get { return m_MaxMana; }
            private set { m_MaxMana = value; }
        }

        //
        // Methodse
        //

        protected virtual void Start()
        {
            foreach (var s in m_subscribedAbillities)
            {
                m_abillitys.Add(AbillityDb.Instance.GetAbillity(s));
            }
        }

        protected virtual void Update()
        {

        }

        protected void CastSelected()
        {
            if (m_abillitys.Count == 0)
                return;
            m_abillitys[m_abillityPointer].Cast(this);
        }

        protected void NextAbillity()
        {
            m_abillityPointer = Mathf.Clamp(m_abillityPointer + 1, 0, m_abillitys.Count);
        }
        protected void PreviousAbillity()
        {
            m_abillityPointer = Mathf.Clamp(m_abillityPointer - 1, 0, m_abillitys.Count);
        }

    }
}
