package IntelliCore.CoreFramework;

import IntelliCore.Action;
import IntelliCore.IntelliContext;
import IntelliCore.IntelliObject;
import IntelliCore.IntelliType;



/**
 * Created by brian on 2/23/16.
 */
public class Object extends IntelliType {
    public Object() {
        if(this.getClass() == Object.class) {
            this.registerAlias("object");
        }
        final Object thisptr = this;
        registerAction(new Action() {
            public void Init()
            {
                this.RegisterAlias("create a new");
                this.RegisterAlias("make a");
                this.RegisterAlias("create an");
                this.RegisterAlias("create a");
                RegisterAlias("make a new");

            }
            @Override
            public IntelliObject Perform(IntelliContext context) {
                return Create();
            }
        });

    }
    public IntelliObject Create() {
        return new IntelliObject(this) {
            @Override
            protected void _Instantiate() {

            }
        }.Instantiate();
    }
    public String toString() {
        return "object";
    }
}

