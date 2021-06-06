using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PatientFactCardUI : MonoBehaviour
{
    public Text factName;
    public Text factDetail;
    public Text factDuration;

    public void Init(PatientLifeFact lifeFact)
    {
        factName.text = lifeFact.factName;
        factDuration.text = "Duration: " + lifeFact.duration;

        if (lifeFact.factDetail == "")
            factDetail.text = "Detail: " + "/";
        else
            factDetail.text = "Detail: " + lifeFact.factDetail;
    }
}
