using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;

public class ActionsUIController : MonoBehaviour
{
    public List<ActionCardUIView> actionsCards;

    private ActionType currentTabChoice = ActionType.Examination;

    private void Awake()
    {
        actionsCards = transform.GetComponentsInChildren<ActionCardUIView>().ToList();
        this.gameObject.SetActive(false);
    }

    public void TabButtonClicked(ActionType tabChoice)
    {
        var actionsList = ActionManager.Instance.GetActionsOfType(tabChoice);
        RefreshCardsView(actionsList);
    }

    private void RefreshCardsView(List<ActionDefinition> actionsList)
    {
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

    private void OnEnable()
    {
        TabButtonClicked(currentTabChoice);
    }
}
