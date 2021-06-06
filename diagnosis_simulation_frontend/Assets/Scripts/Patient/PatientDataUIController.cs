using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;

public class PatientDataUIController : MonoBehaviour
{
    public Text ageText;
    public Text genderText;
    public Text weightText;
    public Text heightText;

    public List<PatientFactCardUI> patientFactCards;

    private void Awake()
    {
        patientFactCards = transform.GetComponentsInChildren<PatientFactCardUI>().ToList();
    }

    private void RefreshPatientData()
    {
        var patientData = PatientManager.Instance.patientData;
        ageText.text =  "Age: " + patientData.age.ToString();
        genderText.text = "Gender: " + patientData.gender.ToString();
        weightText.text = "Weight: " + patientData.weight.ToString();
        heightText.text = "Height: " + patientData.height.ToString();

        RefreshCardsView(patientData.patientLifeFacts);
    }

    private void RefreshCardsView(List<PatientLifeFact> patientLifeFacts)
    {
        for (int i = 0; i < patientFactCards.Count; i++)
        {
            var lifeFactCard = patientFactCards[i];
            if (i >= patientLifeFacts.Count)
            {
                lifeFactCard.gameObject.SetActive(false);
                continue;
            }

            lifeFactCard.Init(patientLifeFacts[i]);
            lifeFactCard.gameObject.SetActive(true);
        }
    }


    private void OnEnable()
    {
        PatientManager.Instance.onPatientInitialized += RefreshPatientData;
    }

    private void OnDisable()
    {
        PatientManager.Instance.onPatientInitialized -= RefreshPatientData;
    }

}
