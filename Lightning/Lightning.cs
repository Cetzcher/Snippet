using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts
{
    /// <summary>
    /// Instantaite this class and then immiedietly call Strike
    /// </summary>
    public class Lightning : MonoBehaviour
    {
        private LineRenderer m_render;

        public float m_fadeout = 1; // when complete fadeout happens
        public Color m_color;
        public int m_segments;
        public float m_range;

        private float m_start;

        private void Update()
        {
            m_color.a -= Time.deltaTime * 1.2F;
            m_render.SetColors(m_color, m_color);
            if (Time.time - m_start >= m_fadeout)
                Destroy(this.gameObject);
        }

        public void Strike(Vector3 positon)
        {
            m_start = Time.time;
            m_render = GetComponent<LineRenderer>();
            m_render.SetVertexCount(m_segments);
            m_render.SetColors(m_color, m_color);
            float maxZ = positon.z;
            for (int i = 0; i < m_segments - 1; i++)
            {
                float z = ((float)i * maxZ) / ((float)m_segments - 1);
                m_render.SetPosition(i, new Vector3(UnityEngine.Random.Range(m_range, -m_range), UnityEngine.Random.Range(m_range, -m_range), z));
            }

            m_render.SetPosition(0, new Vector3(0, 0, 0));
            m_render.SetPosition(m_segments - 1, positon);
        }


    }
}
