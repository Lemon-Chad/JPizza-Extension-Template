package jpext;

import lemon.jpizza.Contextuals.Context;
import lemon.jpizza.Objects.Executables.Library;
import lemon.jpizza.Objects.Obj;
import lemon.jpizza.Objects.Primitives.*;
import lemon.jpizza.Results.RTResult;
import lemon.jpizza.Shell;

import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings("unused")
public class LibraryName extends Library {

    public LibraryName(String name) { super(name, "demo"); }

    /*
    To initialize a library, you have to override the initialization method
    The code for this library would be:

                                       Reference to the class
                                              |
                      Name of import          |
                            vvv               ↓
    DemoLibrary.initialize("demo", DemoLibrary.class, new HashMap<>(){{

        put("printDemo", Collections.singletonList("value"));
             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // This should be the name of the function and a list of the argument names

    }});
     */

    public LibraryName(){
        super(null, "libraryName");
    }

    public static void initialize() {
        initialize("demo", LibraryName.class, new HashMap<>(){{
            put("printDemo", Collections.singletonList("value"));
        }});
    }

    public RTResult execute_printDemo(Context execCtx) {
        // Get value arg from variables passed into function
        Obj value = (Obj) execCtx.symbolTable.get("value");
        // Convert value argument to a string type
        value = value.astring();
        // Print value argument
        Shell.logger.outln(value);
        // Return null
        return new RTResult().success(new Null());
    }
}
