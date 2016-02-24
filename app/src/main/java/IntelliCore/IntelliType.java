package IntelliCore;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

class IntelliCoreService {
    public static IntelliCoreService instance = new IntelliCoreService();
    public IntelliCoreService() {
    }



    Hashtable<String,IntelliType> types = new Hashtable<String,IntelliType>();
    public void registerAlias(String alias, IntelliType type) {

        types.put(alias,type);
    }
}

class ActionAlias {
    public String alias;
    public Action action;
    public ActionAlias(String alias, Action action) {
        this.action = action;
        this.alias = alias;
    }
}

/**
 * Created by brian on 2/23/16.
 */
public class IntelliType {
    Vector<ActionAlias> actionAliases = new Vector<ActionAlias>();
    public IntelliType() {

    }
    public void registerAction(Action action) {
        action.type = this;
        action.Init();
    }
    public HashSet<String> aliases = new HashSet<String>();
    public void registerAlias(String alias) {
        aliases.add(alias);
        IntelliCoreService.instance.registerAlias(alias, this);
    }
}
