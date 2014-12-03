package persistenceDemo.PesistenceInterface;

/**
 * Created by lab on 2014/12/3.
 */
public class ActionBean{
//    主键
    String userId;
//    主键
    String formId;
//    主键
    String clientUrl;
    String localActionId;

    public ActionBean(){}

    public ActionBean(String userId, String formId,String clientUrl) {
        this.userId = userId;
        this.formId = formId;
        this.clientUrl = clientUrl;
    }

    public ActionBean(String userId, String formId, String clientUrl, String localActionId) {
        this.userId = userId;
        this.formId = formId;
        this.clientUrl = clientUrl;
        this.localActionId = localActionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getLocalActionId() {
        return localActionId;
    }

    public void setLocalActionId(String localActionId) {
        this.localActionId = localActionId;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ActionBean)){
            return false;
        }

        ActionBean bean = (ActionBean)o;
        if (!this.userId.equals(bean.getUserId()) || !this.formId.equals(bean.getFormId()) ||
                !this.clientUrl.equals(bean.getClientUrl()))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "ActionBean{" +
                "userId='" + userId + '\'' +
                ", formId='" + formId + '\'' +
                ", clientUrl='" + clientUrl + '\'' +
                ", localActionId='" + localActionId + '\'' +
                '}';
    }
}
