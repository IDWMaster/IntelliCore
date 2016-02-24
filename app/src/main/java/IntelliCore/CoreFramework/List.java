package IntelliCore.CoreFramework;

import java.util.ArrayList;

import IntelliCore.AIParser;
import IntelliCore.Action;
import IntelliCore.IntelliContext;
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
        final ArrayList<IntelliObject> list = new ArrayList();
        return new IntelliObject(this){
            @Override
            protected void _Instantiate() {
                registerAction("add", new Action() {
                    @Override
                    public void Init() {

                    }

                    @Override
                    public IntelliObject Perform(IntelliContext context) {
                        try {
                            list.add(AIParser.Run(context.text));
                            return null;
                        } catch (Exception e) {
                            //TODO: Handle exception here. Let the user know about the error.

                            e.printStackTrace();
                            return null;
                        }

                    }
                });
            }
        }.Instantiate();
    }

    public String toString() {
        return "list";
    }
}
