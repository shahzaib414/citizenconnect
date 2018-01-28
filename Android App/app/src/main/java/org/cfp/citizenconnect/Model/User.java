package org.cfp.citizenconnect.Model;

import io.realm.Realm;
import io.realm.RealmObject;

import static org.cfp.citizenconnect.CitizenConnectApplication.realm;

/**
 * Created by shahzaibshahid on 27/01/2018.
 */

public class User extends RealmObject {


    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        realm.executeTransaction(realm -> email = _email);
    }

    String email;
    public  static User getUserInstance(Realm realm){
        User user = realm.where(User.class).findFirst();
        if(user.equals(null)){
            realm.executeTransaction(realm1 -> realm1.createObject(User.class));
        }
        return  user;
    }
}