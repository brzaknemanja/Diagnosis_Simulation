using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ActionCardUIView : MonoBehaviour
{
    public Text titleText;
    public Text descriptionText;
    public Text buttonText;

    private ActionDefinition actionDefinition;

    public void Init(ActionDefinition actionDefinition)
    {

        this.actionDefinition = actionDefinition;
        this.titleText.text = actionDefinition.actionName;
        this.descriptionText.text = actionDefinition.actionDescription;
        this.buttonText.text = actionDefinition.GetActionButtonText();
    }

    public void OnActionButtonClick()
    {
        ActionManager.Instance.SendPatienAction(this.actionDefinition);
    }
}
