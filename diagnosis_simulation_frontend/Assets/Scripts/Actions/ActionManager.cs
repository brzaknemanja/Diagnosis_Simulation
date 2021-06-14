using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ActionManager : MonobehaviourSingleton<ActionManager>
{
    public Action<Examination> onExaminationResultArrived;

    private ActionDefinition lastAction;

    public List<ActionDefinition> GetActionsOfType(ActionType actionType)
    {
        return ActionDefinition.GetActionsOfType(actionType);
    }

    public void SendPatienAction(ActionDefinition actionDefinition)
    {
        lastAction = actionDefinition;
        string restApi = BackendApiManager.GetActionRestPoint(actionDefinition);
        RestApi.Instance.GetRequest(restApi, OnActionSuccess, OnActionFail);
    }

    private void OnActionSuccess(string data)
    {
        Debug.Log(data);
        PatientManager.Instance.OnRefreshSuccess(data);
        
        if (onExaminationResultArrived != null && (lastAction.actionType == ActionType.Examination ||
            lastAction.actionType == ActionType.Labarathory))
            onExaminationResultArrived.Invoke(PatientManager.Instance.patientData.lastExamination);

        if (lastAction.actionType != ActionType.Procedure)
            ActionsUIController.Instance.Toggle(false);
    }

    private void OnActionFail(string data)
    {
        Debug.Log(data);
    }
}
