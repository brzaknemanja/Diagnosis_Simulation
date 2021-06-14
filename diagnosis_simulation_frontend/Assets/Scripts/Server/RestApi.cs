using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Networking;

public class RestApi : MonobehaviourSingleton<RestApi>
{  
    public void GetRequest(string url, Action<string> onSuccess, Action<string> onFail)
    {
        StartCoroutine(GetRequestCoroutine(url, onSuccess, onFail));
    }

    private IEnumerator GetRequestCoroutine(string url, Action<string> onSuccess, Action<string> onFail)
    {
        var www = UnityWebRequest.Get(url);
        yield return www.SendWebRequest();

        if (www.isNetworkError || www.isNetworkError || www.isHttpError)
        {
            Debug.LogError(www.error);
            if (onFail != null)
            {
                onFail.Invoke(www.error);
            }
        }
        else
        {
            onSuccess(www.downloadHandler.text);
        }
    }

    public void PostRequest(string url, string postData, Action<string> onSuccess, Action<string> onFail)
    {
        StartCoroutine(PostRequestCoroutine(url, postData, onSuccess, onFail));
    }

    private IEnumerator PostRequestCoroutine(string url, string postData, Action<string> onSuccess, Action<string> onFail)
    {
        var www = UnityWebRequest.Post(url, postData);

        SetPostData(www, postData);
        www.SetRequestHeader("Content-Type", "application/json");
        www.SetRequestHeader("Accept", "application/json");
        yield return www.SendWebRequest();

        if (www.isHttpError || www.isNetworkError)
        {
            Debug.LogError(www.error);
            if (onFail != null)
            {
                onFail.Invoke(www.error);
            }
        }
        else
        {
            onSuccess(www.downloadHandler.text);
        }
    }

    private void SetPostData(UnityWebRequest www, string postData)
    {
        if (postData == null)
            return;

        byte[] jsonToSend = new System.Text.UTF8Encoding().GetBytes(postData);
        www.uploadHandler = (UploadHandler)new UploadHandlerRaw(jsonToSend);
        www.downloadHandler = (DownloadHandler)new DownloadHandlerBuffer();
    }
}
