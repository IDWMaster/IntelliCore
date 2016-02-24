package IntelliCore;

import java.util.ArrayList;

class AIInit {
    public AIInit() {
        new IntelliCore.CoreFramework.Object();
        new IntelliCore.CoreFramework.List();
    }
}

public class AIParser {


    static IntelliObject InvokeAction(IntelliType type, IntelliObject instance, ArrayList<String> words) throws Exception {
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<words.size();i++) {
            builder.append(words.get(i)+" ");
        }
        String text = builder.toString();
        for(int i = 0;i<type.actionAliases.size();i++) {
            if(text.startsWith(type.actionAliases.get(i).alias)) {
                //Invoke action
                Action action = type.actionAliases.get(i).action;
                IntelliContext context = new IntelliContext();
                context.text = text.replace(type.actionAliases.get(i).alias,"");
                return action.Perform(context);
            }
        }
        throw new Exception("Sorry. I don't know how to do that to a "+type+".");
    }

    static AIInit init = new AIInit();

    static IntelliContext context = new IntelliContext();

   public static IntelliObject Run(String _txt) throws Exception {

        ArrayList<String> words = new ArrayList();
        String[] _words = _txt.split(" ");
        for(int i = 0;i<_words.length;i++) {
            words.add(_words[i]);
        }


        //String[] words = _txt.split(" ");
        for(int i = words.size()-1;i>=0;i--) {
            //Search for subject
            IntelliType type = IntelliCoreService.instance.types.get(words.get(i));
            if(type != null) {
                //Found subject matter. Invoke action on subject.
                words.remove(i);
                IntelliObject result = InvokeAction(type,null,words);
                return result;
            }
        }

       throw new Exception("Sorry. I couldn't understand what you said.");
    }
}
