using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PatientManager : MonobehaviourSingleton<PatientManager>
{
    public PatientData patientData;

    public Action onPatientInitialized;
    public Action onPatientDataRefreshed;
    public Action onPatientHealthStateUpdate;

    private void Start()
    {
        RestApi.Instance.GetRequest("localhost:8080/initialize?index=" + PatientData.patientIndex, OnInitSucces, null);
    }

    private void OnInitSucces(string data)
    {
        Debug.Log(data);
        patientData = JsonUtility.FromJson<PatientData>(data);
        Debug.Log(patientData);

        if (onPatientInitialized != null)
            onPatientInitialized.Invoke();

        if (onPatientDataRefreshed != null)
            onPatientDataRefreshed.Invoke();

        StopCoroutine(refreshCoroutine());
        StartCoroutine(refreshCoroutine());
    }

    public void OnSimulateClick()
    {
        RestApi.Instance.GetRequest("localhost:8080/simulate", OnRefreshSuccess, null);
    }

    public void OnRefreshSuccess(string data)
    {
        Debug.Log(data);
        patientData = JsonUtility.FromJson<PatientData>(data);
        Debug.Log(patientData);

        if (onPatientDataRefreshed != null)
            onPatientDataRefreshed.Invoke();

        if (onPatientHealthStateUpdate != null)
            onPatientHealthStateUpdate.Invoke();
    }

    IEnumerator refreshCoroutine()
    {
        while (patientData.currentPatientHealthState == PatientHealthState.Diagnosing)
        {
            yield return new WaitForSeconds(3);
            OnSimulateClick();
        }

        yield return null;
    }

    private void OnDisable()
    {
        StopCoroutine(refreshCoroutine());
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
            OnSimulateClick();
    }
}
