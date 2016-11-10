/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarahbroat
 */
public class HardCodedUserHandler implements UserDataHandler {
    @Override
    public List<User> getUserInformation() {
    List<User> user = new ArrayList();
    user.add(new User("breadprincess", "delilah88"));
    user.add(new User("missmegan77", "candy95"));
    user.add(new User("kymesa", "kingmoses"));

    return user;
}
}
