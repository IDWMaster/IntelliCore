package IntelliCore;

import java.util.Vector;

/**
 * Created by brian on 2/23/16.
 */
public abstract class IntelliObject {
    IntelliType type;
    public IntelliObject(IntelliType type) {
        this.type = type;
    }
    protected abstract void _Instantiate();
    public final IntelliObject Instantiate() {
        _Instantiate();
        return this;
    }
    Vector<ActionAlias> aliases = new Vector();
    protected void registerAction(String alias, Action action) {
        aliases.add(new ActionAlias(alias,action));
    }
}
