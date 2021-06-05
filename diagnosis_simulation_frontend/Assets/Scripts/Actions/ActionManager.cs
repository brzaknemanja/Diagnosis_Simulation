using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ActionManager : MonobehaviourSingleton<ActionManager>
{
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
    }

    private void OnActionFail(string data)
    {
        Debug.Log(data);
    }
}
