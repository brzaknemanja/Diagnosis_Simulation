using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;

public class ExaminationResultUIController : MonoBehaviour
{
    public Text examinationTitle;
    public Text resultValueText;

    public Transform examinationsListParent;
    private List<Text> examinationsTexts;

    private void Awake()
    {
        examinationsTexts = examinationsListParent.GetComponentsInChildren<Text>().ToList();
    }

    private void Start()
    {
        Toggle(false);
    }

    public void Show(Examination examination)
    {
        examinationTitle.text = examination.examinationType.ToString();
        resultValueText.text = examination.resultValue.ToString();
        resultValueText.gameObject.SetActive(examination.resultValue != 0);

        for (int i = 0; i < examinationsTexts.Count; i++)
        {
            var text = examinationsTexts[i];
            if (i >= examination.results.Count)
            {
                text.gameObject.SetActive(false);
                continue;
            }

            text.text = examination.results[i];
            text.gameObject.SetActive(true);
        }

        Toggle(true);
    }

    public void Toggle(bool toggle)
    {
        this.gameObject.SetActive(toggle);
    }

    private void OnEnable()
    {
        ActionManager.Instance.onExaminationResultArrived += Show;
    }
}
