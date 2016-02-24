package IntelliCore;

/**
 * Created by brian on 2/23/16.
 */
public abstract class Action {
    public Action() {

    }
    public abstract void Init();
    public abstract IntelliObject Perform();
    IntelliType type;
    public void RegisterAlias(String alias) {
        type.actionAliases.add(new ActionAlias(alias,this));
    }

}
