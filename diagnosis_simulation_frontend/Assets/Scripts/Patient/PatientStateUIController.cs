using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;

public class PatientStateUIController : MonoBehaviour
{
    public Text systolicPressureText;
    public Text diastolicPressureText;
    public Text pulseText;
    public Text oxygenSaturationText;
    public Text temperatureText;

    public Transform symptomsListParent;
    private List<Text> symptomsTexts;

    private void Awake()
    {
        symptomsTexts = symptomsListParent.GetComponentsInChildren<Text>().ToList();
    }

    public void RefreshPatientState()
    {
        var patientData = PatientManager.Instance.patientData;
        systolicPressureText.text = "Systolic: " + patientData.patientState.systolicPressure.ToString();
        diastolicPressureText.text = "Diastolic: " + patientData.patientState.diastolicPressure.ToString();
        pulseText.text = "Pulse: " + patientData.patientState.pulse.ToString();
        oxygenSaturationText.text = "Oxygen: " + patientData.patientState.oxygenSaturation.ToString();
        temperatureText.text = "Temperature: " + patientData.patientState.temperature.ToString();

        RefreshSymptomsList(patientData.symptoms);
    }

    private void RefreshSymptomsList(List<SymptomType> symptomsList)
    {
        for (int i = 0; i < symptomsTexts.Count; i++)
        {
            var text = symptomsTexts[i];
            if (i >= symptomsList.Count)
            {
                text.gameObject.SetActive(false);
                continue;
            }

            text.text = symptomsList[i].ToString();
            text.gameObject.SetActive(true);
        }
    }

    private void OnEnable()
    {
        PatientManager.Instance.onPatientDataRefreshed += RefreshPatientState;
    }

    private void OnDisable()
    {
        PatientManager.Instance.onPatientDataRefreshed -= RefreshPatientState;
    }

}
