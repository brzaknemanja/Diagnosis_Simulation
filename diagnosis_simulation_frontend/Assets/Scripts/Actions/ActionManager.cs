using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ActionManager : MonobehaviourSingleton<ActionManager>
{
    public Action<Examination> onExaminationResultArrived;

    public List<ActionDefinition> GetActionsOfType(ActionType actionType)
    {
        return ActionDefinition.GetActionsOfType(actionType);
    }

    public void SendPatienAction(ActionDefinition actionDefinition)
    {
        string restApi = BackendApiManager.GetActionRestPoint(actionDefinition);
        RestApi.Instance.GetRequest(restApi, OnActionSuccess, OnActionFail);
    }

    private void OnActionSuccess(string data)
    {
        Debug.Log(data);
        PatientManager.Instance.OnRefreshSuccess(data);
        ActionsUIController.Instance.Toggle(false);

        if (onExaminationResultArrived != null)
            onExaminationResultArrived.Invoke(PatientManager.Instance.patientData.lastExamination);
    }

    private void OnActionFail(string data)
    {
        Debug.Log(data);
    }
}
