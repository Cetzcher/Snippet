using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UnityEngine;

namespace Assets.Scripts
{
    public class Player : Character
    {
        protected override void Update()
        {
            base.Update();
            if (Input.GetMouseButtonDown(0))
                CastSelected();
        }
    }
}
