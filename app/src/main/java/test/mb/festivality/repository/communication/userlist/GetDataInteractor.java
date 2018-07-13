package test.mb.festivality.repository.communication.userlist;



import test.mb.festivality.repository.communication.userlist.interfaces.GetDataListener;

public interface GetDataInteractor {
    void getList(GetDataListener listener);
    void closeConection();
}
