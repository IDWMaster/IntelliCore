package IntelliCore.CoreFramework;

import IntelliCore.IntelliObject;
import IntelliCore.IntelliType;

/**
 * Created by brian on 2/23/16.
 */
public class List extends Object {
    public List() {
        registerAlias("list");
        registerAlias("array");
        registerAlias("collection");
        
    }

    @Override
    public IntelliObject Create() {
        return new IntelliObject(this){
            @Override
            protected void _Instantiate() {

            }
        }.Instantiate();
    }

    public String toString() {
        return "list";
    }
}
