using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class FinishedDiagnosisUIPanel : MonoBehaviour
{
    public Text titleText;
    public Text descriptionText;

    private void Start()
    {
        this.gameObject.SetActive(false);
    }

    private void Refresh()
    {
        var patientData = PatientManager.Instance.patientData;

        if (patientData.currentPatientHealthState == PatientHealthState.Cured)
        {
            titleText.text = "Diagnosis Finished";
            descriptionText.text = "Patient successfully cured!";
            this.gameObject.SetActive(true);
        }
        else if (patientData.currentPatientHealthState == PatientHealthState.Dead)
        {
            titleText.text = "Diagnosis Failed";
            descriptionText.text = "Patient ended up in critical state, other diagnosis team had to take this case.";
            this.gameObject.SetActive(true);
        }      
    }

    public void OnContinueClick()
    {

    }

    private void OnEnable()
    {
        PatientManager.Instance.onPatientHealthStateUpdate += Refresh;
    }
}
