using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;

public class DangerousSituationPanel : MonoBehaviour
{
    public List<ActionCardUIView> actionsCards;
    public Text situationDescription;

    private void Awake()
    {
        actionsCards = transform.GetComponentsInChildren<ActionCardUIView>().ToList();
        PatientManager.Instance.onPatientHealthStateUpdate += Refresh;
        this.gameObject.SetActive(false);
    }

    private void Refresh()
    {
        var patientData = PatientManager.Instance.patientData;
        if (patientData.currentDangerousSituation == SymptomType.None)
        {
            this.gameObject.SetActive(false);
            return;
        }

        situationDescription.text = GetDangerousSituationDescription(patientData.currentDangerousSituation);
        RefreshProcedureList();

        this.gameObject.SetActive(true);
    }

    private void RefreshProcedureList()
    {
        var actionsList = ActionManager.Instance.GetActionsOfType(ActionType.Procedure);
        for (int i = 0; i < actionsCards.Count; i++)
        {
            var actionCard = actionsCards[i];
            if (i >= actionsList.Count)
            {
                actionCard.gameObject.SetActive(false);
                continue;
            }

            actionCard.Init(actionsList[i]);
            actionCard.gameObject.SetActive(true);
        }
    }


    private string GetDangerousSituationDescription(SymptomType symptomType)
    {
        switch (symptomType)
        {
            case SymptomType.CaughingBlood:
                return "Patient is caughing blood!";
                break;
            case SymptomType.LungsStopped:
                return "Patient lungs have stopped!";
                break;
            default:
                return "Patient is in danger!";
        }
    }
}
